package com.kotall.rms.core.service.sys;

import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.entity.sys.SysRoleEntity;

import java.util.List;
import java.util.Map;

/**
 * 系统角色
 *
 * @author aracwong
 * @date 2017年8月12日 上午12:40:42
 */
public interface SysRoleService {

	Page<SysRoleEntity> listRole(Map<String, Object> params);
	
	int saveRole(SysRoleEntity role);

	SysRoleEntity getRoleById(Long id);
	
	int updateRole(SysRoleEntity role);
	
	int batchRemove(Long[] id);

	List<SysRoleEntity> listRole();
	
	int updateRoleOptAuthorization(SysRoleEntity role);
	
	int updateRoleDataAuthorization(SysRoleEntity role);
	
}
