package com.kotall.rms.api.controller;

import com.alibaba.fastjson.JSONObject;
import com.kotall.rms.api.annotation.AppConfig;
import com.kotall.rms.common.entity.litemall.LiteMallAppEntity;
import com.kotall.rms.common.entity.litemall.LiteMallGoodsEntity;
import com.kotall.rms.common.entity.litemall.LiteMallTopicEntity;
import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Result;
import com.kotall.rms.core.service.litemall.LiteMallGoodsService;
import com.kotall.rms.core.service.litemall.LiteMallTopicService;
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
@RequestMapping("/wx/topic")
@Validated
@Slf4j
public class WxTopicController {

    @Autowired
    private LiteMallTopicService topicService;
    @Autowired
    private LiteMallGoodsService goodsService;

    /**
     * 专题列表
     *
     * @param page 分页页数
     * @param size 分页大小
     * @return 专题列表
     * 成功则
     * {
     * code: 0,
     * msg: '成功',
     * data:
     * {
     * data: xxx,
     * count: xxx
     * }
     * }
     * 失败则 { code: XXX, msg: XXX }
     */
    @GetMapping("list")
    public Object list(@AppConfig LiteMallAppEntity appConfig,
                       @RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer size,
                       @RequestParam(defaultValue = "add_time") String sort,
                       @RequestParam(defaultValue = "desc") String order) {
        Map<String, Object> params = new HashMap<>();
        params.put("storeId", appConfig.getStoreId());
        params.put("pageNumber", page);
        params.put("pageSize", size);
        Page<LiteMallTopicEntity> pages = topicService.queryByPage(params);
        Map<String, Object> data = new HashMap<>();
        data.put("data", pages.getRows());
        data.put("count", pages.getTotal());
        return Result.ok().put("data", data);
    }

    /**
     * 专题详情
     *
     * @param id 专题ID
     * @return 专题详情
     * 成功则
     * {
     * code: 0,
     * msg: '成功',
     * data: xxx
     * }
     * 失败则 { code: XXX, msg: XXX }
     */
    @GetMapping("detail")
    public Object detail(@NotNull Integer id) {
        Map<String, Object> data = new HashMap<>();
        LiteMallTopicEntity topic = topicService.getById(id);
        data.put("topic", topic);
        List<LiteMallGoodsEntity> goods = new ArrayList<>();
        List<Integer> goodsIds = JSONObject.parseArray(topic.getGoods(), Integer.class);
        for (Integer goodsId : goodsIds) {
            LiteMallGoodsEntity good = goodsService.getById(goodsId);
            if (null != good)
                goods.add(good);
        }
        data.put("goods", goods);
        return Result.ok().put("data", data);
    }

    /**
     * 相关专题
     *
     * @param id 专题ID
     * @return 相关专题
     * 成功则
     * {
     * code: 0,
     * msg: '成功',
     * data: xxx
     * }
     * 失败则 { code: XXX, msg: XXX }
     */
    @GetMapping("related")
    public Object related(@NotNull Integer id) {
        List<LiteMallTopicEntity> topicRelatedList = topicService.queryRelatedTopicList(id);
        return Result.ok().put("data", topicRelatedList);
    }
}