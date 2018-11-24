package com.kotall.rms.core.manager.sys;

import com.kotall.rms.common.entity.sys.SysRoleEntity;
import com.kotall.rms.core.manager.BaseManager;

import java.util.List;

/**
 * 系统角色
 *
 * @author aracwong
 * @date 2017年8月12日 上午12:39:07
 */
public interface SysRoleManager extends BaseManager<SysRoleEntity> {

	SysRoleEntity getRoleById(Integer id);
	
	int batchRemove(Integer[] id);
	
	List<SysRoleEntity> queryAll();
	
	int updateRoleOptAuthorization(SysRoleEntity role);

	int updateRoleDataAuthorization(SysRoleEntity role);
	
}
