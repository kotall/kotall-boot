package com.kotall.rms.api;

import com.kotall.rms.common.entity.litemall.LiteMallUserEntity;
import com.kotall.rms.core.service.litemall.LiteMallUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class UserInfoService {
    @Autowired
    private LiteMallUserService userService;


    public UserInfo getInfo(Integer userId) {
        LiteMallUserEntity user = userService.getLiteMallUserById(new Long(userId));
        Assert.state(user != null, "用户不存在");
        UserInfo userInfo = new UserInfo();
        userInfo.setNickName(user.getNickname());
        userInfo.setAvatarUrl(user.getAvatar());
        return userInfo;
    }
}
