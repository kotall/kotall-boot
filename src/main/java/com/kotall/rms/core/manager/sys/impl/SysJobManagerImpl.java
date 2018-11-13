package com.kotall.rms.core.manager.sys.impl;

import java.util.List;

import com.kotall.rms.common.utils.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.dao.sys.SysJobMapper;
import com.kotall.rms.common.entity.sys.SysJobEntity;
import com.kotall.rms.core.manager.sys.SysJobManager;

/**
 * 定时任务
 *
 * @author aracwong
 * @date 2017年8月20日 下午11:47:19
 */
@Component("sysJobManager")
public class SysJobManagerImpl implements SysJobManager {

	@Autowired
	private SysJobMapper sysJobMapper;
	
	@Override
	public List<SysJobEntity> listNormalJob() {
		return sysJobMapper.list();
	}

	@Override
	public List<SysJobEntity> listForPage(Page<SysJobEntity> page, Query query) {
		return sysJobMapper.listForPage(page, query);
	}

	@Override
	public int saveQuartzJob(SysJobEntity job) {
		return sysJobMapper.save(job);
	}

	@Override
	public SysJobEntity getQuartzJobById(Long jobId) {
		return sysJobMapper.getObjectById(jobId);
	}

	@Override
	public int updateQuartzJob(SysJobEntity job) {
		return sysJobMapper.update(job);
	}

	@Override
	public int batchRemoveQuartzJob(Long[] id) {
		return sysJobMapper.batchRemove(id);
	}

	@Override
	public int batchUpdate(Long[] jobId, Integer status) {
		Query query = new Query();
		query.put("jobIdList", jobId);
		query.put("status", status);
		return sysJobMapper.batchUpdate(query);
	}

}
