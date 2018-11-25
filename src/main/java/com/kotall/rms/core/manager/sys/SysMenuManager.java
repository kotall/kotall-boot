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

	/**
	 * 查询出用户所拥有的菜单列表
	 * @param userId
	 * @return
	 */
	List<SysMenuEntity> listUserMenu(Integer userId);

	/**
	 * 根据已授权的菜单中筛选出根菜单
	 * @param parentId
	 * @param menuIdList
	 * @return
	 */
	List<SysMenuEntity> queryUserAuthParentMenuList(Integer parentId, List<Integer> menuIdList);

	List<SysMenuEntity> listNotButton();

	int batchRemove(Integer[] id);
	
	boolean hasChildren(Integer[] id);
	
}
