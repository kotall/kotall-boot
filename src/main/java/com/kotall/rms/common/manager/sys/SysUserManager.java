package com.kotall.rms.common.manager.sys;

import java.util.List;
import java.util.Set;

import com.kotall.rms.common.utils.Query;
import com.kotall.rms.common.entity.sys.SysUserEntity;
import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.entity.sys.SysUserTokenEntity;

/**
 * 系统用户
 *
 * @author aracwong
 * @date 2017年8月11日 上午11:43:01
 */
public interface SysUserManager {

	SysUserEntity getByUserName(String username);
	
	List<SysUserEntity> listUser(Page<SysUserEntity> page, Query search);
	
	int saveUser(SysUserEntity user);
	
	SysUserEntity getById(Long userId);
	
	int updateUser(SysUserEntity user);
	
	int batchRemove(Long[] id);
	
	Set<String> listUserPerms(Long userId);
	
	Set<String> listUserRoles(Long userId);
	
	int updatePwdByUser(Query query);
	
	int updateUserEnable(Long[] id);
	
	int updateUserDisable(Long[] id);
	
	int updatePwd(SysUserEntity user);
	
	SysUserEntity getUserById(Long userId);
	
	SysUserTokenEntity getByToken(String token);
	
	SysUserTokenEntity saveUserToken(Long userId);
	
	int updateUserToken(Long userId);

}
