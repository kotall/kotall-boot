package com.kotall.rms.core.manager.sys;

import com.kotall.rms.common.entity.sys.SysMenuEntity;
import com.kotall.rms.core.manager.BaseManager;

import java.util.List;

/**
 * 系统菜单
 *
 * @author aracwong
 * @date 2017年8月10日 上午10:34:59
 */
public interface SysMenuManager extends BaseManager<SysMenuEntity> {

	List<SysMenuEntity> listUserMenu(Long userId);
	
	List<SysMenuEntity> listParentId(Long parentId, List<Long> menuIdList);

	List<SysMenuEntity> listNotButton();

	int batchRemove(Long[] id);
	
	boolean hasChildren(Long[] id);
	
}
