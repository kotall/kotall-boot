package com.kotall.rms.core.manager.sys;

import com.kotall.rms.common.entity.sys.SysAreaEntity;
import com.kotall.rms.core.manager.BaseManager;

/**
 * 行政区域
 *
 * @author aracwong
 * @date 2017年8月18日 下午3:39:00
 */
public interface SysAreaManager extends BaseManager<SysAreaEntity> {

	boolean hasChildren(Integer[] id);

}
