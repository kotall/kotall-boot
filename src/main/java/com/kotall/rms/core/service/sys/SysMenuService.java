package com.kotall.rms.core.service.sys;

import com.kotall.rms.common.entity.sys.SysMenuEntity;

import java.util.List;
import java.util.Map;

/**
 * 系统菜单
 *
 * @author aracwong
 * @date 2017年8月10日 上午10:35:58
 */
public interface SysMenuService {

	List<SysMenuEntity> listUserMenu(Long userId);
	
	List<SysMenuEntity> listMenu(Map<String, Object> params);

	List<SysMenuEntity> listNotButton();
	
	int saveMenu(SysMenuEntity menu);

	SysMenuEntity getMenuById(Long id);
	
	int updateMenu(SysMenuEntity menu);
	
	int batchRemove(Long[] id);

}
