package com.kotall.rms.core.manager.sys.impl;

import com.kotall.rms.common.dao.sys.SysRoleMapper;
import com.kotall.rms.common.dao.sys.SysRoleMenuMapper;
import com.kotall.rms.common.dao.sys.SysRoleOrgMapper;
import com.kotall.rms.common.dao.sys.SysUserRoleMapper;
import com.kotall.rms.common.entity.sys.SysRoleEntity;
import com.kotall.rms.common.utils.Query;
import com.kotall.rms.core.manager.BaseManagerImpl;
import com.kotall.rms.core.manager.sys.SysRoleManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 系统角色
 *
 * @author aracwong
 * @date 2017年8月12日 上午12:39:48
 */
@Component("sysRoleManager")
public class SysRoleManagerImpl extends BaseManagerImpl<SysRoleMapper, SysRoleEntity> implements SysRoleManager {

	@Autowired
	private SysRoleMapper sysRoleMapper;
	
	@Autowired
	private SysUserRoleMapper sysUserRoleMapper;
	
	@Autowired
	private SysRoleMenuMapper sysRoleMenuMapper;
	
	@Autowired
	private SysRoleOrgMapper sysRoleOrgMapper;


	@Override
	public SysRoleEntity getRoleById(Integer id) {
		SysRoleEntity role = sysRoleMapper.getById(id);
		List<Integer> menuId = sysRoleMenuMapper.listMenuId(id);
		List<Integer> orgId = sysRoleOrgMapper.listOrgId(id);
		role.setMenuIdList(menuId);
		role.setOrgIdList(orgId);
		return role;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public int batchRemove(Integer[] id) {
		int count = sysRoleMapper.batchDelete(id);
		sysUserRoleMapper.batchRemoveByRoleId(id);
		sysRoleMenuMapper.batchRemoveByRoleId(id);
		sysRoleOrgMapper.batchRemoveByRoleId(id);
		return count;
	}

	@Override
	public List<SysRoleEntity> queryAll() {
		return sysRoleMapper.list(new Query());
	}

	@Override
	public int updateRoleOptAuthorization(SysRoleEntity role) {
		Integer roleId = role.getRoleId();
		int count = sysRoleMenuMapper.deleteById(roleId);
		Query query = new Query();
		query.put("roleId", roleId);
		List<Integer> menuId = role.getMenuIdList();
		if(menuId.size() > 0) {
			query.put("menuIdList", role.getMenuIdList());
			count = sysRoleMenuMapper.insert(query);
		}
		return count;
	}
	
	@Override
	@Transactional(rollbackFor = Exception.class)
	public int updateRoleDataAuthorization(SysRoleEntity role) {
		Integer roleId = role.getRoleId();
		int count = sysRoleOrgMapper.deleteById(roleId);
		Query query = new Query();
		query.put("roleId", roleId);
		List<Integer> orgId = role.getOrgIdList();
		if(orgId.size() > 0) {
			query.put("orgIdList", role.getOrgIdList());
			count = sysRoleOrgMapper.insert(query);
		}
		return count;
	}
	
}
