package com.kotall.rms.core.manager.sys.impl;

import java.util.List;

import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Query;
import com.kotall.rms.common.entity.sys.SysJobLogEntity;
import com.kotall.rms.core.manager.sys.SysJobLogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kotall.rms.common.dao.sys.SysJobLogMapper;

/**
 * 定时任务日志
 *
 * @author aracwong
 * @date 2017年8月20日 下午11:10:11
 */
@Component("sysJobLogManager")
public class SysJobLogManagerImpl implements SysJobLogManager {

	@Autowired
	private SysJobLogMapper sysJobLogMapper;
	
	@Override
	public List<SysJobLogEntity> listForPage(Page<SysJobLogEntity> page, Query query) {
		return sysJobLogMapper.listForPage(page, query);
	}

	@Override
	public int saveQuartzJobLog(SysJobLogEntity log) {
		return sysJobLogMapper.save(log);
	}

	@Override
	public int batchRemove(Long[] id) {
		return sysJobLogMapper.batchRemove(id);
	}

	@Override
	public int batchRemoveAll() {
		return sysJobLogMapper.batchRemoveAll();
	}

}
