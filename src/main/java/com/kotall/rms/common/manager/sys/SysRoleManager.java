package com.kotall.rms.common.manager.sys;

import java.util.List;

import com.kotall.rms.common.utils.Query;
import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.entity.sys.SysRoleEntity;

/**
 * 系统角色
 *
 * @author aracwong
 * @date 2017年8月12日 上午12:39:07
 */
public interface SysRoleManager {

	List<SysRoleEntity> listRole(Page<SysRoleEntity> page, Query search);
	
	int saveRole(SysRoleEntity role);
	
	SysRoleEntity getRoleById(Long id);
	
	int updateRole(SysRoleEntity role);
	
	int batchRemove(Long[] id);
	
	List<SysRoleEntity> listRole();
	
	int updateRoleOptAuthorization(SysRoleEntity role);

	int updateRoleDataAuthorization(SysRoleEntity role);
	
}
