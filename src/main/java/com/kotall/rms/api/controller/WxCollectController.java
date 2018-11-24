package com.kotall.rms.api.controller;

import com.kotall.rms.api.annotation.AppConfig;
import com.kotall.rms.api.annotation.LoginUser;
import com.kotall.rms.common.entity.litemall.LiteMallAppEntity;
import com.kotall.rms.common.entity.litemall.LiteMallCollectEntity;
import com.kotall.rms.common.entity.litemall.LiteMallGoodsEntity;
import com.kotall.rms.common.utils.JacksonUtil;
import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Result;
import com.kotall.rms.core.service.litemall.LiteMallCollectService;
import com.kotall.rms.core.service.litemall.LiteMallGoodsService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/wx/collect")
@Validated
@Slf4j
public class WxCollectController {

    @Autowired
    private LiteMallCollectService collectService;
    @Autowired
    private LiteMallGoodsService goodsService;

    /**
     * 用户收藏列表
     *
     * @param userId 用户ID
     * @param type 类型，如果是0则是商品收藏，如果是1则是专题收藏
     *    目前没有使用
     * @param page 分页页数
     * @param size 分页大小
     * @return 用户收藏列表
     *   成功则
     *  {
     *      errno: 0,
     *      errmsg: '成功',
     *      data:
     *          {
     *              collectList: xxx,
     *              totalPages: xxx
     *          }
     *  }
     *   失败则 { errno: XXX, errmsg: XXX }
     */
    @GetMapping("list")
    public Object list(@LoginUser Integer userId,
                       @AppConfig LiteMallAppEntity appConfig,
                       @NotNull Byte type,
                       @RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer size) {
        if(userId == null){
            return Result.unlogin();
        }

        Map<String, Object> params = new HashMap<>();
        params.put("storeId", appConfig.getStoreId());
        params.put("userId", userId);
        params.put("type", type);
        params.put("userId", userId);
        params.put("pageNumber", page);
        params.put("pageSize", size);
        Page<LiteMallCollectEntity> pages = collectService.queryByType(params);

        List<Object> collects = new ArrayList<>(pages.getRows().size());
        for(LiteMallCollectEntity collect : pages.getRows()){
            Map<String, Object> c = new HashMap<>();
            c.put("id", collect.getId());
            c.put("type", collect.getType());
            c.put("valueId", collect.getValueId());

            LiteMallGoodsEntity goods = goodsService.getById(collect.getValueId());
            c.put("name", goods.getName());
            c.put("brief", goods.getBrief());
            c.put("picUrl", goods.getPicUrl());
            c.put("retailPrice", goods.getRetailPrice());

            collects.add(c);
        }

        Map<String, Object> result = new HashMap<>();
        result.put("collectList", collects);
        result.put("totalPages", pages.getTotalPages());
        return Result.ok().put("data", result);
    }

    /**
     * 用户收藏添加或删除
     *
     * @param userId 用户ID
     * @param body 请求内容
     * @return 操作结果
     *   成功则
     *  {
     *      code: 0,
     *      msg: '成功',
     *      data:
     *          {
     *              type: xxx,
     *          }
     *  }
     *   失败则 { code: XXX, msg: XXX }
     */
    @PostMapping("addordelete")
    public Object addordelete(@LoginUser Integer userId, @AppConfig LiteMallAppEntity appConfig, @RequestBody String body) {
        if(userId == null){
            return Result.unlogin();
        }
        if(body == null){
            return Result.badArgument();
        }

        Byte type = JacksonUtil.parseByte(body, "type");
        Integer valueId = JacksonUtil.parseInteger(body, "valueId");
        if(!ObjectUtils.allNotNull(type, valueId)){
            return Result.badArgument();
        }

        Map<String, Object> params = new HashMap<>();
        params.put("userId", userId);
        params.put("type", type);
        params.put("valueId", valueId);
        LiteMallCollectEntity collect = collectService.queryByTypeAndValue(params);

        String handleType;
        if(collect != null){
            handleType = "delete";
            collectService.deleteByIds(new Integer[]{collect.getId()});
        }
        else{
            handleType = "add";
            collect = new LiteMallCollectEntity();
            collect.setStoreId(appConfig.getStoreId());
            collect.setUserId(userId);
            collect.setValueId(valueId);
            collect.setType(new Integer(type));
            collectService.save(collect);
        }

        Map<String, Object> data = new HashMap<>();
        data.put("type", handleType);
        return Result.ok().put("data", data);
    }
}