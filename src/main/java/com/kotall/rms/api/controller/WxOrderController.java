package com.kotall.rms.api.controller;

import com.github.binarywang.wxpay.bean.notify.WxPayNotifyResponse;
import com.github.binarywang.wxpay.bean.notify.WxPayOrderNotifyResult;
import com.github.binarywang.wxpay.bean.order.WxPayMpOrderResult;
import com.github.binarywang.wxpay.bean.request.WxPayUnifiedOrderRequest;
import com.github.binarywang.wxpay.bean.result.BaseWxPayResult;
import com.github.binarywang.wxpay.exception.WxPayException;
import com.github.binarywang.wxpay.service.WxPayService;
import com.kotall.rms.api.SystemConfig;
import com.kotall.rms.api.annotation.AppConfig;
import com.kotall.rms.api.annotation.LoginUser;
import com.kotall.rms.common.entity.litemall.*;
import com.kotall.rms.common.integration.express.ExpressService;
import com.kotall.rms.common.integration.express.dao.ExpressInfo;
import com.kotall.rms.common.utils.*;
import com.kotall.rms.core.service.litemall.*;
import com.kotall.rms.core.service.sys.SysAreaService;
import com.kotall.rms.notify.NotifyService;
import com.kotall.rms.notify.NotifyType;
import com.kotall.rms.qcode.QCodeService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;

/*
 * 订单设计
 *
 * 订单状态：
 * 101 订单生成，未支付；102，下单后未支付用户取消；103，下单后未支付超时系统自动取消
 * 201 支付完成，商家未发货；202，订单生产，已付款未发货，但是退款取消；
 * 301 商家发货，用户未确认；
 * 401 用户确认收货； 402 用户没有确认收货超过一定时间，系统自动确认收货；
 *
 * 当101用户未付款时，此时用户可以进行的操作是取消订单，或者付款操作
 * 当201支付完成而商家未发货时，此时用户可以取消订单并申请退款
 * 当301商家已发货时，此时用户可以有确认收货的操作
 * 当401用户确认收货以后，此时用户可以进行的操作是删除订单，评价商品，或者再次购买
 * 当402系统自动确认收货以后，此时用户可以删除订单，评价商品，或者再次购买
 *
 * 目前不支持订单退货和售后服务
 */
@RestController
@RequestMapping("/wx/order")
@Validated
@Slf4j
public class WxOrderController {

    @Autowired
    private PlatformTransactionManager txManager;
    @Autowired
    private LiteMallUserService userService;
    @Autowired
    private LiteMallOrderService orderService;
    @Autowired
    private LiteMallOrderGoodsService orderGoodsService;
    @Autowired
    private LiteMallAddressService addressService;
    @Autowired
    private LiteMallCartService cartService;
    @Autowired
    private SysAreaService regionService;
    @Autowired
    private LiteMallGoodsProductService productService;
    @Autowired
    private WxPayService wxPayService;
    @Autowired
    private NotifyService notifyService;
    @Autowired
    private LiteMallUserFormidService formIdService;
    @Autowired
    private LiteMallGrouponRulesService grouponRulesService;
    @Autowired
    private LiteMallGrouponService grouponService;
    @Autowired
    private QCodeService qCodeService;
    @Autowired
    private ExpressService expressService;
    @Autowired
    private LiteMallCommentService commentService;

    private String detailedAddress(LiteMallAddressEntity litemallAddress) {
        Integer provinceId = litemallAddress.getProvinceId();
        Integer cityId = litemallAddress.getCityId();
        Integer areaId = litemallAddress.getAreaId();
        String provinceName = regionService.getByAreaCode(provinceId).getName();
        String cityName = regionService.getByAreaCode(cityId).getName();
        String areaName = regionService.getByAreaCode(areaId).getName();
        String fullRegion = provinceName + " " + cityName + " " + areaName;
        return fullRegion + " " + litemallAddress.getAddress();
    }

    /**
     * 订单列表
     *
     * @param userId   用户ID
     * @param showType 订单信息
     *                 0， 全部订单
     *                 1，待付款
     *                 2，待发货
     *                 3，待收货
     *                 4，待评价
     * @param page     分页页数
     * @param size     分页大小
     * @return 订单操作结果
     * 成功则
     * {
     * errno: 0,
     * errmsg: '成功',
     * data:
     * {
     * data: xxx ,
     * count: xxx
     * }
     * }
     * 失败则 { code: XXX, msg: XXX }
     */
    @GetMapping("list")
    public Object list(@AppConfig LiteMallAppEntity appConfig,
                       @LoginUser Integer userId,
                       @RequestParam(defaultValue = "0") Integer showType,
                       @RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer size) {
        if (userId == null) {
            return Result.unLogin();
        }

        List<Short> orderStatus = OrderUtil.orderStatus(showType);
        Map<String, Object> params = new HashMap<>();
        params.put("storeId", appConfig.getStoreId());
        params.put("userId", userId);
        params.put("orderStatus", orderStatus);
        params.put("deleted", 0);

        Page<LiteMallOrderEntity> pages = orderService.queryByPage(params);

        List<Map<String, Object>> orderVoList = new ArrayList<>(pages.getRows().size());
        for (LiteMallOrderEntity order : pages.getRows()) {
            Map<String, Object> orderVo = new HashMap<>();
            orderVo.put("id", order.getId());
            orderVo.put("orderSn", order.getOrderSn());
            orderVo.put("actualPrice", order.getActualPrice());
            orderVo.put("orderStatusText", OrderUtil.orderStatusText(order));
            orderVo.put("handleOption", OrderUtil.build(order));

            params = new HashMap<>();
            //params.put("storeId", storeId);
            params.put("orderId", order.getId());
            params.put("orderStatus", orderStatus);
            params.put("deleted", 0);
            LiteMallGrouponEntity groupon = grouponService.queryByOrderId(params);
            if (groupon != null) {
                orderVo.put("isGroupin", true);
            } else {
                orderVo.put("isGroupin", false);
            }

            params = new HashMap<>();
            params.put("storeId", appConfig.getStoreId());
            params.put("orderId", order.getId());
            params.put("deleted", 0);
            List<LiteMallOrderGoodsEntity> orderGoodsList = orderGoodsService.queryByOrderId(params);
            List<Map<String, Object>> orderGoodsVoList = new ArrayList<>(orderGoodsList.size());
            for (LiteMallOrderGoodsEntity orderGoods : orderGoodsList) {
                Map<String, Object> orderGoodsVo = new HashMap<>();
                orderGoodsVo.put("id", orderGoods.getId());
                orderGoodsVo.put("goodsName", orderGoods.getGoodsName());
                orderGoodsVo.put("number", orderGoods.getNumber());
                orderGoodsVo.put("picUrl", orderGoods.getPicUrl());
                orderGoodsVoList.add(orderGoodsVo);
            }
            orderVo.put("goodsList", orderGoodsVoList);

            orderVoList.add(orderVo);
        }

        Map<String, Object> result = new HashMap<>();
        result.put("count", pages.getTotal());
        result.put("data", orderVoList);

        return Result.ok().put("data", result);
    }

    /**
     * 订单详情
     *
     * @param userId  用户ID
     * @param orderId 订单信息
     * @return 订单操作结果
     * 成功则
     * {
     * code: 0,
     * msg: '成功',
     * data:
     * {
     * orderInfo: xxx ,
     * orderGoods: xxx
     * }
     * }
     * 失败则 { code: XXX, msg: XXX }
     */
    @GetMapping("detail")
    public Object detail(@LoginUser Integer userId, @AppConfig LiteMallAppEntity appConfig,@NotNull Integer orderId) {
        if (userId == null) {
            return Result.unLogin();
        }

        // 订单信息
        LiteMallOrderEntity order = orderService.getById(orderId);
        if (null == order) {
            return Result.error(403, "订单不存在");
        }
        if (!order.getUserId().equals(userId)) {
            return Result.error(403, "不是当前用户的订单");
        }
        Map<String, Object> orderVo = new HashMap<>();
        orderVo.put("id", order.getId());
        orderVo.put("orderSn", order.getOrderSn());
        orderVo.put("addTime", order.getAddTime());
        orderVo.put("consignee", order.getConsignee());
        orderVo.put("mobile", order.getMobile());
        orderVo.put("address", order.getAddress());
        orderVo.put("goodsPrice", order.getGoodsPrice());
        orderVo.put("freightPrice", order.getFreightPrice());
        orderVo.put("actualPrice", order.getActualPrice());
        orderVo.put("orderStatusText", OrderUtil.orderStatusText(order));
        orderVo.put("handleOption", OrderUtil.build(order));
        orderVo.put("expCode", order.getShipChannel());
        orderVo.put("expNo", order.getShipSn());

        Map<String, Object> params = new HashMap<>();
        params.put("storeId", appConfig.getStoreId());
        params.put("orderId", order.getId());
        params.put("deleted", 0);
        List<LiteMallOrderGoodsEntity> orderGoodsList = orderGoodsService.queryByOrderId(params);

        Map<String, Object> result = new HashMap<>();
        result.put("orderInfo", orderVo);
        result.put("orderGoods", orderGoodsList);

        // 订单状态为已发货且物流信息不为空
        // "YTO", "800669400640887922"
        if (order.getOrderStatus().equals(OrderUtil.STATUS_SHIP)) {
            ExpressInfo ei = expressService.getExpressInfo(order.getShipChannel(), order.getShipSn());
            result.put("expressInfo", ei);
        }

        return Result.ok().put("data", result);

    }

    /**
     * 提交订单
     * 1. 根据购物车ID、地址ID、优惠券ID，创建订单表项
     * 2. 购物车清空
     * 3. TODO 优惠券设置已用
     * 4. 商品货品数量减少
     *
     * @param userId 用户ID
     * @param body   订单信息，{ cartId：xxx, addressId: xxx, couponId: xxx }
     * @return 订单操作结果
     * 成功则 { code: 0, msg: '成功', data: { orderId: xxx } }
     * 失败则 { code: XXX, msg: XXX }
     */
    @PostMapping("submit")
    public Object submit(@LoginUser Integer userId,
                         @AppConfig LiteMallAppEntity appConfig,
                         @RequestBody String body) {
        if (userId == null) {
            return Result.unLogin();
        }
        if (body == null) {
            return Result.badArgument();
        }
        Integer cartId = JacksonUtil.parseInteger(body, "cartId");
        Integer addressId = JacksonUtil.parseInteger(body, "addressId");
        Integer couponId = JacksonUtil.parseInteger(body, "couponId");
        String message = JacksonUtil.parseString(body, "message");
        Integer grouponRulesId = JacksonUtil.parseInteger(body, "grouponRulesId");
        Integer grouponLinkId = JacksonUtil.parseInteger(body, "grouponLinkId");

        //如果是团购项目,验证活动是否有效
        if (grouponRulesId != null && grouponRulesId > 0) {
            LiteMallGrouponRulesEntity rules = grouponRulesService.getById(grouponRulesId);
            //找不到记录
            if (rules == null) {
                return Result.badArgument();
            }
            //团购活动已经过期
            if (grouponRulesService.isExpired(rules)) {
                return Result.error(402, "团购活动已过期!");
            }
        }

        if (cartId == null || addressId == null || couponId == null) {
            return Result.badArgument();
        }

        // 收货地址
        LiteMallAddressEntity checkedAddress = addressService.getById(addressId);
        if(checkedAddress == null){
            return Result.badArgument();
        }

        // 获取可用的优惠券信息
        // 使用优惠券减免的金额
        BigDecimal couponPrice = new BigDecimal(0.00);

        // 团购优惠
        BigDecimal grouponPrice = new BigDecimal(0.00);
        LiteMallGrouponRulesEntity grouponRules = grouponRulesService.getById(grouponRulesId);
        if (grouponRules != null) {
            grouponPrice = grouponRules.getDiscount();
        }

        // 货品价格
        List<LiteMallCartEntity> checkedGoodsList;
        if (cartId.equals(0)) {
            Map<String, Object> params = new HashMap<>();
            params.put("storeId", appConfig.getStoreId());
            params.put("userId", userId);
            params.put("deleted", 0);
            checkedGoodsList = cartService.queryByList(params);
        } else {
            LiteMallCartEntity cart = cartService.getById(cartId);
            checkedGoodsList = new ArrayList<>(1);
            checkedGoodsList.add(cart);
        }
        if (checkedGoodsList.size() == 0) {
            return Result.badArgumentValue();
        }
        BigDecimal checkedGoodsPrice = new BigDecimal(0.00);
        for (LiteMallCartEntity checkGoods : checkedGoodsList) {
            //  只有当团购规格商品ID符合才进行团购优惠
            if (grouponRules != null && grouponRules.getGoodsId().equals(checkGoods.getGoodsId())) {
                checkedGoodsPrice = checkedGoodsPrice.add(checkGoods.getPrice().subtract(grouponPrice).multiply(new BigDecimal(checkGoods.getNumber())));
            } else {
                checkedGoodsPrice = checkedGoodsPrice.add(checkGoods.getPrice().multiply(new BigDecimal(checkGoods.getNumber())));
            }
        }

        // 根据订单商品总价计算运费，满88则免运费，否则8元；
        BigDecimal freightPrice = new BigDecimal(0.00);
        if (checkedGoodsPrice.compareTo(SystemConfig.getFreightLimit()) < 0) {
            freightPrice = SystemConfig.getFreight();
        }

        // 可以使用的其他钱，例如用户积分
        BigDecimal integralPrice = new BigDecimal(0.00);

        // 订单费用
        BigDecimal orderTotalPrice = checkedGoodsPrice.add(freightPrice).subtract(couponPrice);
        BigDecimal actualPrice = orderTotalPrice.subtract(integralPrice);

        // 开启事务管理
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        TransactionStatus status = txManager.getTransaction(def);
        Integer orderId = null;
        LiteMallOrderEntity order = null;
        try {
            // 订单
            order = new LiteMallOrderEntity();
            order.setStoreId(appConfig.getStoreId());
            order.setUserId(userId);
            order.setOrderSn(orderService.generateOrderSn(userId));
            order.setOrderStatus(new Integer(OrderUtil.STATUS_CREATE));
            order.setConsignee(checkedAddress.getName());
            order.setMobile(checkedAddress.getMobile());
            order.setMessage(message);
            String detailedAddress = detailedAddress(checkedAddress);
            order.setAddress(detailedAddress);
            order.setGoodsPrice(checkedGoodsPrice);
            order.setFreightPrice(freightPrice);
            order.setCouponPrice(couponPrice);
            order.setIntegralPrice(integralPrice);
            order.setOrderPrice(orderTotalPrice);
            order.setActualPrice(actualPrice);

            // 有团购活动
            if (grouponRules != null) {
                order.setGrouponPrice(grouponPrice);    //  团购价格
            } else {
                order.setGrouponPrice(new BigDecimal(0.00));    //  团购价格
            }

            // 添加订单表项
            orderService.save(order);
            orderId = order.getId();

            for (LiteMallCartEntity cartGoods : checkedGoodsList) {
                // 订单商品
                LiteMallOrderGoodsEntity orderGoods = new LiteMallOrderGoodsEntity();
                orderGoods.setOrderId(order.getId());
                orderGoods.setGoodsId(cartGoods.getGoodsId());
                orderGoods.setGoodsSn(cartGoods.getGoodsSn());
                orderGoods.setProductId(cartGoods.getProductId());
                orderGoods.setGoodsName(cartGoods.getGoodsName());
                orderGoods.setPicUrl(cartGoods.getPicUrl());
                orderGoods.setPrice(cartGoods.getPrice());
                orderGoods.setNumber(cartGoods.getNumber());
                orderGoods.setSpecifications(cartGoods.getSpecifications());
                orderGoods.setAddTime(new Date());
                orderGoods.setStoreId(appConfig.getStoreId());
                // 添加订单商品表项
                orderGoodsService.save(orderGoods);
            }

            // 删除购物车里面的商品信息
            Map<String, Object> params = new HashMap<>();
            //params.put("storeId", storeId);
            cartService.clearGoods(userId);

            // 商品货品数量减少
            for (LiteMallCartEntity checkGoods : checkedGoodsList) {
                Integer productId = checkGoods.getProductId();
                LiteMallGoodsProductEntity product = productService.getById(productId);

                Integer remainNumber = product.getNumber() - checkGoods.getNumber();
                if (remainNumber < 0) {
                    throw new RuntimeException("下单的商品货品数量大于库存量");
                }
                product.setNumber(remainNumber);
                if(productService.update(product)){
                    throw new Exception("更新数据失败");
                }
            }

            //如果是团购项目，添加团购信息
            if (grouponRulesId != null && grouponRulesId > 0) {
                LiteMallGrouponEntity groupon = new LiteMallGrouponEntity();
                groupon.setOrderId(orderId);
                groupon.setPayed(0);
                groupon.setStoreId(appConfig.getStoreId());
                groupon.setUserId(userId);
                groupon.setRulesId(grouponRulesId);

                //参与者
                if (grouponLinkId != null && grouponLinkId > 0) {
                    //参与的团购记录
                    LiteMallGrouponEntity baseGroupon = grouponService.getById(grouponLinkId);
                    groupon.setCreatorUserId(baseGroupon.getCreatorUserId());
                    groupon.setGrouponId(grouponLinkId);
                    groupon.setShareUrl(baseGroupon.getShareUrl());
                } else {
                    groupon.setCreatorUserId(userId);
                    groupon.setGrouponId(0);
                }

                grouponService.save(groupon);
            }
        } catch (Exception ex) {
            txManager.rollback(status);
            log.error("系统内部错误", ex);
            return Result.error(403, "下单失败");
        }
        txManager.commit(status);

        Map<String, Object> data = new HashMap<>();
        data.put("orderId", orderId);
        return Result.ok().put("data", data);
    }

    /**
     * 取消订单
     * 1. 检测当前订单是否能够取消
     * 2. 设置订单取消状态
     * 3. 商品货品数量增加
     *
     * @param userId 用户ID
     * @param body   订单信息，{ orderId：xxx }
     * @return 订单操作结果
     * 成功则 { errno: 0, errmsg: '成功' }
     * 失败则 { errno: XXX, errmsg: XXX }
     */
    @PostMapping("cancel")
    public Object cancel(@LoginUser Integer userId,
                         @AppConfig LiteMallAppEntity appConfig,
                         @RequestBody String body) {
        if (userId == null) {
            return Result.unLogin();
        }
        Integer orderId = JacksonUtil.parseInteger(body, "orderId");
        if (orderId == null) {
            return Result.badArgument();
        }

        LiteMallOrderEntity order = orderService.getById(orderId);
        if (order == null) {
            return Result.badArgumentValue();
        }
        if (!order.getUserId().equals(userId)) {
            return Result.badArgumentValue();
        }


        // 检测是否能够取消
        OrderHandleOption handleOption = OrderUtil.build(order);
        if (!handleOption.isCancel()) {
            return Result.error(403, "订单不能取消");
        }

        // 开启事务管理
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        TransactionStatus status = txManager.getTransaction(def);
        try {
            // 设置订单已取消状态
            order.setOrderStatus(new Integer(OrderUtil.STATUS_CANCEL));
            order.setEndTime(new Date());
            if(orderService.update(order)){
                throw new Exception("更新数据已失效");
            }

            // 商品货品数量增加
            Map<String, Object> params = new HashMap<>();
            params.put("storeId", appConfig.getStoreId());
            params.put("orderId", orderId);
            List<LiteMallOrderGoodsEntity> orderGoodsList = orderGoodsService.queryByOrderId(params);
            for (LiteMallOrderGoodsEntity orderGoods : orderGoodsList) {
                Integer productId = orderGoods.getProductId();
                LiteMallGoodsProductEntity product = productService.getById(productId);
                Integer number = product.getNumber() + orderGoods.getNumber();
                product.setNumber(number);
                if(productService.update(product)){
                    throw new Exception("更新数据失败");
                }
            }
        } catch (Exception ex) {
            txManager.rollback(status);
            log.error("系统内部错误", ex);
            return Result.error(403, "订单取消失败");
        }
        txManager.commit(status);

        return Result.ok();
    }

    /**
     * 付款订单的预支付会话标识
     * <p>
     * 1. 检测当前订单是否能够付款
     * 2. 微信支付平台返回支付订单ID
     * 3. 设置订单付款状态
     *
     * @param userId 用户ID
     * @param body   订单信息，{ orderId：xxx }
     * @return 订单操作结果
     * 成功则 { errno: 0, errmsg: '模拟付款支付成功' }
     * 失败则 { errno: XXX, errmsg: XXX }
     */
    @PostMapping("prepay")
    public Object prepay(@LoginUser Integer userId,
                         @AppConfig LiteMallAppEntity appConfig,
                         @RequestBody String body,
                         HttpServletRequest request) {
        if (userId == null) {
            return Result.unLogin();
        }
        Integer orderId = JacksonUtil.parseInteger(body, "orderId");
        if (orderId == null) {
            return Result.badArgument();
        }

        LiteMallOrderEntity order = orderService.getById(orderId);
        if (order == null) {
            return Result.badArgumentValue();
        }
        if (!order.getUserId().equals(userId)) {
            return Result.badArgumentValue();
        }

        // 检测是否能够取消
        OrderHandleOption handleOption = OrderUtil.build(order);
        if (!handleOption.isPay()) {
            return Result.error(403, "订单不能支付");
        }

        LiteMallUserEntity user = userService.getById(userId);
        String openid = user.getWeixinOpenid();
        if (openid == null) {
            return Result.error(403, "订单不能支付");
        }
        WxPayMpOrderResult result;
        try {
            WxPayUnifiedOrderRequest orderRequest = new WxPayUnifiedOrderRequest();
            orderRequest.setOutTradeNo(order.getOrderSn());
            orderRequest.setOpenid(openid);
            orderRequest.setBody("订单：" + order.getOrderSn());
            // 元转成分
            Integer fee = 0;
            BigDecimal actualPrice = order.getActualPrice();
            fee = actualPrice.multiply(new BigDecimal(100)).intValue();
            orderRequest.setTotalFee(fee);
            orderRequest.setSpbillCreateIp(IpUtil.getIpAddr(request));

            result = wxPayService.createOrder(orderRequest);

            //缓存prepayID用于后续模版通知
            String prepayId = result.getPackageValue();
            prepayId = prepayId.replace("prepay_id=", "");
            LiteMallUserFormidEntity userFormid = new LiteMallUserFormidEntity();
            userFormid.setOpenid(user.getWeixinOpenid());
            userFormid.setFormid(prepayId);
            userFormid.setIsprepay(1);
            userFormid.setUseamount(3);
            userFormid.setStoreId(appConfig.getStoreId());
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            calendar.add(Calendar.DAY_OF_MONTH, 7);

            userFormid.setExpireTime(calendar.getTime());
            formIdService.save(userFormid);

        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(403, "订单不能支付");
        }

        if(orderService.update(order)){
            return Result.updatedDateExpired();
        }
        return Result.ok().put("data", result);
    }

    /**
     * 付款成功回调接口
     * 1. 检测当前订单是否是付款状态
     * 2. 设置订单付款成功状态相关信息
     * 3. 响应微信支付平台
     *
     * @param request
     * @param response
     * @return 订单操作结果
     * 成功则 WxPayNotifyResponse.success的XML内容
     * 失败则 WxPayNotifyResponse.fail的XML内容
     * <p>
     * 注意，这里pay-notify是示例地址，开发者应该设立一个隐蔽的回调地址
     */
    @PostMapping("pay-notify")
    public Object payNotify(@AppConfig LiteMallAppEntity appConfig,HttpServletRequest request, HttpServletResponse response) {
        String xmlResult = null;
        try {
            xmlResult = IOUtils.toString(request.getInputStream(), request.getCharacterEncoding());
        } catch (IOException e) {
            e.printStackTrace();
            return WxPayNotifyResponse.fail(e.getMessage());
        }

        WxPayOrderNotifyResult result;
        try {
            result = wxPayService.parseOrderNotifyResult(xmlResult);
        } catch (WxPayException e) {
            e.printStackTrace();
            return WxPayNotifyResponse.fail(e.getMessage());
        }

        log.info("处理腾讯支付平台的订单支付: {}", result);

        String orderSn = result.getOutTradeNo();
        String payId = result.getTransactionId();

        // 分转化成元
        String totalFee = BaseWxPayResult.fenToYuan(result.getTotalFee());
        Map<String, Object> params = new HashMap<>();
        params.put("storeId", appConfig.getStoreId());
        params.put("orderSn", orderSn);
        LiteMallOrderEntity order = orderService.findOrderBySn(params);
        if (order == null) {
            return WxPayNotifyResponse.fail("订单不存在 sn=" + orderSn);
        }

        // 检查这个订单是否已经处理过
        if (OrderUtil.isPayStatus(order) && order.getPayId() != null) {
            return WxPayNotifyResponse.success("订单已经处理成功!");
        }

        // 检查支付订单金额
        if (!totalFee.equals(order.getActualPrice().toString())) {
            return WxPayNotifyResponse.fail(order.getOrderSn() + " : 支付金额不符合 totalFee=" + totalFee);
        }

        order.setPayId(payId);
        order.setPayTime(new Date());
        order.setOrderStatus(new Integer(OrderUtil.STATUS_PAY));
        if (orderService.update(order)) {
            // 这里可能存在这样一个问题，用户支付和系统自动取消订单发生在同时
            // 如果数据库首先因为系统自动取消订单而更新了订单状态；
            // 此时用户支付完成回调这里也要更新数据库，而由于乐观锁机制这里的更新会失败
            // 因此，这里会重新读取数据库检查状态是否是订单自动取消，如果是则更新成支付状态。
            params = new HashMap<>();
            //params.put("storeId", storeId);
            params.put("orderSn", orderSn);
            order = orderService.findOrderBySn(params);
            boolean updated = false;
            if(OrderUtil.isAutoCancelStatus(order)){
                order.setPayId(payId);
                order.setPayTime(new Date());
                order.setOrderStatus(new Integer(OrderUtil.STATUS_PAY));
                updated = orderService.update(order);
            }

            // 如果updated是0，那么数据库更新失败
            if(!updated) {
                return WxPayNotifyResponse.fail("更新数据已失效");
            }
        }

        //  支付成功，有团购信息，更新团购信息
        params = new HashMap<>();
        params.put("storeId", appConfig.getStoreId());
        params.put("orderId", order.getId());
        LiteMallGrouponEntity groupon = grouponService.queryByOrderId(params);
        if (groupon != null) {
            LiteMallGrouponRulesEntity grouponRules = grouponRulesService.getById(groupon.getRulesId());

            //仅当发起者才创建分享图片
            if (groupon.getGrouponId() == 0) {
                String url = qCodeService.createGrouponShareImage(grouponRules.getGoodsName(), grouponRules.getPicUrl(), groupon);
                groupon.setShareUrl(url);
            }
            groupon.setPayed(1);
            if (grouponService.update(groupon)) {
                return WxPayNotifyResponse.fail("更新数据已失效");
            }
        }

        //TODO 发送邮件和短信通知，这里采用异步发送
        // 订单支付成功以后，会发送短信给用户，以及发送邮件给管理员
        notifyService.notifyMail("新订单通知", order.toString());
        // 这里微信的短信平台对参数长度有限制，所以将订单号只截取后6位
        notifyService.notifySmsTemplateSync(order.getMobile(), NotifyType.PAY_SUCCEED, new String[]{orderSn.substring(8, 14)});

        // 请依据自己的模版消息配置更改参数
        String[] parms = new String[]{
                order.getOrderSn(),
                order.getOrderPrice().toString(),
                DateTimeUtil.getDateTimeDisplayString(order.getAddTime()),
                order.getConsignee(),
                order.getMobile(),
                order.getAddress()
        };

        notifyService.notifyWxTemplate(result.getOpenid(), NotifyType.PAY_SUCCEED, parms, "pages/index/index?orderId=" + order.getId());

        return WxPayNotifyResponse.success("处理成功!");
    }

    /**
     * 订单申请退款
     * 1. 检测当前订单是否能够退款
     * 2. 设置订单申请退款状态
     *
     * @param userId 用户ID
     * @param body   订单信息，{ orderId：xxx }
     * @return 订单操作结果
     * 成功则 { errno: 0, errmsg: '成功' }
     * 失败则 { errno: XXX, errmsg: XXX }
     */
    @PostMapping("refund")
    public Object refund(@LoginUser Integer userId,
                         @AppConfig LiteMallAppEntity appConfig,
                         @RequestBody String body) {
        if (userId == null) {
            return Result.unLogin();
        }
        Integer orderId = JacksonUtil.parseInteger(body, "orderId");
        if (orderId == null) {
            return Result.badArgument();
        }

        LiteMallOrderEntity order = orderService.getById(orderId);
        if (order == null) {
            return Result.badArgument();
        }
        if (!order.getUserId().equals(userId)) {
            return Result.badArgumentValue();
        }

        OrderHandleOption handleOption = OrderUtil.build(order);
        if (!handleOption.isRefund()) {
            return Result.error(403, "订单不能取消");
        }

        // 设置订单申请退款状态
        order.setOrderStatus(new Integer(OrderUtil.STATUS_REFUND));
        if(orderService.update(order)){
            return Result.updatedDateExpired();
        }

        //TODO 发送邮件和短信通知，这里采用异步发送
        // 有用户申请退款，邮件通知运营人员
        notifyService.notifyMail("退款申请", order.toString());

        return Result.ok();
    }

    /**
     * 确认收货
     * 1. 检测当前订单是否能够确认订单
     * 2. 设置订单确认状态
     *
     * @param userId 用户ID
     * @param body   订单信息，{ orderId：xxx }
     * @return 订单操作结果
     * 成功则 { errno: 0, errmsg: '成功' }
     * 失败则 { errno: XXX, errmsg: XXX }
     */
    @PostMapping("confirm")
    public Object confirm(@LoginUser Integer userId,
                          @AppConfig LiteMallAppEntity appConfig,
                          @RequestBody String body) {
        if (userId == null) {
            return Result.unLogin();
        }
        Integer orderId = JacksonUtil.parseInteger(body, "orderId");
        if (orderId == null) {
            return Result.badArgument();
        }

        LiteMallOrderEntity order = orderService.getById(orderId);
        if (order == null) {
            return Result.badArgument();
        }
        if (!order.getUserId().equals(userId)) {
            return Result.badArgumentValue();
        }

        OrderHandleOption handleOption = OrderUtil.build(order);
        if (!handleOption.isConfirm()) {
            return Result.error(403, "订单不能确认收货");
        }

        Map<String, Object> params = new HashMap<>();
        params.put("storeId", appConfig.getStoreId());
        params.put("orderId", orderId);
        params.put("deleted", 0);
        Integer comments = orderGoodsService.countCommentIds(params);
        order.setComments(comments);

        order.setOrderStatus(new Integer(OrderUtil.STATUS_CONFIRM));
        order.setConfirmTime(new Date());
        if(orderService.update(order)){
            return Result.updatedDateExpired();
        }
        return Result.ok();
    }

    /**
     * 删除订单
     * 1. 检测当前订单是否删除
     * 2. 设置订单删除状态
     *
     * @param userId 用户ID
     * @param body   订单信息，{ orderId：xxx }
     * @return 订单操作结果
     * 成功则 { errno: 0, errmsg: '成功' }
     * 失败则 { errno: XXX, errmsg: XXX }
     */
    @PostMapping("delete")
    public Object delete(@LoginUser Integer userId, @RequestBody String body) {
        if (userId == null) {
            return Result.unLogin();
        }
        Integer orderId = JacksonUtil.parseInteger(body, "orderId");
        if (orderId == null) {
            return Result.badArgument();
        }

        LiteMallOrderEntity order = orderService.getById(orderId);
        if (order == null) {
            return Result.badArgument();
        }
        if (!order.getUserId().equals(userId)) {
            return Result.badArgumentValue();
        }

        OrderHandleOption handleOption = OrderUtil.build(order);
        if (!handleOption.isDelete()) {
            return Result.error(403, "订单不能删除");
        }

        // 订单order_status没有字段用于标识删除
        // 而是存在专门的delete字段表示是否删除
        orderService.deleteById(orderId);

        return Result.ok();
    }

    /**
     * 可以评价的订单商品信息
     *
     * @param userId  用户ID
     * @param orderId 订单ID
     * @param goodsId 商品ID
     * @return 订单操作结果
     * 成功则 { errno: 0, errmsg: '成功', data: xxx }
     * 失败则 { errno: XXX, errmsg: XXX }
     */
    @GetMapping("goods")
    public Object goods(@LoginUser Integer userId,
                        @AppConfig LiteMallAppEntity appConfig,
                        @NotNull Integer orderId,
                        @NotNull Integer goodsId) {
        if (userId == null) {
            return Result.unLogin();
        }

        Map<String, Object> params = new HashMap<>();
		params.put("storeId", appConfig.getStoreId());
		params.put("orderId", orderId);
		params.put("goodsId", goodsId);
        List<LiteMallOrderGoodsEntity> orderGoodsList = orderGoodsService.queryByList(params);
        int size = orderGoodsList.size();

        Assert.state(size < 2, "存在多个符合条件的订单商品");

        if (size == 0) {
            return Result.badArgumentValue();
        }

        LiteMallOrderGoodsEntity orderGoods = orderGoodsList.get(0);
        return Result.ok().put("data", orderGoods);
    }

    /**
     * 评价订单商品
     * 确认商品收货后7天内可以评价
     *
     * @param userId 用户ID
     * @param body   订单信息，{ orderId：xxx }
     * @return 订单操作结果
     * 成功则 { errno: 0, errmsg: '成功' }
     * 失败则 { errno: XXX, errmsg: XXX }
     */
    @PostMapping("comment")
    public Object comment(@LoginUser Integer userId, @RequestBody String body) {
        if (userId == null) {
            return Result.unLogin();
        }

        Integer orderGoodsId = JacksonUtil.parseInteger(body, "orderGoodsId");
        if(orderGoodsId == null){
            return Result.badArgument();
        }
        LiteMallOrderGoodsEntity orderGoods = orderGoodsService.getById(orderGoodsId);
        if(orderGoods == null){
            return Result.badArgumentValue();
        }
        Integer orderId =  orderGoods.getOrderId();
        LiteMallOrderEntity order = orderService.getById(orderId);
        if(order == null){
            return Result.badArgumentValue();
        }
        Integer orderStatus = order.getOrderStatus();
        if(!OrderUtil.isConfirmStatus(order) && !OrderUtil.isAutoConfirmStatus(order)) {
            return Result.error(404, "当前商品不能评价");
        }
        if(!order.getUserId().equals(userId)){
            return Result.error(404, "当前商品不属于用户");
        }
        Integer commentId = orderGoods.getComment();
        if(commentId == -1){
            return Result.error(404, "当前商品评价时间已经过期");
        }
        if(commentId != 0){
            return Result.error(404, "订单商品已评价");
        }

        String content = JacksonUtil.parseString(body, "content");
        Integer star = JacksonUtil.parseInteger(body, "star");
        if(star == null || star < 0 || star > 5){
            return Result.badArgumentValue();
        }
        Boolean hasPicture = JacksonUtil.parseBoolean(body, "hasPicture");
        List<String> picUrls = JacksonUtil.parseStringList(body, "picUrls");
        if(hasPicture == null || !hasPicture){
            picUrls = new ArrayList<>(0);
        }

        // 1. 创建评价
        LiteMallCommentEntity comment = new LiteMallCommentEntity();
        comment.setUserId(userId);
        comment.setValueId(orderGoods.getGoodsId());
        comment.setType(1);
        comment.setContent(content);
        comment.setHasPicture(hasPicture ? 1 : 0);
        //comment.setPicUrls(picUrls.toArray(new String[]));
        commentService.save(comment);

        // 2. 更新订单商品的评价列表
        orderGoods.setComment(comment.getId());
        orderGoodsService.update(orderGoods);

        // 3. 更新订单中未评价的订单商品可评价数量
        Integer commentCount = order.getComments();
        if(commentCount > 0){
            commentCount--;
        }
        order.setComments(commentCount);
        orderService.update(order);

        return Result.ok();
    }

}