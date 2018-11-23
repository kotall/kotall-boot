package com.kotall.rms.core.manager.sys;

import com.kotall.rms.common.entity.sys.SysLogEntity;
import com.kotall.rms.core.manager.BaseManager;

/**
 * 系统日志
 *
 * @author aracwong
 * @date 2017年8月14日 下午8:43:06
 */
public interface SysLogManager extends BaseManager<SysLogEntity> {

	boolean deleteAll();
	
}
