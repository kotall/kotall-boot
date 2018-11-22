package com.kotall.rms.api.controller;

import com.kotall.rms.api.annotation.LoginUser;
import com.kotall.rms.common.entity.litemall.LiteMallFeedbackEntity;
import com.kotall.rms.common.entity.litemall.LiteMallUserEntity;
import com.kotall.rms.common.utils.RegexUtil;
import com.kotall.rms.common.utils.Result;
import com.kotall.rms.core.service.litemall.LiteMallFeedbackService;
import com.kotall.rms.core.service.litemall.LiteMallUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author aracwong
 * @date 2018/8/25 14:10
 */
@RestController
@RequestMapping("/wx/feedback")
@Validated
@Slf4j
public class WxFeedbackController {

    @Autowired
    private LiteMallFeedbackService feedbackService;
    @Autowired
    private LiteMallUserService userService;

    private Object validate(LiteMallFeedbackEntity feedback) {
        String content = feedback.getContent();
        if(StringUtils.isEmpty(content)){
            return Result.badArgument();
        }

        String type = feedback.getFeedType();
        if(StringUtils.isEmpty(type)){
            return Result.badArgument();
        }

        Integer hasPicture = feedback.getHasPicture();
        if(hasPicture == null || hasPicture > 0){
            feedback.setPicUrls(new String());
        }

        // 测试手机号码是否正确
        String mobile = feedback.getMobile();
        if(StringUtils.isEmpty(mobile)){
            return Result.badArgument();
        }
        if (!RegexUtil.isMobileExact(mobile)) {
            return Result.badArgument();
        }
        return null;
    }

    /**
     *  意见反馈
     */
    @PostMapping("submit")
    public Object submit(@LoginUser Integer userId, @RequestBody LiteMallFeedbackEntity feedback) {
        if (userId == null) {
            return Result.unlogin();
        }
        Object error = validate(feedback);
        if(error != null){
            return error;
        }

        LiteMallUserEntity user = userService.getLiteMallUserById(new Long(userId));
        String username = user.getUsername();
        feedback.setId(null);
        feedback.setUserId(userId);
        feedback.setUsername(username);
        // 状态默认是0，1表示状态已发生变化
        feedback.setStatus(1);
        feedbackService.saveLiteMallFeedback(feedback);

        return Result.ok();
    }

}
