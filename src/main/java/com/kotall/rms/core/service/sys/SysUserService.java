package com.kotall.rms.core.service.sys;

import com.kotall.rms.common.entity.sys.SysUserEntity;
import com.kotall.rms.common.entity.sys.SysUserTokenEntity;
import com.kotall.rms.core.service.BaseService;

import java.util.Set;

/**
 * 系统用户
 *
 * @author aracwong
 * @date 2017年8月11日 上午11:45:42
 */
public interface SysUserService extends BaseService<SysUserEntity> {

	Set<String> listUserPerms(Integer userId);

	SysUserTokenEntity getUserTokenInfoByToken(String token);

	int updatePwdByUser(SysUserEntity user);
	
	int updateUserEnable(Integer[] id);
	
	int updateUserDisable(Integer[] id);
	
	int updatePwd(SysUserEntity user);

	SysUserTokenEntity saveUserToken(Integer userId);
	
	int updateUserToken(Integer userId);
	
	SysUserEntity getByUserName(String username);

	Set<String> listUserRoles(Integer userId);
}
