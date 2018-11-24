package com.kotall.rms.core.service.sys.impl;

import com.kotall.rms.common.entity.sys.SysMenuEntity;
import com.kotall.rms.common.utils.IdKit;
import com.kotall.rms.core.RmsException;
import com.kotall.rms.core.manager.sys.SysMenuManager;
import com.kotall.rms.core.service.BaseServiceImpl;
import com.kotall.rms.core.service.sys.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 系统菜单
 *
 * @author aracwong
 * @date 2017年8月10日 上午10:36:31
 */
@Service("sysMenuService")
public class SysMenuServiceImpl extends BaseServiceImpl<SysMenuManager, SysMenuEntity> implements SysMenuService {

	@Autowired
	private SysMenuManager sysMenuManager;

	@Override
	public List<SysMenuEntity> listUserMenu(Integer userId) {
		List<SysMenuEntity> menuList = sysMenuManager.listUserMenu(userId);
		return menuList;
	}

	@Override
	public List<SysMenuEntity> listNotButton() {
		List<SysMenuEntity> menuList = sysMenuManager.listNotButton();
		SysMenuEntity root = new SysMenuEntity();
		root.setMenuId(0);
		root.setName("一级菜单");
		root.setParentId(-1);
		root.setOpen(true);
		menuList.add(root);
		return menuList;
	}

	@Override
	public boolean save(SysMenuEntity menu) {
		Integer id = IdKit.getId(menu.getCode());
		menu.setMenuId(id);
		boolean count = sysMenuManager.save(menu);
		return count;
	}

	@Override
	public int batchRemove(Integer[] id) {
		boolean children = sysMenuManager.hasChildren(id);
		if(children) {
			throw RmsException.HAS_CHILD_EXCEPTION;
		}
		int count = sysMenuManager.batchRemove(id);
		return count;
	}

}
