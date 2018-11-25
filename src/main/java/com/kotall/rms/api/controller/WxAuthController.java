package com.kotall.rms.api.controller;


import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import cn.binarywang.wx.miniapp.bean.WxMaPhoneNumberInfo;
import com.kotall.rms.api.*;
import com.kotall.rms.api.annotation.AppConfig;
import com.kotall.rms.api.annotation.LoginUser;
import com.kotall.rms.common.entity.litemall.LiteMallAppEntity;
import com.kotall.rms.common.entity.litemall.LiteMallUserEntity;
import com.kotall.rms.common.utils.*;
import com.kotall.rms.common.utils.bcrypt.BCryptPasswordEncoder;
import com.kotall.rms.core.service.litemall.LiteMallUserService;
import com.kotall.rms.notify.NotifyService;
import com.kotall.rms.notify.NotifyType;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/wx/auth")
@Validated
@Slf4j
public class WxAuthController {

    @Autowired
    private LiteMallUserService userService;

    @Autowired
    private WxMaService wxService;

    @Autowired
    private NotifyService notifyService;

    /**
     * 账号登录
     *
     * @param body    请求内容，{ username: xxx, password: xxx }
     * @param request 请求对象
     * @return 登录结果
     * 成功则
     * {
     * code: 0,
     * msg: '成功',
     * data:
     * {
     * token: xxx,
     * tokenExpire: xxx,
     * userInfo: xxx
     * }
     * }
     * 失败则 { code: XXX, msg: XXX }
     */
    @PostMapping("login")
    public Object login(@RequestBody String body, @AppConfig LiteMallAppEntity appConfig, HttpServletRequest request) {
        String username = JacksonUtil.parseString(body, "username");
        String password = JacksonUtil.parseString(body, "password");
        if (username == null || password == null) {
            return Result.badArgument();
        }

        List<LiteMallUserEntity> userList = userService.queryByUsername(appConfig.getStoreId(), username);
        LiteMallUserEntity user;
        if (userList.size() > 1) {
            return Result.serious();
        } else if (userList.size() == 0) {
            return Result.badArgumentValue();
        } else {
            user = userList.get(0);
        }

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if (!encoder.matches(password, user.getPassword())) {
            return Result.error(403, "账号密码不对");
        }

        // userInfo
        UserInfo userInfo = new UserInfo();
        userInfo.setNickName(username);
        userInfo.setAvatarUrl(user.getAvatar());

        // token
        UserToken userToken = UserTokenManager.generateToken(user.getId());

        Map<Object, Object> result = new HashMap<>();
        result.put("token", userToken.getToken());
        result.put("tokenExpire", userToken.getExpireTime().toString());
        result.put("userInfo", userInfo);
        return Result.ok().put("data", result);
    }

    /**
     * 微信登录
     *
     * @param wxLoginInfo 请求内容，{ code: xxx, userInfo: xxx }
     * @param request     请求对象
     * @return 登录结果
     * 成功则
     * {
     * code: 0,
     * msg: '成功',
     * data:
     * {
     * token: xxx,
     * tokenExpire: xxx,
     * userInfo: xxx
     * }
     * }
     * 失败则 { code: XXX, msg: XXX }
     */
    @PostMapping("login_by_weixin")
    public Object loginByWeixin(@RequestBody WxLoginInfo wxLoginInfo, @AppConfig LiteMallAppEntity appConfig, HttpServletRequest request) {
        String code = wxLoginInfo.getCode();
        UserInfo userInfo = wxLoginInfo.getUserInfo();
        if (code == null || userInfo == null) {
            return Result.badArgument();
        }

        String sessionKey = null;
        String openId = null;
        try {
            WxMaJscode2SessionResult result = this.wxService.getUserService().getSessionInfo(code);
            sessionKey = result.getSessionKey();
            openId = result.getOpenid();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (sessionKey == null || openId == null) {
            return Result.error();
        }

        List<LiteMallUserEntity> userListWithOpenId = userService.queryByOpenId(appConfig.getStoreId(), openId);
        LiteMallUserEntity user = CollectionUtils.isEmpty(userListWithOpenId) ? null : userListWithOpenId.get(0);
        if (user == null) {
            user = new LiteMallUserEntity();
            user.setStoreId(appConfig.getStoreId());
            user.setUsername(openId);
            user.setPassword(openId);
            user.setMobile("");
            user.setWeixinOpenid(openId);
            user.setAvatar(userInfo.getAvatarUrl());
            user.setNickname(userInfo.getNickName());
            user.setGender(new Integer(userInfo.getGender()));
            user.setUserLevel(0);
            user.setStatus(0);
            user.setDeleted(0);
            user.setLastLoginTime(new Date());
            user.setLastLoginIp(IpUtil.client(request));

            userService.save(user);
        } else {
            user.setLastLoginTime(new Date());
            user.setLastLoginIp(IpUtil.client(request));
            if (userService.update(user)) {
                return Result.updatedDataFailed();
            }
        }

        // token
        UserToken userToken = UserTokenManager.generateToken(user.getId());
        userToken.setSessionKey(sessionKey);

        Map<Object, Object> result = new HashMap<>();
        result.put("token", userToken.getToken());
        result.put("tokenExpire", userToken.getExpireTime().toString());
        result.put("userInfo", userInfo);
        return Result.ok().put("data", result);
    }


    /**
     * 请求验证码
     *
     * @param body 手机号码{mobile}
     * @return
     */
    @PostMapping("regCaptcha")
    public Object registerCaptcha(@RequestBody String body) {
        String phoneNumber = JacksonUtil.parseString(body, "mobile");
        if (StringUtils.isEmpty(phoneNumber)) {
            return Result.badArgument();
        }
        if (!RegexUtil.isMobileExact(phoneNumber)) {
            return Result.badArgumentValue();
        }

        String code = CharUtil.getRandomNum(6);
        boolean successful = notifyService.notifySmsTemplate(phoneNumber, NotifyType.CAPTCHA, new String[]{code});
        if (!successful) {
            return Result.error(404, "小程序后台验证码服务不支持");
        }

        successful = CaptchaCodeManager.addToCache(phoneNumber, code);
        if (!successful) {
            return Result.error(404, "验证码未超时1分钟，不能发送");
        }

        return Result.ok();
    }

    /**
     * 账号注册
     *
     * @param body    请求内容
     *                {
     *                username: xxx,
     *                password: xxx,
     *                mobile: xxx
     *                code: xxx
     *                }
     *                其中code是手机验证码，目前还不支持手机短信验证码
     * @param request 请求对象
     * @return 登录结果
     * 成功则
     * {
     * code: 0,
     * msg: '成功',
     * data:
     * {
     * token: xxx,
     * tokenExpire: xxx,
     * userInfo: xxx
     * }
     * }
     * 失败则 { errno: XXX, errmsg: XXX }
     */
    @PostMapping("register")
    public Object register(@RequestBody String body, @AppConfig LiteMallAppEntity appConfig,HttpServletRequest request) {
        String username = JacksonUtil.parseString(body, "username");
        String password = JacksonUtil.parseString(body, "password");
        String mobile = JacksonUtil.parseString(body, "mobile");
        String captcha = JacksonUtil.parseString(body, "captcha");
        String code = JacksonUtil.parseString(body, "code");

        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password) || StringUtils.isEmpty(mobile)
                || StringUtils.isEmpty(captcha) || StringUtils.isEmpty(code)) {
            return Result.badArgument();
        }

        List<LiteMallUserEntity> userList = userService.queryByUsername(appConfig.getStoreId(), username);
        if (userList.size() > 0) {
            return Result.error(403, "用户名已注册");
        }

        userList = userService.queryByMobile(mobile);
        if (userList.size() > 0) {
            return Result.error(403, "手机号已注册");
        }
        if (!RegexUtil.isMobileExact(mobile)) {
            return Result.error(403, "手机号格式不正确");
        }
        //判断验证码是否正确
        String cacheCode = CaptchaCodeManager.getCachedCaptcha(mobile);
        if (cacheCode == null || cacheCode.isEmpty() || !cacheCode.equals(code)) {
            return Result.error(403, "验证码错误");
        }

        String openId;
        try {
            WxMaJscode2SessionResult result = this.wxService.getUserService().getSessionInfo(code);
            openId = result.getOpenid();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(403, "openid 获取失败");
        }
        userList = userService.queryByOpenId(appConfig.getStoreId(), openId);
        if (userList.size() > 1) {
            return Result.error(403, "openid 存在多个");
        }
        if (userList.size() == 1) {
            LiteMallUserEntity checkUser = userList.get(0);
            String checkUsername = checkUser.getUsername();
            String checkPassword = checkUser.getPassword();
            if (!checkUsername.equals(openId) || !checkPassword.equals(openId)) {
                return Result.error(403, "openid已绑定账号");
            }
        }

        LiteMallUserEntity user;
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(password);
        user = new LiteMallUserEntity();
        user.setUsername(username);
        user.setPassword(encodedPassword);
        user.setMobile(mobile);
        user.setWeixinOpenid(openId);
        user.setAvatar("https://yanxuan.nosdn.127.net/80841d741d7fa3073e0ae27bf487339f.jpg?imageView&quality=90&thumbnail=64x64");
        user.setNickname(username);
        user.setGender(0);
        user.setUserLevel(0);
        user.setStatus(0);
        user.setLastLoginTime(new Date());
        user.setLastLoginIp(IpUtil.client(request));
        userService.save(user);

        // userInfo
        UserInfo userInfo = new UserInfo();
        userInfo.setNickName(username);
        userInfo.setAvatarUrl(user.getAvatar());

        // token
        UserToken userToken = UserTokenManager.generateToken(user.getId());

        Map<Object, Object> result = new HashMap<>();
        result.put("token", userToken.getToken());
        result.put("tokenExpire", userToken.getExpireTime().toString());
        result.put("userInfo", userInfo);
        return Result.ok().put("data", result);
    }

    /**
     * 账号密码重置
     *
     * @param body    请求内容
     *                {
     *                password: xxx,
     *                mobile: xxx
     *                code: xxx
     *                }
     *                其中code是手机验证码，目前还不支持手机短信验证码
     * @param request 请求对象
     * @return 登录结果
     * 成功则 { errno: 0, errmsg: '成功' }
     * 失败则 { errno: XXX, errmsg: XXX }
     */
    @PostMapping("reset")
    public Object reset(@RequestBody String body, HttpServletRequest request) {
        String password = JacksonUtil.parseString(body, "password");
        String mobile = JacksonUtil.parseString(body, "mobile");
        String code = JacksonUtil.parseString(body, "code");

        if (mobile == null || code == null || password == null) {
            return Result.badArgument();
        }

        //判断验证码是否正确
        String cacheCode = CaptchaCodeManager.getCachedCaptcha(mobile);
        if (cacheCode == null || cacheCode.isEmpty() || !cacheCode.equals(code))
            return Result.error(403, "验证码错误");

        List<LiteMallUserEntity> userList = userService.queryByMobile(mobile);
        LiteMallUserEntity user;
        if (userList.size() > 1) {
            return Result.serious();
        } else if (userList.size() == 0) {
            return Result.error(403, "手机号未注册");
        } else {
            user = userList.get(0);
        }

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(password);
        user.setPassword(encodedPassword);

        if (userService.update(user)) {
            return Result.updatedDataFailed();
        }

        return Result.ok();
    }

    @PostMapping("bindPhone")
    public Object bindPhone(@LoginUser Integer userId, @RequestBody String body) {
        String sessionKey = UserTokenManager.getSessionKey(userId);
        String encryptedData = JacksonUtil.parseString(body, "encryptedData");
        String iv = JacksonUtil.parseString(body, "iv");
        WxMaPhoneNumberInfo phoneNumberInfo = this.wxService.getUserService().getPhoneNoInfo(sessionKey, encryptedData, iv);
        String phone = phoneNumberInfo.getPhoneNumber();
        LiteMallUserEntity user = userService.getById(userId);
        user.setMobile(phone);
        if (userService.update(user)) {
            return Result.updatedDataFailed();
        }
        return Result.ok();
    }

    @PostMapping("logout")
    public Object logout(@LoginUser Integer userId) {
        if (userId == null) {
            return Result.unLogin();
        }
        UserTokenManager.removeToken(userId);
        return Result.ok();
    }
}
