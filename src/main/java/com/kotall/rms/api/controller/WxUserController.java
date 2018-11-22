package com.kotall.rms.api.controller;

import com.kotall.rms.api.annotation.AppConfig;
import com.kotall.rms.api.annotation.LoginUser;
import com.kotall.rms.common.entity.litemall.LiteMallAppEntity;
import com.kotall.rms.common.utils.Result;
import com.kotall.rms.core.service.litemall.LiteMallOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/wx/user")
@Validated
@Slf4j
public class WxUserController {

    @Autowired
    private LiteMallOrderService orderService;

    /**
     * 用户信息
     *
     * @param userId 用户ID
     * @return 用户信息
     *   成功则
     *  {
     *      code: 0,
     *      msg: '成功',
     *      data: xxx
     *  }
     *   失败则 { errno: XXX, errmsg: XXX }
     */
    @GetMapping("index")
    public Object list(@LoginUser Integer userId, @AppConfig LiteMallAppEntity appConfig) {
        if(userId == null){
            return Result.unlogin();
        }

        Map<Object, Object> data = new HashMap<>();
        data.put("order", orderService.queryOrderInfo(userId, appConfig.getStoreId()));
        return Result.ok().put("data", data);
    }

}