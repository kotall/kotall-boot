package com.kotall.rms.core.service.sys;

import com.kotall.rms.common.entity.sys.SysLogEntity;
import com.kotall.rms.core.service.BaseService;

/**
 * 系统日志
 *
 * @author aracwong
 * @date 2017年8月14日 下午8:40:52
 */
public interface SysLogService extends BaseService<SysLogEntity> {

	boolean deleteAll();
	
}
