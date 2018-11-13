package com.kotall.rms.web.controller.sys;

import java.io.IOException;

import com.kotall.rms.common.utils.Result;
import com.kotall.rms.web.util.ResultKit;
import com.kotall.rms.common.entity.sys.SysUserEntity;
import com.kotall.rms.common.entity.sys.SysUserTokenEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kotall.rms.common.annotation.SysLog;
import com.kotall.rms.common.utils.MD5Utils;
import com.kotall.rms.web.util.ShiroUtils;
import com.kotall.rms.core.service.sys.SysUserService;

/**
 * 用户controller
 *
 * @author aracwong
 * @date 2017年8月8日 下午2:48:50
 */
@RestController
@RequestMapping("/sys")
public class SysLoginController extends AbstractController {
	
	@Autowired
	private SysUserService sysUserService;
	
	/**
	 * 登录
	 */
	@SysLog("登录")
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public Result login(String username, String password)throws IOException {
		SysUserEntity user = sysUserService.getByUserName(username);
		password = MD5Utils.encrypt(username, password);
		
		if(user == null || !user.getPassword().equals(password)) {
			return Result.error("用户名或密码错误");
		}
		
		if(user.getStatus() == 0) {
			return Result.error("账号已被锁定,请联系管理员");
		}

		SysUserTokenEntity token = sysUserService.saveUserToken(user.getUserId());
		Result result = Result.ok().put("token", token.getToken()).put("expire", token.getExpireTime());
		return result;
	}
	
	/**
	 * 退出
	 */
	@SysLog("退出系统")
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public Result logout() {
		int count = sysUserService.updateUserToken(getUserId());
		ShiroUtils.logout();
		return ResultKit.msg(count);
	}
	
}
