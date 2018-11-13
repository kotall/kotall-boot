package com.kotall.rms.core.service.sys.impl;

import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Query;
import com.kotall.rms.common.entity.sys.SysRoleEntity;
import com.kotall.rms.common.manager.sys.SysRoleManager;
import com.kotall.rms.core.service.sys.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 系统角色
 *
 * @author aracwong
 * @date 2017年8月12日 上午12:41:19
 */
@Service("sysRoleService")
public class SysRoleServiceImpl implements SysRoleService {

	@Autowired
	private SysRoleManager sysRoleManager;

	@Override
	public Page<SysRoleEntity> listRole(Map<String, Object> params) {
		Query query = new Query(params);
		Page<SysRoleEntity> page = new Page<>(query);
		sysRoleManager.listRole(page, query);
		return page;
	}

	@Override
	public int saveRole(SysRoleEntity role) {
		int count = sysRoleManager.saveRole(role);
		return count;
	}

	@Override
	public SysRoleEntity getRoleById(Long id) {
		SysRoleEntity role = sysRoleManager.getRoleById(id);
		return role;
	}

	@Override
	public int updateRole(SysRoleEntity role) {
		int count = sysRoleManager.updateRole(role);
		return count;
	}

	@Override
	public int batchRemove(Long[] id) {
		int count = sysRoleManager.batchRemove(id);
		return count;
	}

	@Override
	public List<SysRoleEntity> listRole() {
		List<SysRoleEntity> roleList = sysRoleManager.listRole();
		return roleList;
	}

	@Override
	public int updateRoleOptAuthorization(SysRoleEntity role) {
		int count = sysRoleManager.updateRoleOptAuthorization(role);
		return count;
	}

	@Override
	public int updateRoleDataAuthorization(SysRoleEntity role) {
		int count = sysRoleManager.updateRoleDataAuthorization(role);
		return count;
	}
	
}
