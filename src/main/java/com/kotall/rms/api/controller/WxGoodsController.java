package com.kotall.rms.api.controller;

import com.kotall.rms.api.SystemConfig;
import com.kotall.rms.api.annotation.LoginUser;
import com.kotall.rms.common.entity.litemall.*;
import com.kotall.rms.common.utils.Result;
import com.kotall.rms.core.service.litemall.*;
import com.mysql.jdbc.StringUtils;
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
@RequestMapping("/wx/goods")
@Validated
@Slf4j
public class WxGoodsController {
    @Autowired
    private LiteMallGoodsService goodsService;
    @Autowired
    private LiteMallGoodsProductService productService;
    @Autowired
    private LiteMallIssueService goodsIssueService;
    @Autowired
    private LiteMallGoodsAttributeService goodsAttributeService;
    @Autowired
    private LiteMallBrandService brandService;
    @Autowired
    private LiteMallCommentService commentService;
    @Autowired
    private LiteMallUserService userService;
    @Autowired
    private LiteMallCollectService collectService;
    @Autowired
    private LiteMallFootprintService footprintService;
    @Autowired
    private LiteMallCategoryService categoryService;
    @Autowired
    private LiteMallSearchHistoryService searchHistoryService;
    @Autowired
    private LiteMallGoodsSpecificationService goodsSpecificationService;
    @Autowired
    private LiteMallGrouponRulesService rulesService;


    /**
     * 商品详情
     * <p>
     * 用户可以不登录。
     * 如果用户登录，则记录用户足迹以及返回用户收藏信息。
     *
     * @param userId 用户ID
     * @param id     商品ID
     * @return 商品详情
     * 成功则
     * {
     * errno: 0,
     * errmsg: '成功',
     * data:
     * {
     * info: xxx,
     * userHasCollect: xxx,
     * issue: xxx,
     * comment: xxx,
     * specificationList: xxx,
     * productList: xxx,
     * attribute: xxx,
     * brand: xxx
     * }
     * }
     * 失败则 { errno: XXX, errmsg: XXX }
     */
    @GetMapping("detail")
    public Object detail(@LoginUser Integer userId, @NotNull Integer id) {
        // 商品信息
        LiteMallGoodsEntity info = goodsService.getLiteMallGoodsById(new Long(id));

        // 商品属性
        List<LiteMallGoodsAttributeEntity> goodsAttributeList = goodsAttributeService.queryByGid(id);

        // 商品规格
        // 返回的是定制的GoodsSpecificationVo
        Object specificationList = goodsSpecificationService.getSpecificationVoList(id);

        // 商品规格对应的数量和价格
        List<LiteMallGoodsProductEntity> productList = productService.queryByGid(id);

        // 商品问题，这里是一些通用问题
        List<LiteMallIssueEntity> issue = goodsIssueService.query();

        // 商品品牌商
        Integer brandId = info.getBrandId();
        LiteMallBrandEntity brand = null;
        if(brandId == 0){
            brand = new LiteMallBrandEntity();
        }
        else {
            brand = brandService.getLiteMallBrandById(new Long(info.getBrandId()));
        }

        // 评论
        List<LiteMallCommentEntity> comments = commentService.queryGoodsByGid(id, 0, 2);
        List<Map<String, Object>> commentsVo = new ArrayList<>(comments.size());
        int commentCount = commentService.countGoodsByGid(id, 0, 2);
        for (LiteMallCommentEntity comment : comments) {
            Map<String, Object> c = new HashMap<>();
            c.put("id", comment.getId());
            c.put("addTime", comment.getAddTime());
            c.put("content", comment.getContent());
            LiteMallUserEntity user = userService.getLiteMallUserById(new Long(comment.getUserId()));
            c.put("nickname", user.getNickname());
            c.put("avatar", user.getAvatar());
            c.put("picList", comment.getPicUrls());
            commentsVo.add(c);
        }
        Map<String, Object> commentList = new HashMap<>();
        commentList.put("count", commentCount);
        commentList.put("data", commentsVo);

        //团购信息
        List<LiteMallGrouponRulesEntity> rules = rulesService.queryByGoodsId(id);

        // 用户收藏
        int userHasCollect = 0;
        if (userId != null) {
            userHasCollect = collectService.count(userId, id);
        }

        // 记录用户的足迹
        if (userId != null) {
            LiteMallFootprintEntity footprint = new LiteMallFootprintEntity();
            footprint.setUserId(userId);
            footprint.setGoodsId(id);
            footprintService.saveLiteMallFootprint(footprint);
        }

        Map<String, Object> data = new HashMap<>();
        data.put("info", info);
        data.put("userHasCollect", userHasCollect);
        data.put("issue", issue);
        data.put("comment", commentList);
        data.put("specificationList", specificationList);
        data.put("productList", productList);
        data.put("attribute", goodsAttributeList);
        data.put("brand", brand);
        data.put("groupon", rules);

        //商品分享图片地址
        data.put("shareImage", info.getShareUrl());
        return Result.ok().put("data", data);
    }

    /**
     * 商品分类类目
     * <p>
     * TODO 可能应该合并到WxCatalogController中
     *
     * @param id 分类类目ID
     * @return 商品分类类目
     * 成功则
     * {
     * errno: 0,
     * errmsg: '成功',
     * data:
     * {
     * currentCategory: xxx,
     * parentCategory: xxx,
     * brotherCategory: xxx
     * }
     * }
     * 失败则 { errno: XXX, errmsg: XXX }
     */
    @GetMapping("category")
    public Object category(@NotNull Integer id) {
        LiteMallCategoryEntity cur = categoryService.getLiteMallCategoryById(new Long(id));
        LiteMallCategoryEntity parent = null;
        List<LiteMallCategoryEntity> children = null;

        if (cur.getPid() == 0) {
            parent = cur;
            children = categoryService.queryByPid(cur.getId());
            cur = children.size() > 0 ? children.get(0) : cur;
        } else {
            parent = categoryService.getLiteMallCategoryById(new Long(cur.getPid()));
            children = categoryService.queryByPid(cur.getPid());
        }
        Map<String, Object> data = new HashMap<>();
        data.put("currentCategory", cur);
        data.put("parentCategory", parent);
        data.put("brotherCategory", children);
        return Result.ok().put("data", data);
    }

    /**
     * 根据条件搜素商品
     * <p>
     * 1. 这里的前五个参数都是可选的，甚至都是空
     * 2. 用户是可选登录，如果登录，则记录用户的搜索关键字
     *
     * @param categoryId 分类类目ID
     * @param brandId    品牌商ID
     * @param keyword    关键字
     * @param isNew      是否新品
     * @param isHot      是否热买
     * @param userId     用户ID
     * @param page       分页页数
     * @param size       分页大小
     * @param sort       排序方式
     * @param order      排序类型，顺序或者降序
     * @return 根据条件搜素的商品详情
     * 成功则
     * {
     * errno: 0,
     * errmsg: '成功',
     * data:
     * {
     * goodsList: xxx,
     * filterCategoryList: xxx,
     * count: xxx
     * }
     * }
     * 失败则 { errno: XXX, errmsg: XXX }
     */
    @GetMapping("list")
    public Object list(Integer categoryId, Integer brandId, String keyword, Boolean isNew, Boolean isHot,
                       @LoginUser Integer userId,
                       @RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer size,
                       @RequestParam(defaultValue = "add_time") String sort,
                       @RequestParam(defaultValue = "desc") String order) {

        //添加到搜索历史
        if (userId != null && !StringUtils.isNullOrEmpty(keyword)) {
            LiteMallSearchHistoryEntity searchHistoryVo = new LiteMallSearchHistoryEntity();
            searchHistoryVo.setKeyword(keyword);
            searchHistoryVo.setUserId(userId);
            searchHistoryVo.setFrom("wx");
            searchHistoryService.saveLiteMallSearchHistory(searchHistoryVo);
        }

        //查询列表数据
        List<LiteMallGoodsEntity> goodsList = goodsService.querySelective(categoryId, brandId, keyword, isHot, isNew, page, size, sort, order);
        int total = goodsService.countSelective(categoryId, brandId, keyword, isHot, isNew, page, size, sort, order);

        // 查询商品所属类目列表。
        List<Integer> goodsCatIds = goodsService.getCatIds(brandId, keyword, isHot, isNew);
        List<LiteMallCategoryEntity> categoryList = null;
        if (goodsCatIds.size() != 0) {
            categoryList = categoryService.queryL2ByIds(goodsCatIds);
        } else {
            categoryList = new ArrayList<>(0);
        }

        Map<String, Object> data = new HashMap<>();
        data.put("goodsList", goodsList);
        data.put("filterCategoryList", categoryList);
        data.put("count", total);
        return Result.ok().put("data", data);
    }

    /**
     * 新品首发页面的横幅数据
     * <p>
     * TODO 其实可以删除
     *
     * @return 新品首发页面的栏目数据
     * 成功则
     * {
     * errno: 0,
     * errmsg: '成功',
     * data:
     * {
     * bannerInfo: xxx
     * }
     * }
     * 失败则 { errno: XXX, errmsg: XXX }
     */
    @GetMapping("new")
    public Object newGoods() {
        Map<String, String> bannerInfo = new HashMap<>();
        bannerInfo.put("url", "");
        bannerInfo.put("name", SystemConfig.getNewBannerTitle());
        bannerInfo.put("imgUrl", SystemConfig.getNewImageUrl());

        Map<String, Object> data = new HashMap<>();
        data.put("bannerInfo", bannerInfo);
        return Result.ok().put("data", data);
    }

    /**
     * 人气推荐页面的横幅数据
     * <p>
     * TODO 其实可以删除
     *
     * @return 人气推荐页面的栏目数据
     * 成功则
     * {
     * errno: 0,
     * errmsg: '成功',
     * data:
     * {
     * bannerInfo: xxx
     * }
     * }
     * 失败则 { errno: XXX, errmsg: XXX }
     */
    @GetMapping("hot")
    public Object hotGoods() {
        Map<String, String> bannerInfo = new HashMap<>();
        bannerInfo.put("url", "");
        bannerInfo.put("name", SystemConfig.getHotBannerTitle());
        bannerInfo.put("imgUrl", SystemConfig.getHotImageUrl());
        Map<String, Object> data = new HashMap<>();
        data.put("bannerInfo", bannerInfo);
        return Result.ok().put("data", data);
    }

    /**
     * 商品页面推荐商品
     *
     * @return 商品页面推荐商品
     * 成功则
     * {
     * errno: 0,
     * errmsg: '成功',
     * data:
     * {
     * goodsList: xxx
     * }
     * }
     * 失败则 { errno: XXX, errmsg: XXX }
     */
    @GetMapping("related")
    public Object related(@NotNull Integer id) {
        LiteMallGoodsEntity goods = goodsService.getLiteMallGoodsById(new Long(id));
        if (goods == null) {
            return Result.badArgumentValue();
        }

        // 目前的商品推荐算法仅仅是推荐同类目的其他商品
        int cid = goods.getCategoryId();

        // 查找六个相关商品
        int related = 6;
        List<LiteMallGoodsEntity> goodsList = goodsService.queryByCategory(cid, 0, related);
        Map<String, Object> data = new HashMap<>();
        data.put("goodsList", goodsList);
        return Result.ok().put("data", data);
    }

    /**
     * 在售的商品总数
     *
     * @return 在售的商品总数
     * 成功则
     * {
     * errno: 0,
     * errmsg: '成功',
     * data:
     * {
     * goodsCount: xxx
     * }
     * }
     * 失败则 { errno: XXX, errmsg: XXX }
     */
    @GetMapping("count")
    public Object count() {
        Integer goodsCount = goodsService.queryOnSale();
        Map<String, Object> data = new HashMap<>();
        data.put("goodsCount", goodsCount);
        return Result.ok().put("data", data);
    }

}