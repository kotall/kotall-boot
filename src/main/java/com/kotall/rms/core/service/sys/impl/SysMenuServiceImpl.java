package com.kotall.rms.core.service.sys.impl;

import com.kotall.rms.common.utils.IdKit;
import com.kotall.rms.common.utils.Query;
import com.kotall.rms.core.RmsException;
import com.kotall.rms.common.entity.sys.SysMenuEntity;
import com.kotall.rms.common.manager.sys.SysMenuManager;
import com.kotall.rms.core.service.sys.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 系统菜单
 *
 * @author aracwong
 * @date 2017年8月10日 上午10:36:31
 */
@Service("sysMenuService")
public class SysMenuServiceImpl implements SysMenuService {

	@Autowired
	private SysMenuManager sysMenuManager;

	@Override
	public List<SysMenuEntity> listUserMenu(Long userId) {
		List<SysMenuEntity> menuList = sysMenuManager.listUserMenu(userId);
		return menuList;
	}

	@Override
	public List<SysMenuEntity> listMenu(Map<String, Object> params) {
		Query query = new Query(params);
		List<SysMenuEntity> menuList = sysMenuManager.listMenu(query);
		return menuList;
	}

	@Override
	public List<SysMenuEntity> listNotButton() {
		List<SysMenuEntity> menuList = sysMenuManager.listNotButton();
		SysMenuEntity root = new SysMenuEntity();
		root.setMenuId(0L);
		root.setName("一级菜单");
		root.setParentId(-1L);
		root.setOpen(true);
		menuList.add(root);
		return menuList;
	}

	@Override
	public int saveMenu(SysMenuEntity menu) {
		long id = IdKit.getId(menu.getCode());
		menu.setMenuId(id);
		int count = sysMenuManager.saveMenu(menu);
		return count;
	}

	@Override
	public SysMenuEntity getMenuById(Long id) {
		SysMenuEntity menu = sysMenuManager.getMenuById(id);
		return menu;
	}

	@Override
	public int updateMenu(SysMenuEntity menu) {
		int count = sysMenuManager.updateMenu(menu);
		return count;
	}

	@Override
	public int batchRemove(Long[] id) {
		boolean children = sysMenuManager.hasChildren(id);
		if(children) {
			throw RmsException.HAS_CHILD_EXCEPTION;
		}
		int count = sysMenuManager.batchRemove(id);
		return count;
	}

}
