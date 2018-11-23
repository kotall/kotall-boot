package com.kotall.rms.core.service.sys;

import com.kotall.rms.common.entity.sys.SysJobLogEntity;
import com.kotall.rms.core.service.BaseService;

/**
 * 定时任务日志
 *
 * @author aracwong
 * @date 2017年8月21日 上午11:17:26
 */
public interface SysJobLogService extends BaseService<SysJobLogEntity> {

	int deleteAll();
	
}
