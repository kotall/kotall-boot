package com.kotall.rms.web.controller.sys;

import com.kotall.rms.core.annotation.DataFilter;
import com.kotall.rms.core.annotation.SysLog;
import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Result;
import com.kotall.rms.web.util.ResultKit;
import com.kotall.rms.common.entity.sys.SysUserEntity;
import com.kotall.rms.core.service.sys.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Set;

/**
 * 系统用户
 *
 * @author aracwong
 * @date 2017年8月8日 下午9:04:59
 */
@RestController
@RequestMapping("/sys/user")
public class SysUserController extends AbstractController {
	
	@Autowired
	private SysUserService sysUserService;
	
	/**
	 * 用户列表
	 * @param params
	 * @return
	 */
	@RequestMapping("/list")
	@DataFilter(subDept = true, user = false)
	public Page<SysUserEntity> list(@RequestBody Map<String, Object> params) {
		params.put("userId", getUserId());
		return sysUserService.listUser(params);
	}
	
	/**
	 * 获取登录的用户信息
	 */
	@RequestMapping("/info")
	public Result info(){
		return Result.ok().put("user", getUser());
	}
	
	/**
	 * 用户权限
	 * @return
	 */
	@RequestMapping("/perms")
	public Result listUserPerms() {
		Set<String> perms = sysUserService.listUserPerms(getUserId());
		return ResultKit.msgNotCheckNull(perms);
	}
	
	/**
	 * 新增用户
	 * @param user
	 * @return
	 */
	@SysLog("新增用户")
	@RequestMapping("/save")
	public Result save(@RequestBody SysUserEntity user) {
		user.setUserIdCreate(getUserId());
		int count = sysUserService.saveUser(user);
		return ResultKit.msg(count);
	}
	
	/**
	 * 根据id查询详情
	 * @param userId
	 * @return
	 */
	@RequestMapping("/infoUser")
	public Result getById(@RequestBody Long userId) {
		SysUserEntity user = sysUserService.getUserById(userId);
		return ResultKit.msg(user);
	}
	
	/**
	 * 修改用户
	 * @param user
	 * @return
	 */
	@SysLog("修改用户")
	@RequestMapping("/update")
	public Result update(@RequestBody SysUserEntity user) {
		int count = sysUserService.updateUser(user);
		return ResultKit.msg(count);
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@SysLog("删除用户")
	@RequestMapping("/remove")
	public Result batchRemove(@RequestBody Long[] id) {
		int count = sysUserService.batchRemove(id);
		return ResultKit.msg(count);
	}
	
	/**
	 * 用户修改密码
	 * @param pwd
	 * @param newPwd
	 * @return
	 */
	@SysLog("修改密码")
	@RequestMapping("/updatePwd")
	public Result updatePwdByUser(String pwd, String newPwd) {
		SysUserEntity user = getUser();
		// 原密码
		user.setPassword(pwd);
		// 邮箱临时存储新密码
		user.setEmail(newPwd);
		int count = sysUserService.updatePwdByUser(user);
		return ResultKit.msg(count);
	}
	
	/**
	 * 启用账户
	 * @param id
	 * @return
	 */
	@SysLog("启用账户")
	@RequestMapping("/enable")
	public Result updateUserEnable(@RequestBody Long[] id) {
		int count = sysUserService.updateUserEnable(id);
		return ResultKit.msg(id, count);
	}
	
	/**
	 * 禁用账户
	 * @param id
	 * @return
	 */
	@SysLog("禁用账户")
	@RequestMapping("/disable")
	public Result updateUserDisable(@RequestBody Long[] id) {
		int count = sysUserService.updateUserDisable(id);
		return ResultKit.msg(id, count);
	}
	
	/**
	 * 重置密码
	 * @param user
	 * @return
	 */
	@SysLog("重置密码")
	@RequestMapping("/reset")
	public Result updatePwd(@RequestBody SysUserEntity user) {
		int count = sysUserService.updatePwd(user);
		return ResultKit.msg(count);
	}
}
