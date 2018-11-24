package com.kotall.rms.core.manager.sys.impl;

import com.kotall.rms.common.dao.sys.SysJobMapper;
import com.kotall.rms.common.entity.sys.SysJobEntity;
import com.kotall.rms.common.utils.Query;
import com.kotall.rms.core.manager.BaseManagerImpl;
import com.kotall.rms.core.manager.sys.SysJobManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 定时任务
 *
 * @author aracwong
 * @date 2017年8月20日 下午11:47:19
 */
@Component("sysJobManager")
public class SysJobManagerImpl extends BaseManagerImpl<SysJobMapper, SysJobEntity> implements SysJobManager {

	@Autowired
	private SysJobMapper sysJobMapper;
	
	@Override
	public List<SysJobEntity> listNormalJob() {
		return sysJobMapper.list(new Query());
	}

	@Override
	public int batchUpdate(Integer[] jobId, Integer status) {
		Query query = new Query();
		query.put("jobIdList", jobId);
		query.put("status", status);
		return sysJobMapper.batchUpdate(query);
	}

}
