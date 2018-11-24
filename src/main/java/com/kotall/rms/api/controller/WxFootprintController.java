package com.kotall.rms.api.controller;

import com.kotall.rms.api.annotation.AppConfig;
import com.kotall.rms.api.annotation.LoginUser;
import com.kotall.rms.common.entity.litemall.LiteMallAppEntity;
import com.kotall.rms.common.entity.litemall.LiteMallFootprintEntity;
import com.kotall.rms.common.entity.litemall.LiteMallGoodsEntity;
import com.kotall.rms.common.utils.JacksonUtil;
import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Result;
import com.kotall.rms.core.service.litemall.LiteMallFootprintService;
import com.kotall.rms.core.service.litemall.LiteMallGoodsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/wx/footprint")
@Validated
@Slf4j
public class WxFootprintController {

    @Autowired
    private LiteMallFootprintService footprintService;
    @Autowired
    private LiteMallGoodsService goodsService;

    /**
     * 删除用户足迹
     *
     * @param userId 用户ID
     * @param body 请求内容， { footprintId: xxx }
     * @return 删除操作结果
     *   成功则 { errno: 0, errmsg: '成功' }
     *   失败则 { errno: XXX, errmsg: XXX }
     */
    @PostMapping("delete")
    public Object delete(@LoginUser Integer userId, @RequestBody String body) {
        if(userId == null){
            return Result.unlogin();
        }
        if(body == null){
            return Result.badArgument();
        }

        Integer footprintId = JacksonUtil.parseInteger(body, "footprintId");
        if(footprintId == null){
            return Result.badArgument();
        }
        LiteMallFootprintEntity footprint = footprintService.getById(footprintId);

        if(footprint == null){
            return Result.badArgumentValue();
        }
        if(!footprint.getUserId().equals(userId)){
            return Result.badArgumentValue();
        }

        footprintService.deleteByIds(new Integer[]{footprintId});
        return Result.ok();
    }

    /**
     * 用户足迹列表
     *
     * @param page 分页页数
     * @param size 分页大小
     * @return 用户足迹列表
     *   成功则
     *  {
     *      errno: 0,
     *      errmsg: '成功',
     *      data:
     *          {
     *              footprintList: xxx,
     *              totalPages: xxx
     *          }
     *  }
     *   失败则 { errno: XXX, errmsg: XXX }
     */
    @GetMapping("list")
    public Object list(@LoginUser Integer userId,
                       @AppConfig LiteMallAppEntity appConfig,
                       @RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer size) {
        if(userId == null){
            return Result.unlogin();
        }

        Map<String, Object> params = new HashMap<>();
        params.put("storeId", appConfig.getStoreId());
        params.put("userId", userId);
        params.put("pageNumber", page);
        params.put("pageSize", size);
        Page<LiteMallFootprintEntity> pages = footprintService.queryByPage(params);

        List<Object> footprintVoList = new ArrayList<>(pages.getRows().size());
        for(LiteMallFootprintEntity footprint : pages.getRows()){
            Map<String, Object> c = new HashMap<>();
            c.put("id", footprint.getId());
            c.put("goodsId", footprint.getGoodsId());
            c.put("addTime", footprint.getAddTime());

            LiteMallGoodsEntity goods = goodsService.getById(footprint.getGoodsId());
            c.put("name", goods.getName());
            c.put("brief", goods.getBrief());
            c.put("picUrl", goods.getPicUrl());
            c.put("retailPrice", goods.getRetailPrice());

            footprintVoList.add(c);
        }


        Map<String, Object> result = new HashMap<>();
        result.put("footprintList", footprintVoList);
        result.put("totalPages", pages.getTotalPages());
        return Result.ok().put("data", result);
    }

}