package com.kotall.rms.core.service.sys.impl;

import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Query;
import com.kotall.rms.common.entity.sys.SysJobLogEntity;
import com.kotall.rms.common.manager.sys.SysJobLogManager;
import com.kotall.rms.core.service.sys.SysJobLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 定时任务日志
 *
 * @author aracwong
 * @date 2017年8月21日 上午11:18:22
 */
@Service("sysJobLogService")
public class SysJobLogServiceImpl implements SysJobLogService {

	@Autowired
	private SysJobLogManager sysJobLogManager;
	
	@Override
	public Page<SysJobLogEntity> listForPage(Map<String, Object> params) {
		Query query = new Query(params);
		Page<SysJobLogEntity> page = new Page<>(query);
		sysJobLogManager.listForPage(page, query);
		return page;
	}

	@Override
	public int batchRemove(Long[] id) {
		int count = sysJobLogManager.batchRemove(id);
		return count;
	}

	@Override
	public int batchRemoveAll() {
		int count = sysJobLogManager.batchRemoveAll();
		return count;
	}


}
