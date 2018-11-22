package com.kotall.rms.api.controller;

import com.kotall.rms.api.SystemConfig;
import com.kotall.rms.api.annotation.LoginUser;
import com.kotall.rms.api.vo.GoodsSpecificationVO;
import com.kotall.rms.common.entity.litemall.*;
import com.kotall.rms.common.utils.Page;
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
     * code: 0,
     * msg: '成功',
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
        Map<String, Object> params = new HashMap<>();
        //params.put("storeId", storeId);
        params.put("goodsId", id);
        params.put("deleted", 0);
        List<LiteMallGoodsAttributeEntity> goodsAttributeList = goodsAttributeService.queryByGid(params);

        // 商品规格
        // 返回的是定制的GoodsSpecificationVo
        params = new HashMap<>();
        params.put("goodsId", id);
        List<LiteMallGoodsSpecificationEntity> list = goodsSpecificationService.querySpecificationList(params);
        List<GoodsSpecificationVO> specificationList = this.convertToGoodsSpecificationVO(list);

        // 商品规格对应的数量和价格
        params = new HashMap<>();
        //params.put("storeId", storeId);
        params.put("goodsId", id);
        params.put("deleted", 0);
        List<LiteMallGoodsProductEntity> productList = productService.queryByGoodsId(params);

        // 商品问题，这里是一些通用问题
        params = new HashMap<>();
        //params.put("storeId", storeId);
        params.put("deleted", 0);
        List<LiteMallIssueEntity> issue = goodsIssueService.queryIssueList(params);

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
        params = new HashMap<>();
        //params.put("storeId", storeId);
        params.put("deleted", 0);
        params.put("goodsId", id);
        params.put("pageNumber", 1);
        params.put("pageSize", 2);
        Page<LiteMallCommentEntity> pages = commentService.queryCommentListByPage(params);
        List<Map<String, Object>> commentsVo = new ArrayList<>(pages.getRows().size());
        for (LiteMallCommentEntity comment : pages.getRows()) {
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
        commentList.put("count", pages.getTotal());
        commentList.put("data", commentsVo);

        //团购信息
        params = new HashMap<>();
        //params.put("storeId", storeId);
        params.put("goodsId", id);
        params.put("deleted", 0);
        List<LiteMallGrouponRulesEntity> rules = rulesService.queryByGoodsId(params);

        // 用户收藏
        int userHasCollect = 0;
        if (userId != null) {
            params = new HashMap<>();
            //params.put("storeId", storeId);
            params.put("userId", userId);
            params.put("goodsId", id);
            userHasCollect = collectService.countUserCollect(params);
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

    private List<GoodsSpecificationVO> convertToGoodsSpecificationVO(List<LiteMallGoodsSpecificationEntity> list) {
        Map<String, GoodsSpecificationVO> map = new HashMap<>();
        List<GoodsSpecificationVO> specificationVoList = new ArrayList<>();

        for(LiteMallGoodsSpecificationEntity goodsSpecification : list){
            String specification = goodsSpecification.getSpecification();
            GoodsSpecificationVO goodsSpecificationVo = map.get(specification);
            if(goodsSpecificationVo == null){
                goodsSpecificationVo = new GoodsSpecificationVO();
                goodsSpecificationVo.setName(specification);
                List<LiteMallGoodsSpecificationEntity> valueList = new ArrayList<>();
                valueList.add(goodsSpecification);
                goodsSpecificationVo.setValueList(valueList);
                map.put(specification, goodsSpecificationVo);
                specificationVoList.add(goodsSpecificationVo);
            }
            else{
                List<LiteMallGoodsSpecificationEntity> valueList = goodsSpecificationVo.getValueList();
                valueList.add(goodsSpecification);
            }
        }
        return specificationVoList;
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

        // 添加到搜索历史
        if (userId != null && !StringUtils.isNullOrEmpty(keyword)) {
            LiteMallSearchHistoryEntity searchHistoryVo = new LiteMallSearchHistoryEntity();
            searchHistoryVo.setKeyword(keyword);
            searchHistoryVo.setUserId(userId);
            searchHistoryVo.setFrom("wx");
            searchHistoryService.saveLiteMallSearchHistory(searchHistoryVo);
        }

        // 查询列表数据
        Map<String, Object> params = new HashMap<>();
        //params.put("storeId", storeId);
        params.put("categoryId", categoryId);
        params.put("brandId", brandId);
        params.put("keyword", keyword);
        params.put("isHot", isHot);
        params.put("isNew", isNew);
        params.put("pageNumber", page);
        params.put("pageSize", size);
        params.put("deleted", 0);

        Page<LiteMallGoodsEntity> pages = goodsService.queryGoodsListByPage(params);

        // 查询商品所属类目列表。
        params = new HashMap<>();
        //params.put("storeId", storeId);
        params.put("categoryId", categoryId);
        params.put("brandId", brandId);
        params.put("keyword", keyword);
        params.put("isHot", isHot);
        params.put("isNew", isNew);
        params.put("deleted", 0);
        List<Integer> goodsCatIds = goodsService.queryCategoryIds(params);
        List<LiteMallCategoryEntity> categoryList;
        if (goodsCatIds.size() != 0) {
            params = new HashMap<>();
            //params.put("storeId", storeId);
            params.put("ids", goodsCatIds);
            params.put("level", "L2");
            params.put("deleted", 0);
            categoryList = categoryService.queryL2ByIds(params);
        } else {
            categoryList = new ArrayList<>(0);
        }

        Map<String, Object> data = new HashMap<>();
        data.put("goodsList", pages.getRows());
        data.put("filterCategoryList", categoryList);
        data.put("count", pages.getTotal());
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
        Map<String, Object> params = new HashMap<>();
        //params.put("storeId", storeId);
        params.put("categoryId", cid);
        params.put("pageNumber", 1);
        params.put("pageSize", 6);
        params.put("deleted", 0);
        List<LiteMallGoodsEntity> goodsList = goodsService.queryByCategory(params);
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
        Map<String, Object> params = new HashMap<>();
        //params.put("storeId", storeId);
        Integer goodsCount = goodsService.countOnSale(params);
        Map<String, Object> data = new HashMap<>();
        data.put("goodsCount", goodsCount);
        return Result.ok().put("data", data);
    }

}