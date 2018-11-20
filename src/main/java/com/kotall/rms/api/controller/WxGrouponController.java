package com.kotall.rms.api.controller;

import com.kotall.rms.api.annotation.LoginUser;
import com.kotall.rms.common.entity.litemall.*;
import com.kotall.rms.common.integration.express.ExpressService;
import com.kotall.rms.common.integration.express.dao.ExpressInfo;
import com.kotall.rms.common.utils.OrderUtil;
import com.kotall.rms.common.utils.Result;
import com.kotall.rms.core.service.litemall.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/wx/groupon")
@Validated
@Slf4j
public class WxGrouponController {

    @Autowired
    private LiteMallGrouponRulesService rulesService;
    @Autowired
    private LiteMallGrouponService grouponService;
    @Autowired
    private LiteMallGoodsService goodsService;
    @Autowired
    private LiteMallOrderService orderService;
    @Autowired
    private LiteMallOrderGoodsService orderGoodsService;
    @Autowired
    private LiteMallUserService userService;
    @Autowired
    private ExpressService expressService;
    @Autowired
    private LiteMallGrouponRulesService grouponRulesService;


    /**
     * 专题列表
     *
     * @param page 分页页数
     * @param size 分页大小
     * @return 专题列表
     * 成功则
     * {
     * errno: 0,
     * errmsg: '成功',
     * data:
     * {
     * data: xxx,
     * count: xxx
     * }
     * }
     * 失败则 { errno: XXX, errmsg: XXX }
     */
    @GetMapping("list")
    public Object list(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer size,
                       @RequestParam(defaultValue = "add_time") String sort,
                       @RequestParam(defaultValue = "desc") String order) {
        Object topicList = grouponRulesService.queryList(page, size, sort, order);
        int total = grouponRulesService.countList(page, size, sort, order);
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("data", topicList);
        data.put("count", total);
        return Result.ok().put("data", data);
    }

    @GetMapping("detail")
    public Object detail(@LoginUser Integer userId, @NotNull Integer grouponId) {
        if (userId == null) {
            return Result.unlogin();
        }

        LiteMallGrouponEntity groupon = grouponService.getLiteMallGrouponById(new Long(grouponId));
        if (groupon == null) {
            return Result.badArgumentValue();
        }

        LiteMallGrouponRulesEntity rules = rulesService.getLiteMallGrouponRulesById(new Long(groupon.getRulesId()));
        if (rules == null) {
            return Result.badArgumentValue();
        }

        // 订单信息
        LiteMallOrderEntity order = orderService.getLiteMallOrderById(new Long(groupon.getOrderId()));
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

        List<LiteMallOrderGoodsEntity> orderGoodsList = orderGoodsService.queryByOid(order.getId());
        List<Map<String, Object>> orderGoodsVoList = new ArrayList<>(orderGoodsList.size());
        for (LiteMallOrderGoodsEntity orderGoods : orderGoodsList) {
            Map<String, Object> orderGoodsVo = new HashMap<>();
            orderGoodsVo.put("id", orderGoods.getId());
            orderGoodsVo.put("orderId", orderGoods.getOrderId());
            orderGoodsVo.put("goodsId", orderGoods.getGoodsId());
            orderGoodsVo.put("goodsName", orderGoods.getGoodsName());
            orderGoodsVo.put("number", orderGoods.getNumber());
            orderGoodsVo.put("retailPrice", orderGoods.getPrice());
            orderGoodsVo.put("picUrl", orderGoods.getPicUrl());
            orderGoodsVo.put("goodsSpecificationValues", orderGoods.getSpecifications());
            orderGoodsVoList.add(orderGoodsVo);
        }

        Map<String, Object> result = new HashMap<>();
        result.put("orderInfo", orderVo);
        result.put("orderGoods", orderGoodsVoList);

        // 订单状态为已发货且物流信息不为空
        //"YTO", "800669400640887922"
        if (order.getOrderStatus().equals(OrderUtil.STATUS_SHIP)) {
            ExpressInfo ei = expressService.getExpressInfo(order.getShipChannel(), order.getShipSn());
            result.put("expressInfo", ei);
        }

        UserVo creator = userService.findUserVoById(groupon.getCreatorUserId());
        List<UserVo> joiners = new ArrayList<>();
        joiners.add(creator);
        int linkGrouponId;
        // 这是一个团购发起记录
        if (groupon.getGrouponId() == 0) {
            linkGrouponId = groupon.getId();
        } else {
            linkGrouponId = groupon.getGrouponId();

        }
        List<LiteMallGrouponEntity> groupons = grouponService.queryJoinRecord(linkGrouponId);

        UserVo joiner;
        for (LiteMallGrouponEntity grouponItem : groupons) {
            joiner = userService.findUserVoById(grouponItem.getUserId());
            joiners.add(joiner);
        }

        result.put("linkGrouponId", linkGrouponId);
        result.put("creator", creator);
        result.put("joiners", joiners);
        result.put("groupon", groupon);
        result.put("rules", rules);
        return Result.ok().put("data", result);
    }

    @GetMapping("join")
    public Object join(@NotNull Integer grouponId) {
        LiteMallGrouponEntity groupon = grouponService.getLiteMallGrouponById(new Long(grouponId));
        if (groupon == null) {
            return Result.badArgumentValue();
        }

        LiteMallGrouponRulesEntity rules = rulesService.getLiteMallGrouponRulesById(new Long(groupon.getRulesId()));
        if (rules == null) {
            return Result.badArgumentValue();
        }

        LiteMallGoodsEntity goods = goodsService.getLiteMallGoodsById(new Long(rules.getGoodsId()));
        if (goods == null) {
            return Result.badArgumentValue();
        }

        Map<String, Object> result = new HashMap<>();
        result.put("groupon", groupon);
        result.put("goods", goods);

        return Result.ok().put("data", result);
    }

    @GetMapping("my")
    public Object my(@LoginUser Integer userId, @RequestParam(defaultValue = "0") Integer showType) {
        if (userId == null) {
            return Result.unlogin();
        }

        List<LiteMallGrouponEntity> myGroupons;
        if (showType == 0) {
            myGroupons = grouponService.queryMyGroupon(userId);
        } else {
            myGroupons = grouponService.queryMyJoinGroupon(userId);
        }

        List<Map<String, Object>> grouponVoList = new ArrayList<>(myGroupons.size());

        LiteMallOrderEntity order;
        LiteMallGrouponRulesEntity rules;
        LiteMallUserEntity creator;
        for (LiteMallGrouponEntity groupon : myGroupons) {
            order = orderService.getLiteMallOrderById(new Long(groupon.getOrderId()));
            rules = rulesService.getLiteMallGrouponRulesById(new Long(groupon.getRulesId()));
            creator = userService.getLiteMallUserById(new Long(groupon.getCreatorUserId()));

            Map<String, Object> grouponVo = new HashMap<>();
            //填充团购信息
            grouponVo.put("id", groupon.getId());
            grouponVo.put("groupon", groupon);
            grouponVo.put("rules", rules);
            grouponVo.put("creator", creator.getNickname());

            int linkGrouponId;
            // 这是一个团购发起记录
            if (groupon.getGrouponId() == 0) {
                linkGrouponId = groupon.getId();
                grouponVo.put("isCreator", creator.getId() == userId);
            } else {
                linkGrouponId = groupon.getGrouponId();
                grouponVo.put("isCreator", false);
            }
            int joinerCount = grouponService.countGroupon(linkGrouponId);
            grouponVo.put("joinerCount", joinerCount + 1);

            //填充订单信息
            grouponVo.put("orderId", order.getId());
            grouponVo.put("orderSn", order.getOrderSn());
            grouponVo.put("actualPrice", order.getActualPrice());
            grouponVo.put("orderStatusText", OrderUtil.orderStatusText(order));
            grouponVo.put("handleOption", OrderUtil.build(order));

            List<LiteMallOrderGoodsEntity> orderGoodsList = orderGoodsService.queryByOid(order.getId());
            List<Map<String, Object>> orderGoodsVoList = new ArrayList<>(orderGoodsList.size());
            for (LiteMallOrderGoodsEntity orderGoods : orderGoodsList) {
                Map<String, Object> orderGoodsVo = new HashMap<>();
                orderGoodsVo.put("id", orderGoods.getId());
                orderGoodsVo.put("goodsName", orderGoods.getGoodsName());
                orderGoodsVo.put("number", orderGoods.getNumber());
                orderGoodsVo.put("picUrl", orderGoods.getPicUrl());
                orderGoodsVoList.add(orderGoodsVo);
            }
            grouponVo.put("goodsList", orderGoodsVoList);
            grouponVoList.add(grouponVo);
        }

        Map<String, Object> result = new HashMap<>();
        result.put("count", grouponVoList.size());
        result.put("data", grouponVoList);

        return Result.ok(result);
    }

    @GetMapping("query")
    public Object query(@NotNull Integer goodsId) {
        LiteMallGoodsEntity goods = goodsService.getLiteMallGoodsById(new Long(goodsId));
        if (goods == null) {
            return Result.error(-1, "未找到对应的商品");
        }

        List<LiteMallGrouponRulesEntity> rules = rulesService.queryByGoodsId(goodsId);

        return Result.ok().put("data", rules);
    }
}
