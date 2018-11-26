package com.kotall.rms.api.controller;

import com.kotall.rms.api.SystemConfig;
import com.kotall.rms.api.annotation.AppConfig;
import com.kotall.rms.api.annotation.LoginUser;
import com.kotall.rms.common.entity.litemall.*;
import com.kotall.rms.common.utils.JacksonUtil;
import com.kotall.rms.common.utils.Result;
import com.kotall.rms.core.service.litemall.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/wx/cart")
@Validated
@Slf4j
public class WxCartController {

    @Autowired
    private LiteMallCartService cartService;
    @Autowired
    private LiteMallGoodsService goodsService;
    @Autowired
    private LiteMallGoodsProductService productService;
    @Autowired
    private LiteMallAddressService addressService;
    @Autowired
    private LiteMallGrouponRulesService grouponRulesService;

    /**
     * 购物车
     *
     * @param userId 用户ID
     * @return 购物车
     * 成功则
     * {
     * code: 0,
     * msg: '成功',
     * data:
     * {
     * cartList: xxx,
     * cartTotal: xxx
     * }
     * }
     * 失败则 { code: XXX, msg: XXX }
     */
    @GetMapping("index")
    public Object index(@LoginUser Integer userId, @AppConfig LiteMallAppEntity appConfig) {
        if (userId == null) {
            return Result.unLogin();
        }

        List<LiteMallCartEntity> cartList = cartService.queryByUserId(appConfig.getStoreId(), userId);
        Integer goodsCount = 0;
        BigDecimal goodsAmount = new BigDecimal(0.00);
        Integer checkedGoodsCount = 0;
        BigDecimal checkedGoodsAmount = new BigDecimal(0.00);
        for (LiteMallCartEntity cart : cartList) {
            goodsCount += cart.getNumber();
            goodsAmount = goodsAmount.add(cart.getPrice().multiply(new BigDecimal(cart.getNumber())));
            if (cart.getChecked() > 0) {
                checkedGoodsCount += cart.getNumber();
                checkedGoodsAmount = checkedGoodsAmount.add(cart.getPrice().multiply(new BigDecimal(cart.getNumber())));
            }
        }
        Map<String, Object> cartTotal = new HashMap<>();
        cartTotal.put("goodsCount", goodsCount);
        cartTotal.put("goodsAmount", goodsAmount);
        cartTotal.put("checkedGoodsCount", checkedGoodsCount);
        cartTotal.put("checkedGoodsAmount", checkedGoodsAmount);

        Map<String, Object> result = new HashMap<>();
        result.put("cartList", cartList);
        result.put("cartTotal", cartTotal);

        return Result.ok().put("data", result);
    }

    /**
     * 添加商品加入购物车
     * 如果已经存在购物车货品，则添加数量；
     * 否则添加新的购物车货品项。
     *
     * @param userId 用户ID
     * @param cart   购物车商品信息， { goodsId: xxx, productId: xxx, number: xxx }
     * @return 加入购物车操作结果
     * 成功则
     * {
     * code: 0,
     * msg: '成功',
     * data: xxx
     * }
     * 失败则 { code: XXX, msg: XXX }
     */
    @PostMapping("add")
    public Object add(@LoginUser Integer userId, @AppConfig LiteMallAppEntity appConfig, @RequestBody LiteMallCartEntity cart) {
        if (userId == null) {
            return Result.unLogin();
        }
        if (cart == null) {
            return Result.badArgument();
        }

        Integer productId = cart.getProductId();
        Integer number = cart.getNumber().intValue();
        Integer goodsId = cart.getGoodsId();
        if (!ObjectUtils.allNotNull(productId, number, goodsId)) {
            return Result.badArgument();
        }

        // 判断商品是否可以购买
        LiteMallGoodsEntity goods = goodsService.getById(goodsId);
        if (goods == null || goods.getIsOnSale() == 0) {
            return Result.error(400, "商品已下架");
        }

        LiteMallGoodsProductEntity product = productService.getById(productId);
        // 判断购物车中是否存在此规格商品
        LiteMallCartEntity existCart = cartService.queryExist(appConfig.getStoreId(), goodsId, productId, userId);
        if (existCart == null) {
            // 取得规格的信息,判断规格库存
            if (product == null || number > product.getNumber()) {
                return Result.error(400, "库存不足");
            }

            cart.setId(null);
            cart.setGoodsSn(goods.getGoodsSn());
            cart.setGoodsName((goods.getName()));
            cart.setPicUrl(goods.getPicUrl());
            cart.setPrice(product.getPrice());
            cart.setSpecifications(product.getSpecifications());
            cart.setUserId(userId);
            cart.setChecked(1);
            cartService.save(cart);
        } else {
            //取得规格的信息,判断规格库存
            int num = existCart.getNumber() + number;
            if (num > product.getNumber()) {
                return Result.error(400, "库存不足");
            }
            existCart.setNumber(num);
            if(cartService.update(existCart)){
                return Result.updatedDataFailed();
            }
        }

        return goodscount(userId, appConfig);
    }

    /**
     * 立即购买商品
     * <p>
     * 和 前面一个方法add的区别在于
     * 1. 如果购物车内已经存在购物车货品，前者的逻辑是数量添加，这里的逻辑是数量覆盖
     * 2. 添加成功以后，前者的逻辑是返回当前购物车商品数量，这里的逻辑是返回对应购物车项的ID
     *
     * @param userId 用户ID
     * @param cart   购物车商品信息， { goodsId: xxx, productId: xxx, number: xxx }
     * @return 即购买操作结果
     * 成功则
     * {
     * code: 0,
     * msg: '成功',
     * data: xxx
     * }
     * 失败则 { errno: XXX, errmsg: XXX }
     */
    @PostMapping("fastadd")
    public Object fastadd(@LoginUser Integer userId, @AppConfig LiteMallAppEntity appConfig,@RequestBody LiteMallCartEntity cart) {
        if (userId == null) {
            return Result.unLogin();
        }
        if (cart == null) {
            return Result.badArgument();
        }

        Integer productId = cart.getProductId();
        Integer number = cart.getNumber().intValue();
        Integer goodsId = cart.getGoodsId();
        if (!ObjectUtils.allNotNull(productId, number, goodsId)) {
            return Result.badArgument();
        }

        // 判断商品是否可以购买
        LiteMallGoodsEntity goods = goodsService.getById(goodsId);
        if (goods == null || goods.getIsOnSale() == 0) {
            return Result.error(400, "商品已下架");
        }

        LiteMallGoodsProductEntity product = productService.getById(productId);
        // 判断购物车中是否存在此规格商品
        LiteMallCartEntity existCart = cartService.queryExist(appConfig.getStoreId(), goodsId, productId, userId);
        if (existCart == null) {
            //取得规格的信息,判断规格库存
            if (product == null || number > product.getNumber()) {
                return Result.error(400, "库存不足");
            }

            cart.setId(null);
            cart.setGoodsSn(goods.getGoodsSn());
            cart.setGoodsName((goods.getName()));
            cart.setPicUrl(goods.getPicUrl());
            cart.setPrice(product.getPrice());
            cart.setSpecifications(product.getSpecifications());
            cart.setUserId(userId);
            cart.setChecked(1);
            cartService.save(cart);
        } else {
            //取得规格的信息,判断规格库存
            int num = number;
            if (num > product.getNumber()) {
                return Result.error(400, "库存不足");
            }
            existCart.setNumber(num);
            if(cartService.update(existCart)){
                return Result.updatedDataFailed();
            }
        }

        return Result.ok().put("data", existCart != null ? existCart.getId() : cart.getId());
    }

    /**
     * 更新指定的购物车信息
     * 目前只支持修改商品的数量
     *
     * @param userId 用户ID
     * @param cart   购物车商品信息， { id: xxx, goodsId: xxx, productId: xxx, number: xxx }
     * @return 更新购物车操作结果
     * 成功则 { errno: 0, errmsg: '成功' }
     * 失败则 { errno: XXX, errmsg: XXX }
     */
    @PostMapping("update")
    public Object update(@LoginUser Integer userId, @AppConfig LiteMallAppEntity appConfig, @RequestBody LiteMallCartEntity cart) {
        if (userId == null) {
            return Result.unLogin();
        }
        if (cart == null) {
            return Result.badArgument();
        }
        Integer productId = cart.getProductId();
        Integer number = cart.getNumber().intValue();
        Integer goodsId = cart.getGoodsId();
        Integer id = cart.getId();
        if (!ObjectUtils.allNotNull(id, productId, number, goodsId)) {
            return Result.badArgument();
        }

        //判断是否存在该订单
        // 如果不存在，直接返回错误
        LiteMallCartEntity existCart = cartService.getById(id);
        if (existCart == null) {
            return Result.badArgumentValue();
        }

        // 判断goodsId和productId是否与当前cart里的值一致
        if (!existCart.getGoodsId().equals(goodsId)) {
            return Result.badArgumentValue();
        }
        if (!existCart.getProductId().equals(productId)) {
            return Result.badArgumentValue();
        }

        //判断商品是否可以购买
        LiteMallGoodsEntity goods = goodsService.getById(goodsId);
        if (goods == null || goods.getIsOnSale() == 0) {
            return Result.error(403, "商品已下架");
        }

        //取得规格的信息,判断规格库存
        LiteMallGoodsProductEntity product = productService.getById(productId);
        if (product == null || product.getNumber() < number) {
            return Result.error(403, "库存不足");
        }

        existCart.setNumber(new Integer(number.shortValue()));
        if(cartService.update(existCart)){
            return Result.updatedDataFailed();
        }
        return Result.ok();
    }

    /**
     * 购物车商品勾选
     * 如果原来没有勾选，则设置勾选状态；如果商品已经勾选，则设置非勾选状态。
     *
     * @param userId 用户ID
     * @param body   购物车商品信息， { productIds: xxx, isChecked: 1/0 }
     * @return 购物车信息
     * 成功则
     * {
     * errno: 0,
     * errmsg: '成功',
     * data: xxx
     * }
     * 失败则 { errno: XXX, errmsg: XXX }
     */
    @PostMapping("checked")
    public Object checked(@LoginUser Integer userId, @AppConfig LiteMallAppEntity appConfig, @RequestBody String body) {
        if (userId == null) {
            return Result.unLogin();
        }
        if (body == null) {
            return Result.badArgument();
        }

        List<Integer> productIds = JacksonUtil.parseIntegerList(body, "productIds");
        if (productIds == null) {
            return Result.badArgument();
        }

        Integer checkValue = JacksonUtil.parseInteger(body, "isChecked");
        if (checkValue == null) {
            return Result.badArgument();
        }
        Boolean isChecked = (checkValue == 1);

        cartService.updateCheck(userId, productIds, isChecked);
        return index(userId, appConfig);
    }

    /**
     * 购物车商品删除
     *
     * @param userId 用户ID
     * @param body   购物车商品信息， { productIds: xxx }
     * @return 购物车信息
     * 成功则
     * {
     * code: 0,
     * msg: '成功',
     * data: xxx
     * }
     * 失败则 { code: XXX, msg: XXX }
     */
    @PostMapping("delete")
    public Object delete(@LoginUser Integer userId, @AppConfig LiteMallAppEntity appConfig, @RequestBody String body) {
        if (userId == null) {
            return Result.unLogin();
        }
        if (body == null) {
            return Result.badArgument();
        }

        List<Integer> productIds = JacksonUtil.parseIntegerList(body, "productIds");

        if (productIds == null || productIds.size() == 0) {
            return Result.badArgument();
        }

        cartService.delete(productIds, userId);
        return index(userId, appConfig);
    }

    /**
     * 购物车商品数量
     * 如果用户没有登录，则返回空数据。
     *
     * @param userId 用户ID
     * @return 购物车商品数量
     * 成功则
     * {
     * code: 0,
     * msg: '成功',
     * data: xxx
     * }
     * 失败则 { code: XXX, msg: XXX }
     */
    @GetMapping("goodscount")
    public Object goodscount(@LoginUser Integer userId, @AppConfig LiteMallAppEntity appConfig) {
        if (userId == null) {
            return Result.error(0, "错误");
        }

        int goodsCount = 0;
        List<LiteMallCartEntity> cartList = cartService.queryByUserId(appConfig.getStoreId(), userId);
        for (LiteMallCartEntity cart : cartList) {
            goodsCount += cart.getNumber();
        }

        return Result.ok().put("data", goodsCount);
    }

    /**
     * 购物车下单信息
     *
     * @param userId    用户ID
     * @param cartId    购物车商品ID
     *                  如果购物车商品ID是空，则下单当前用户所有购物车商品；
     *                  如果购物车商品ID非空，则只下单当前购物车商品。
     * @param addressId 收货地址ID
     *                  如果收货地址ID是空，则查询当前用户的默认地址。
     * @param couponId  优惠券ID
     *                  目前不支持
     * @return 购物车下单信息
     * 成功则
     * {
     * errno: 0,
     * errmsg: '成功',
     * data:
     * {
     * addressId: xxx,
     * checkedAddress: xxx,
     * couponId: xxx,
     * checkedCoupon: xxx,
     * goodsTotalPrice: xxx,
     * freightPrice: xxx,
     * couponPrice: xxx,
     * orderTotalPrice: xxx,
     * actualPrice: xxx,
     * checkedGoodsList: xxx
     * }
     * }
     * 失败则 { errno: XXX, errmsg: XXX }
     */
    @GetMapping("checkout")
    public Object checkout(@LoginUser Integer userId, Integer cartId, Integer addressId, Integer couponId, Integer grouponRulesId) {
        if (userId == null) {
            return Result.unLogin();
        }

        // 收货地址
        LiteMallAddressEntity checkedAddress;
        if (addressId == null || addressId.equals(0)) {
            checkedAddress = addressService.getDefault(userId);
            // 如果仍然没有地址，则是没有收获地址
            // 返回一个空的地址id=0，这样前端则会提醒添加地址
            if (checkedAddress == null) {
                checkedAddress = new LiteMallAddressEntity();
                checkedAddress.setId(0);
                addressId = 0;
            } else {
                addressId = checkedAddress.getId();
            }

        } else {
            checkedAddress = addressService.getById(addressId);
            // 如果null, 则报错
            if (checkedAddress == null) {
                return Result.badArgumentValue();
            }
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

        // 商品价格
        List<LiteMallCartEntity> checkedGoodsList;
        if (cartId == null || cartId.equals(0)) {
            checkedGoodsList = cartService.queryByUserIdAndChecked(userId);
        } else {
            LiteMallCartEntity cart = cartService.getById(cartId);
            if (cart == null) {
                return Result.badArgumentValue();
            }
            checkedGoodsList = new ArrayList<>(1);
            checkedGoodsList.add(cart);
        }
        BigDecimal checkedGoodsPrice = new BigDecimal(0.00);
        for (LiteMallCartEntity cart : checkedGoodsList) {
            //  只有当团购规格商品ID符合才进行团购优惠
            if (grouponRules != null && grouponRules.getGoodsId().equals(cart.getGoodsId())) {
                checkedGoodsPrice = checkedGoodsPrice.add(cart.getPrice().subtract(grouponPrice).multiply(new BigDecimal(cart.getNumber())));
            } else {
                checkedGoodsPrice = checkedGoodsPrice.add(cart.getPrice().multiply(new BigDecimal(cart.getNumber())));
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

        Map<String, Object> data = new HashMap<>();
        data.put("addressId", addressId);
        data.put("grouponRulesId", grouponRulesId);
        data.put("grouponPrice", grouponPrice);
        data.put("checkedAddress", checkedAddress);
        data.put("couponId", couponId);
        data.put("checkedCoupon", 0);
        data.put("couponList", "");
        data.put("goodsTotalPrice", checkedGoodsPrice);
        data.put("freightPrice", freightPrice);
        data.put("couponPrice", couponPrice);
        data.put("orderTotalPrice", orderTotalPrice);
        data.put("actualPrice", actualPrice);
        data.put("checkedGoodsList", checkedGoodsList);
        return Result.ok().put("data", data);
    }

    /**
     * 商品优惠券列表
     * 目前不支持
     *
     * @param userId 用户ID
     * @return 商品优惠券信息
     * 成功则
     * {
     * errno: 0,
     * errmsg: '成功',
     * data: xxx
     * }
     * 失败则 { errno: XXX, errmsg: XXX }
     */
    @GetMapping("checkedCouponList")
    public Object checkedCouponList(@LoginUser Integer userId) {
        if (userId == null) {
            return Result.unLogin();
        }
        return Result.unSupport();
    }
}