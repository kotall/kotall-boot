package com.kotall.rms.core.service.sys;

import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.entity.sys.SysUserEntity;
import com.kotall.rms.common.entity.sys.SysUserTokenEntity;

import java.util.Map;
import java.util.Set;

/**
 * 系统用户
 *
 * @author aracwong
 * @date 2017年8月11日 上午11:45:42
 */
public interface SysUserService {

	Page<SysUserEntity> listUser(Map<String, Object> params);
	
	int saveUser(SysUserEntity user);

	SysUserEntity getUserById(Long userId);
	
	int updateUser(SysUserEntity user);
	
	int batchRemove(Long[] id);

	Set<String> listUserPerms(Long userId);
	
	int updatePwdByUser(SysUserEntity user);
	
	int updateUserEnable(Long[] id);
	
	int updateUserDisable(Long[] id);
	
	int updatePwd(SysUserEntity user);

	SysUserTokenEntity saveUserToken(Long userId);
	
	int updateUserToken(Long userId);
	
	SysUserEntity getByUserName(String username);
	
}
