package com.kotall.rms.core.service.sys;

import com.kotall.rms.common.entity.sys.SysMenuEntity;
import com.kotall.rms.core.service.BaseService;

import java.util.List;

/**
 * 系统菜单
 *
 * @author aracwong
 * @date 2017年8月10日 上午10:35:58
 */
public interface SysMenuService extends BaseService<SysMenuEntity> {

	List<SysMenuEntity> listUserMenu(Long userId);

	List<SysMenuEntity> listNotButton();

	int batchRemove(Long[] id);

}
