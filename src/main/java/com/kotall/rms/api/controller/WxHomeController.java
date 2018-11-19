package com.kotall.rms.api.controller;

import com.kotall.rms.api.HomeCacheManager;
import com.kotall.rms.api.SystemConfig;
import com.kotall.rms.api.annotation.AppConfig;
import com.kotall.rms.common.entity.litemall.LiteMallAdEntity;
import com.kotall.rms.common.entity.litemall.LiteMallAppEntity;
import com.kotall.rms.common.entity.litemall.LiteMallCategoryEntity;
import com.kotall.rms.common.utils.Result;
import com.kotall.rms.core.service.litemall.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/wx/home")
@Validated
@Slf4j
public class WxHomeController {

    @Autowired
    private LiteMallAdService adService;
    @Autowired
    private LiteMallOrderGoodsService goodsService;
    @Autowired
    private LiteMallBrandService brandService;
    @Autowired
    private LiteMallTopicService topicService;
    @Autowired
    private LiteMallCategoryService categoryService;
    @Autowired
    private LiteMallGrouponRulesService grouponRulesService;


    @GetMapping("/cache")
    public Object cache(@NotNull String key) {
        if (!key.equals("LiteMall_cache")) {
            return Result.error(-1, "错误");
        }
        // 清除缓存
        HomeCacheManager.clearAll();
        return Result.ok("缓存已清除");
    }

    /**
     * app首页
     *
     * @return app首页相关信息
     * 成功则
     * {
     * code: 0,
     * msg: '成功',
     * data:
     * {
     * banner: xxx,
     * channel: xxx,
     * newGoodsList: xxx,
     * hotGoodsList: xxx,
     * topicList: xxx,
     * grouponList: xxx,
     * floorGoodsList: xxx
     * }
     * }
     * 失败则 { errno: XXX, errmsg: XXX }
     */
    @GetMapping("/index")
    public Object index(@AppConfig LiteMallAppEntity appConfig) {
        // 优先从缓存中读取
        if (HomeCacheManager.hasData(HomeCacheManager.INDEX)) {
            return Result.ok(HomeCacheManager.getCacheData(HomeCacheManager.INDEX));
        }


        Map<String, Object> data = new HashMap<>();

        Map<String, Object> params = new HashMap<>();
        params.put("store_id", appConfig.getStoreId());

        List<LiteMallAdEntity> banner = adService.queryIndex(params);
        data.put("banner", banner);

        params = new HashMap<>();
        params.put("store_id", appConfig.getStoreId());
        List<LiteMallCategoryEntity> channel = categoryService.queryChannel(params);
        data.put("channel", channel);

        // ---------------------------------------------------------------------------------------
        params = new HashMap<>();
        params.put("store_id", appConfig.getStoreId());
        params.put("pageNumber", 0);
        params.put("pageSize", SystemConfig.getNewLimit());
        List<LiteMallAdEntity> newGoods = goodsService.queryByNew(params);
        data.put("newGoodsList", newGoods);

        List<LiteMallAdEntity> hotGoods = goodsService.queryByHot(0, SystemConfig.getHotLimit());
        data.put("hotGoodsList", hotGoods);

        List<LiteMallAdEntity> brandList = brandService.queryVO(0, SystemConfig.getBrandLimit());
        data.put("brandList", brandList);

        List<LiteMallAdEntity> topicList = topicService.queryList(0, SystemConfig.getTopicLimit());
        data.put("topicList", topicList);

        // 团购专区
        List<Map<String, Object>> grouponList = grouponRulesService.queryList(0, 5);
        data.put("grouponList", grouponList);

        List<Map> categoryList = new ArrayList<>();
        List<LiteMallAdEntity> catL1List = categoryService.queryL1WithoutRecommend(0, SystemConfig.getCatlogListLimit());
        for (LiteMallAdEntity catL1 : catL1List) {
            List<LiteMallAdEntity> catL2List = categoryService.queryByPid(catL1.getId());
            List<Integer> l2List = new ArrayList<>();
            for (LiteMallAdEntity catL2 : catL2List) {
                l2List.add(catL2.getId());
            }

            List<LiteMallAdEntity> categoryGoods = null;
            if (l2List.size() == 0) {
                categoryGoods = new ArrayList<>();
            } else {
                categoryGoods = goodsService.queryByCategory(l2List, 0, SystemConfig.getCatlogMoreLimit());
            }

            Map<String, Object> catGoods = new HashMap<String, Object>();
            catGoods.put("id", catL1.getId());
            catGoods.put("name", catL1.getName());
            catGoods.put("goodsList", categoryGoods);
            categoryList.add(catGoods);
        }
        data.put("floorGoodsList", categoryList);

        // 缓存数据
        HomeCacheManager.loadData(HomeCacheManager.INDEX, data);
        return Result.ok(data);
    }
}