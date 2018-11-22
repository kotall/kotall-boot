package com.kotall.rms.api.controller;

import com.kotall.rms.api.HomeCacheManager;
import com.kotall.rms.api.annotation.AppConfig;
import com.kotall.rms.common.entity.litemall.LiteMallAppEntity;
import com.kotall.rms.common.entity.litemall.LiteMallCategoryEntity;
import com.kotall.rms.common.utils.Result;
import com.kotall.rms.core.service.litemall.LiteMallCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/wx/catalog")
@Validated
@Slf4j
public class WxCatalogController {

    @Autowired
    private LiteMallCategoryService categoryService;

    /**
     * 分类栏目
     *
     * @param id   分类类目ID
     *             如果分类类目ID是空，则选择第一个分类类目。
     *             需要注意，这里分类类目是一级类目
     * @param page 分页页数
     * @param size 分页大小
     * @return 分类栏目
     * 成功则
     * {
     * errno: 0,
     * errmsg: '成功',
     * data:
     * {
     * categoryList: xxx,
     * currentCategory: xxx,
     * currentSubCategory: xxx
     * }
     * }
     * 失败则 { errno: XXX, errmsg: XXX }
     */
    @GetMapping("index")
    public Object index(Integer id,
                        @AppConfig LiteMallAppEntity appConfig,
                        @RequestParam(defaultValue = "1") Integer page,
                        @RequestParam(defaultValue = "10") Integer size) {

        // 所有一级分类目录
        List<LiteMallCategoryEntity> l1CatList = categoryService.queryL1(appConfig.getStoreId());

        // 当前一级分类目录
        LiteMallCategoryEntity currentCategory;
        if (id != null) {
            currentCategory = categoryService.getLiteMallCategoryById(new Long(id));
        } else {
            currentCategory = l1CatList.get(0);
        }

        // 当前一级分类目录对应的二级分类目录
        List<LiteMallCategoryEntity> currentSubCategory = null;
        if (null != currentCategory) {
            currentSubCategory = categoryService.queryByPid(currentCategory.getId());
        }

        Map<String, Object> data = new HashMap<>();
        data.put("categoryList", l1CatList);
        data.put("currentCategory", currentCategory);
        data.put("currentSubCategory", currentSubCategory);
        return Result.ok().put("data", data);
    }

    /**
     * 一次性获取全部分类数据
     *
     * @return
     */
    @GetMapping("all")
    public Object queryAll(@AppConfig LiteMallAppEntity appConfig) {
        // 优先从缓存中读取
        if (HomeCacheManager.hasData(HomeCacheManager.CATALOG)) {
            return Result.ok().put("data", HomeCacheManager.getCacheData(HomeCacheManager.CATALOG));
        }


        // 所有一级分类目录
        List<LiteMallCategoryEntity> l1CatList = categoryService.queryL1(appConfig.getStoreId());

        //所有子分类列表
        Map<Integer, List<LiteMallCategoryEntity>> allList = new HashMap<>();
        List<LiteMallCategoryEntity> sub;
        for (LiteMallCategoryEntity category : l1CatList) {
            sub = categoryService.queryByPid(category.getId());
            allList.put(category.getId(), sub);
        }

        // 当前一级分类目录
        LiteMallCategoryEntity currentCategory = l1CatList.get(0);

        // 当前一级分类目录对应的二级分类目录
        List<LiteMallCategoryEntity> currentSubCategory = null;
        if (null != currentCategory) {
            currentSubCategory = categoryService.queryByPid(currentCategory.getId());
        }

        Map<String, Object> data = new HashMap<>();
        data.put("categoryList", l1CatList);
        data.put("allList", allList);
        data.put("currentCategory", currentCategory);
        data.put("currentSubCategory", currentSubCategory);

        // 缓存数据
        HomeCacheManager.loadData(HomeCacheManager.CATALOG, data);
        return Result.ok().put("data", data);
    }

    /**
     * 当前分类栏目
     *
     * @param id 分类类目ID
     * @return 当前分类栏目
     * 成功则
     * {
     * code: 0,
     * msg: '成功',
     * data:
     * {
     * currentCategory: xxx,
     * currentSubCategory: xxx
     * }
     * }
     * 失败则 { code: XXX, msg: XXX }
     */
    @GetMapping("current")
    public Object current(@NotNull Integer id) {
        // 当前分类
        LiteMallCategoryEntity currentCategory = categoryService.getLiteMallCategoryById(new Long(id));
        List<LiteMallCategoryEntity> currentSubCategory = categoryService.queryByPid(currentCategory.getId());

        Map<String, Object> data = new HashMap<>();
        data.put("currentCategory", currentCategory);
        data.put("currentSubCategory", currentSubCategory);
        return Result.ok().put("data", data);
    }
}