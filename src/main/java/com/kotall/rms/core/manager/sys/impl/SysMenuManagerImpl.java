package com.kotall.rms.core.manager.sys.impl;

import com.kotall.rms.common.dao.sys.SysMenuMapper;
import com.kotall.rms.common.dao.sys.SysRoleMenuMapper;
import com.kotall.rms.common.dao.sys.SysUserMapper;
import com.kotall.rms.common.entity.sys.SysMenuEntity;
import com.kotall.rms.core.enums.MenuType;
import com.kotall.rms.core.manager.BaseManagerImpl;
import com.kotall.rms.core.manager.sys.SysMenuManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 系统菜单
 * 
 * @author aracwong
 * @date 2017年8月10日 上午10:35:24
 */
@Component("sysMenuManager")
public class SysMenuManagerImpl extends BaseManagerImpl<SysMenuMapper, SysMenuEntity> implements SysMenuManager {

	@Autowired
	private SysUserMapper sysUserMapper;
	
	@Autowired
	private SysMenuMapper sysMenuMapper;
	
	@Autowired
	private SysRoleMenuMapper sysRoleMenuMapper;
	
	@Override
	public List<SysMenuEntity> listUserMenu(Long userId) {
		if (1L == userId) {
			return getAllMenuList(null);
		}
		List<Long> menuIdList = sysUserMapper.listAllMenuId(userId);
		return getAllMenuList(menuIdList);
	}
	
	/**
	 * 获取所有菜单列表
	 */
	private List<SysMenuEntity> getAllMenuList(List<Long> menuIdList){
		// 查询根菜单列表
		List<SysMenuEntity> menuList = listParentId(0L, menuIdList);
		// 递归获取子菜单
		getMenuTreeList(menuList, menuIdList);
		
		return menuList;
	}

	/**
	 * 递归
	 */
	private List<SysMenuEntity> getMenuTreeList(List<SysMenuEntity> menuList, List<Long> menuIdList){
		List<SysMenuEntity> subMenuList = new ArrayList<>();
		
		for(SysMenuEntity entity : menuList){
			if(entity.getType() == MenuType.CATALOG.getValue()){//目录
				entity.setList(getMenuTreeList(listParentId(entity.getMenuId(), menuIdList), menuIdList));
			}
			subMenuList.add(entity);
		}
		return subMenuList;
	}

	@Override
	public List<SysMenuEntity> listParentId(Long parentId, List<Long> menuIdList) {
		List<SysMenuEntity> menuList = sysMenuMapper.listParentId(parentId);
		if(menuIdList == null){
			return menuList;
		}
		
		List<SysMenuEntity> userMenuList = new ArrayList<>();
		for(SysMenuEntity menu : menuList){
			if(menuIdList.contains(menu.getMenuId())){
				userMenuList.add(menu);
			}
		}
		return userMenuList;
	}

	@Override
	public List<SysMenuEntity> listNotButton() {
		return sysMenuMapper.listNotButton();
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public int batchRemove(Long[] id) {
		int count = sysMenuMapper.batchRemove(id);
		sysRoleMenuMapper.batchRemoveByMenuId(id);
		return count;
	}

	@Override
	public boolean hasChildren(Long[] id) {
		for(Long parentId : id) {
			int count = sysMenuMapper.countMenuChildren(parentId);
			if(count > 0) {
				return true;
			}
		}
		return false;
	}

}
