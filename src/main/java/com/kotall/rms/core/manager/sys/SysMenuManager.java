package com.kotall.rms.core.manager.sys;

import java.util.List;

import com.kotall.rms.common.utils.Query;
import com.kotall.rms.common.entity.sys.SysMenuEntity;

/**
 * 系统菜单
 *
 * @author aracwong
 * @date 2017年8月10日 上午10:34:59
 */
public interface SysMenuManager {
	
	List<SysMenuEntity> listUserMenu(Long userId);
	
	List<SysMenuEntity> listParentId(Long parentId, List<Long> menuIdList);
	
	List<SysMenuEntity> listMenu(Query search);
	
	List<SysMenuEntity> listNotButton();
	
	int saveMenu(SysMenuEntity menu);

	SysMenuEntity getMenuById(Long id);
	
	int updateMenu(SysMenuEntity menu);
	
	int batchRemove(Long[] id);
	
	boolean hasChildren(Long[] id);
	
}
