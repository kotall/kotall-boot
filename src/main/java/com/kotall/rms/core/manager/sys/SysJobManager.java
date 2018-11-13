package com.kotall.rms.core.manager.sys;

import java.util.List;

import com.kotall.rms.common.utils.Query;
import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.entity.sys.SysJobEntity;

/**
 * 定时任务
 *
 * @author aracwong
 * @date 2017年8月20日 下午11:46:30
 */
public interface SysJobManager {

	List<SysJobEntity> listForPage(Page<SysJobEntity> page, Query query);
	
	List<SysJobEntity> listNormalJob();
	
	int saveQuartzJob(SysJobEntity job);
	
	SysJobEntity getQuartzJobById(Long jobId);
	
	int updateQuartzJob(SysJobEntity job);
	
	int batchRemoveQuartzJob(Long[] id);
	
	int batchUpdate(Long[] jobId, Integer status);
	
}
