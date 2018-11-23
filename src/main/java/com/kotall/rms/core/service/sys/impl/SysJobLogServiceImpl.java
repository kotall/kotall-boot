package com.kotall.rms.core.service.sys.impl;

import com.kotall.rms.common.entity.sys.SysJobLogEntity;
import com.kotall.rms.core.manager.sys.SysJobLogManager;
import com.kotall.rms.core.service.BaseServiceImpl;
import com.kotall.rms.core.service.sys.SysJobLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 定时任务日志
 *
 * @author aracwong
 * @date 2017年8月21日 上午11:18:22
 */
@Service("sysJobLogService")
public class SysJobLogServiceImpl extends BaseServiceImpl<SysJobLogManager, SysJobLogEntity> implements SysJobLogService {

	@Autowired
	private SysJobLogManager sysJobLogManager;
	
	@Override
	public int deleteAll() {
		int count = sysJobLogManager.deleteAll();
		return count;
	}


}
