package com.kotall.rms.api.controller;

import com.kotall.rms.api.UserInfo;
import com.kotall.rms.api.UserInfoService;
import com.kotall.rms.api.annotation.AppConfig;
import com.kotall.rms.api.annotation.LoginUser;
import com.kotall.rms.common.entity.litemall.LiteMallAppEntity;
import com.kotall.rms.common.entity.litemall.LiteMallCommentEntity;
import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Result;
import com.kotall.rms.core.service.litemall.LiteMallCommentService;
import com.kotall.rms.core.service.litemall.LiteMallGoodsService;
import com.kotall.rms.core.service.litemall.LiteMallTopicService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/wx/comment")
@Validated
@Slf4j
public class WxCommentController {

    @Autowired
    private LiteMallCommentService commentService;
    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private LiteMallGoodsService goodsService;
    @Autowired
    private LiteMallTopicService topicService;

    private Object validate(LiteMallCommentEntity comment) {
        String content = comment.getContent();
        if(StringUtils.isEmpty(content)){
            return Result.badArgument();
        }

        Integer star = comment.getStar();
        if(star == null){
            return Result.badArgument();
        }
        if(star < 0 || star > 5){
            return Result.badArgumentValue();
        }

        Integer type = comment.getType();
        Integer valueId = comment.getValueId();
        if(type == null || valueId == null){
            return Result.badArgument();
        }
        if(type == 0){
            if(goodsService.getLiteMallGoodsById(new Long(valueId))  == null){
                return Result.badArgumentValue();
          }
        }
        else if(type == 1){
            if(topicService.getLiteMallTopicById(new Long(valueId)) == null){
                return Result.badArgumentValue();
            }
        }
        else{
            return Result.badArgumentValue();
        }
        Integer hasPicture = comment.getHasPicture();
        if(hasPicture == null || hasPicture > 0){
            comment.setPicUrls(new String());
        }
        return null;
    }

    /**
     * 发表评论
     *
     * @param userId 用户ID
     * @param comment 评论内容
     * @return 发表评论操作结果
     *   成功则
     *  {
     *      code: 0,
     *      msg: '成功',
     *      data: xxx
     *  }
     *   失败则 { errno: XXX, errmsg: XXX }
     */
    @PostMapping("post")
    public Object post(@LoginUser Integer userId, @AppConfig LiteMallAppEntity appConfig, @RequestBody LiteMallCommentEntity comment) {
        if(userId == null){
            return Result.unlogin();
        }
        Object error = validate(comment);
        if(error != null){
            return error;
        }

        comment.setStoreId(appConfig.getStoreId());
        comment.setUserId(userId);
        commentService.saveLiteMallComment(comment);
        return Result.ok().put("data", comment);
    }

    /**
     * 评论数量
     *
     * @param type 类型ID。 如果是0，则查询商品评论；如果是1，则查询专题评论。
     * @param valueId 商品或专题ID。如果type是0，则是商品ID；如果type是1，则是专题ID。
     * @return 评论数量
     *   成功则
     *  {
     *      code: 0,
     *      msg: '成功',
     *      data:
     *          {
     *              allCount: xxx,
     *              hasPicCount: xxx
     *          }
     *  }
     *   失败则 { code: XXX, msg: XXX }
     */
    @GetMapping("count")
    public Object count(@NotNull Byte type, @NotNull Integer valueId, @AppConfig LiteMallAppEntity appConfig) {
        int allCount = commentService.count(appConfig.getStoreId(), 0, type, valueId);
        int hasPicCount = commentService.count(appConfig.getStoreId(), 1, type, valueId);
        Map<String, Object> data = new HashMap<>();
        data.put("allCount", allCount);
        data.put("hasPicCount", hasPicCount);
        return Result.ok().put("data", data);
    }

    /**
     * 评论列表
     *
     * @param type 类型ID。 如果是0，则查询商品评论；如果是1，则查询专题评论。
     * @param valueId 商品或专题ID。如果type是0，则是商品ID；如果type是1，则是专题ID。
     * @param showType 显示类型。如果是0，则查询全部；如果是1，则查询有图片的评论。
     * @param page 分页页数
     * @param size 分页大小
     * @return 评论列表
     *   成功则
     *  {
     *      errno: 0,
     *      errmsg: '成功',
     *      data:
     *          {
     *              data: xxx,
     *              count: xxx，
     *              currentPage: xxx
     *          }
     *  }
     *   失败则 { errno: XXX, errmsg: XXX }
     */
    @GetMapping("list")
    public Object list(@NotNull Byte type,
                       @NotNull Integer valueId,
                       @NotNull Integer showType,
                       @AppConfig LiteMallAppEntity appConfig,
                       @RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer size) {
        Map<String, Object> params = new HashMap<>();
        params.put("storeId", appConfig.getStoreId());
        params.put("type", type);
        params.put("valueId", valueId);
        params.put("pageNumber", page);
        params.put("pageSize", size);
        Page<LiteMallCommentEntity> pages = commentService.queryCommentByPage(showType, params);

        List<Map<String, Object>> commentVoList = new ArrayList<>(pages.getRows().size());
        for(LiteMallCommentEntity comment : pages.getRows()){
            Map<String, Object> commentVo = new HashMap<>();
            UserInfo userInfo = userInfoService.getInfo(comment.getUserId());
            commentVo.put("userInfo", userInfo);
            commentVo.put("addTime", comment.getAddTime());
            commentVo.put("content",comment.getContent());
            commentVo.put("picList", comment.getPicUrls());

            commentVoList.add(commentVo);
        }
        Map<String, Object> data = new HashMap<>();
        data.put("data", commentVoList);
        data.put("count", pages.getTotal());
        data.put("currentPage", page);
        return Result.ok().put("data", data);
    }
}