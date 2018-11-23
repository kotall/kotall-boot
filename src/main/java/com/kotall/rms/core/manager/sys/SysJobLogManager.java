package com.kotall.rms.core.manager.sys;

import com.kotall.rms.common.entity.sys.SysJobLogEntity;
import com.kotall.rms.core.manager.BaseManager;

/**
 * 定时任务日志
 *
 * @author aracwong
 * @date 2017年8月20日 下午11:06:56
 */
public interface SysJobLogManager extends BaseManager<SysJobLogEntity> {

	int deleteAll();
	
}
