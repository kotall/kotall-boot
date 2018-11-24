package com.kotall.rms.core.manager.sys;

import com.kotall.rms.common.entity.sys.SysUserEntity;
import com.kotall.rms.common.entity.sys.SysUserTokenEntity;
import com.kotall.rms.common.utils.Query;
import com.kotall.rms.core.manager.BaseManager;

import java.util.Set;

/**
 * 系统用户
 *
 * @author aracwong
 * @date 2017年8月11日 上午11:43:01
 */
public interface SysUserManager extends BaseManager<SysUserEntity> {

	SysUserEntity getByUserName(String username);

	boolean saveUser(SysUserEntity user);
	
	SysUserEntity getById(Integer userId);
	
	boolean updateUser(SysUserEntity user);
	
	int batchRemove(Integer[] id);
	
	Set<String> listUserPerms(Integer userId);
	
	Set<String> listUserRoles(Integer userId);
	
	int updatePwdByUser(Query query);
	
	int updateUserEnable(Integer[] id);
	
	int updateUserDisable(Integer[] id);
	
	int updatePwd(SysUserEntity user);

	SysUserTokenEntity getByToken(String token);
	
	SysUserTokenEntity saveUserToken(Integer userId);
	
	int updateUserToken(Integer userId);

}
