package com.kotall.rms.core.service.sys.impl;

import com.kotall.rms.common.entity.sys.SysRoleEntity;
import com.kotall.rms.core.manager.sys.SysRoleManager;
import com.kotall.rms.core.service.BaseServiceImpl;
import com.kotall.rms.core.service.sys.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 系统角色
 *
 * @author aracwong
 * @date 2017年8月12日 上午12:41:19
 */
@Service("sysRoleService")
public class SysRoleServiceImpl extends BaseServiceImpl<SysRoleManager, SysRoleEntity> implements SysRoleService {

	@Autowired
	private SysRoleManager sysRoleManager;


	@Override
	public SysRoleEntity getRoleById(Integer id) {
		SysRoleEntity role = sysRoleManager.getRoleById(id);
		return role;
	}

	@Override
	public int batchRemove(Integer[] id) {
		int count = sysRoleManager.batchRemove(id);
		return count;
	}

	@Override
	public List<SysRoleEntity> queryAll() {
		List<SysRoleEntity> roleList = sysRoleManager.queryAll();
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
