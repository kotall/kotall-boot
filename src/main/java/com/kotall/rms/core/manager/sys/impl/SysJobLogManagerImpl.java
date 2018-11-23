package com.kotall.rms.core.manager.sys.impl;

import com.kotall.rms.common.dao.sys.SysJobLogMapper;
import com.kotall.rms.common.entity.sys.SysJobLogEntity;
import com.kotall.rms.core.manager.BaseManagerImpl;
import com.kotall.rms.core.manager.sys.SysJobLogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 定时任务日志
 *
 * @author aracwong
 * @date 2017年8月20日 下午11:10:11
 */
@Component("sysJobLogManager")
public class SysJobLogManagerImpl extends BaseManagerImpl<SysJobLogMapper, SysJobLogEntity> implements SysJobLogManager {

	@Autowired
	private SysJobLogMapper sysJobLogMapper;

	@Override
	public int deleteAll() {
		return sysJobLogMapper.batchRemoveAll();
	}

}
