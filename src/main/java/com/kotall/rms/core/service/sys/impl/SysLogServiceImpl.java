package com.kotall.rms.core.service.sys.impl;

import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Query;
import com.kotall.rms.common.entity.sys.SysLogEntity;
import com.kotall.rms.common.manager.sys.SysLogManager;
import com.kotall.rms.core.service.sys.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 系统日志
 *
 * @author aracwong
 * @date 2017年8月14日 下午8:41:29
 */
@Service("sysLogService")
public class SysLogServiceImpl implements SysLogService {

	@Autowired
	private SysLogManager sysLogManager;
	
	@Override
	public Page<SysLogEntity> listLog(Map<String, Object> params) {
		Query query = new Query(params);
		Page<SysLogEntity> page = new Page<>(query);
		sysLogManager.listLog(page, query);
		return page;
	}

	@Override
	public int batchRemove(Long[] id) {
		int count = sysLogManager.batchRemove(id);
		return count;
	}

	@Override
	public int batchRemoveAll() {
		int count = sysLogManager.batchRemoveAll();
		return count;
	}

}
