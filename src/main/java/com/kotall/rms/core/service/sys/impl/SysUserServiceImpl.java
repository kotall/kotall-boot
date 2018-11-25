package com.kotall.rms.core.service.sys.impl;

import com.kotall.rms.common.entity.sys.SysUserEntity;
import com.kotall.rms.common.entity.sys.SysUserTokenEntity;
import com.kotall.rms.common.utils.MD5Utils;
import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Query;
import com.kotall.rms.core.RmsException;
import com.kotall.rms.core.annotation.DeptFilter;
import com.kotall.rms.core.constants.Constant;
import com.kotall.rms.core.manager.sys.SysUserManager;
import com.kotall.rms.core.service.BaseServiceImpl;
import com.kotall.rms.core.service.sys.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Set;

/**
 * 系统用户
 *
 * @author aracwong
 * @date 2017年8月11日 上午11:47:17
 */
@Service("sysUserService")
public class SysUserServiceImpl extends BaseServiceImpl<SysUserManager, SysUserEntity> implements SysUserService {

	@Autowired
	private SysUserManager sysUserManager;

	@DeptFilter(subDept = true, user = false)
	@Override
	public Page<SysUserEntity> queryUserByPage(Map<String, Object> params) {
		return super.queryByPage(params);
	}

	@Override
	public boolean save(SysUserEntity user) {
		user.setPassword(MD5Utils.encrypt(user.getUsername(), user.getPassword()));
		boolean count = sysUserManager.saveUser(user);
		return count;
	}

	@Override
	public boolean update(SysUserEntity user) {
		user.setPassword(MD5Utils.encrypt(user.getUsername(), user.getPassword()));
		boolean count = sysUserManager.updateUser(user);
		return count;
	}

	@Override
	public SysUserTokenEntity getUserTokenInfoByToken(String token) {
		return this.sysUserManager.getByToken(token);
	}

	@Override
	public Set<String> listUserPerms(Integer userId) {
		Set<String> perms;
		if (Constant.SUPER_ADMIN == userId) {
			perms = sysUserManager.listUserPerms(null);
		} else {
			perms = sysUserManager.listUserPerms(userId);
		}
		return perms;
	}

	@Override
	public int updatePwdByUser(SysUserEntity user) {
		String username = user.getUsername();
		String pwd = user.getPassword();
		String newPwd = user.getEmail();
		pwd = MD5Utils.encrypt(username, pwd);
		newPwd = MD5Utils.encrypt(username, newPwd);
		Query query = new Query();
		query.put("userId", user.getUserId());
		query.put("password", pwd);
		query.put("newPassword", newPwd);
		int count = sysUserManager.updatePwdByUser(query);
		if(count < 1) {
			throw new RmsException("原密码错误");
		}
		return count;
	}

	@Override
	public int updateUserEnable(Integer[] id) {
		int count = sysUserManager.updateUserEnable(id);
		return count;
	}

	@Override
	public int updateUserDisable(Integer[] id) {
		int count = sysUserManager.updateUserDisable(id);
		return count;
	}

	@Override
	public int updatePwd(SysUserEntity user) {
		SysUserEntity currUser = sysUserManager.getById(user.getUserId());
		user.setPassword(MD5Utils.encrypt(currUser.getUsername(), user.getPassword()));
		int count = sysUserManager.updatePwd(user);
		return count;
	}

	@Override
	public SysUserTokenEntity saveUserToken(Integer userId) {
		SysUserTokenEntity token = sysUserManager.saveUserToken(userId);
		return token;
	}

	@Override
	public int updateUserToken(Integer userId) {
		int count = sysUserManager.updateUserToken(userId);
		return count;
	}

	@Override
	public SysUserEntity getByUserName(String username) {
		return sysUserManager.getByUserName(username);
	}

	@Override
	public Set<String> listUserRoles(Integer userId) {
		return this.sysUserManager.listUserRoles(userId);
	}
}
