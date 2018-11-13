package com.kotall.rms.common.manager.sys.impl;

import java.util.List;

import com.kotall.rms.common.utils.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.dao.sys.SysLogMapper;
import com.kotall.rms.common.entity.sys.SysLogEntity;
import com.kotall.rms.common.manager.sys.SysLogManager;

/**
 * 系统日志
 *
 * @author aracwong
 * @date 2017年8月14日 下午8:43:15
 */
@Component("sysLogManager")
public class SysLogManagerImpl implements SysLogManager {

	@Autowired
	private SysLogMapper sysLogMapper;
	
	@Override
	public void saveLog(SysLogEntity log) {
		sysLogMapper.save(log);
	}

	@Override
	public List<SysLogEntity> listLog(Page<SysLogEntity> page, Query query) {
		return sysLogMapper.listForPage(page, query);
	}

	@Override
	public int batchRemove(Long[] id) {
		return sysLogMapper.batchRemove(id);
	}

	@Override
	public int batchRemoveAll() {
		return sysLogMapper.batchRemoveAll();
	}

}
