package com.kotall.rms.core.service.sys.impl;

import com.kotall.rms.common.entity.sys.SysLogEntity;
import com.kotall.rms.core.manager.sys.SysLogManager;
import com.kotall.rms.core.service.BaseServiceImpl;
import com.kotall.rms.core.service.sys.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 系统日志
 *
 * @author aracwong
 * @date 2017年8月14日 下午8:41:29
 */
@Service("sysLogService")
public class SysLogServiceImpl extends BaseServiceImpl<SysLogManager, SysLogEntity> implements SysLogService {

	@Autowired
	private SysLogManager sysLogManager;

	@Override
	public boolean deleteAll() {
		boolean count = sysLogManager.deleteAll();
		return count;
	}

}
