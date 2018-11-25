package com.kotall.rms.api.controller;

import com.kotall.rms.api.annotation.AppConfig;
import com.kotall.rms.api.annotation.LoginUser;
import com.kotall.rms.common.entity.litemall.LiteMallAppEntity;
import com.kotall.rms.common.entity.litemall.LiteMallUserEntity;
import com.kotall.rms.common.entity.litemall.LiteMallUserFormidEntity;
import com.kotall.rms.common.utils.Result;
import com.kotall.rms.core.service.litemall.LiteMallUserFormidService;
import com.kotall.rms.core.service.litemall.LiteMallUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.Calendar;
import java.util.Date;

@RestController
@RequestMapping("/wx/formid")
@Validated
public class WxUserFormId {

    @Autowired
    private LiteMallUserService userService;

    @Autowired
    private LiteMallUserFormidService formIdService;

    @GetMapping("create")
    public Object create(@LoginUser Integer userId,
                         @NotNull String formId,
                         @AppConfig LiteMallAppEntity appConfig) {
        if (userId == null) {
            return Result.unLogin();
        }

        LiteMallUserEntity user = userService.getById(userId);
        LiteMallUserFormidEntity userFormid = new LiteMallUserFormidEntity();
        userFormid.setStoreId(appConfig.getStoreId());
        userFormid.setOpenid(user.getWeixinOpenid());
        userFormid.setFormid(formId);
        userFormid.setIsprepay(0);
        userFormid.setUseamount(1);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_MONTH, 7);
        userFormid.setExpireTime(calendar.getTime());
        formIdService.save(userFormid);

        return Result.ok();
    }
}
