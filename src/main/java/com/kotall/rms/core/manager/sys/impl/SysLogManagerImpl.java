package com.kotall.rms.core.manager.sys.impl;

import com.kotall.rms.common.dao.sys.SysLogMapper;
import com.kotall.rms.common.entity.sys.SysLogEntity;
import com.kotall.rms.core.manager.BaseManagerImpl;
import com.kotall.rms.core.manager.sys.SysLogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 系统日志
 *
 * @author aracwong
 * @date 2017年8月14日 下午8:43:15
 */
@Component("sysLogManager")
public class SysLogManagerImpl extends BaseManagerImpl<SysLogMapper,SysLogEntity> implements SysLogManager {

	@Autowired
	private SysLogMapper sysLogMapper;
	
	@Override
	public boolean deleteAll() {
		return sysLogMapper.batchDeleteAll() > 0;
	}

}
