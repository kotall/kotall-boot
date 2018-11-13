package com.kotall.rms.core.service.sys;

import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.entity.sys.SysJobEntity;

import java.util.Map;

/**
 * 定时任务
 *
 * @author aracwong
 * @date 2017年8月20日 下午11:48:32
 */
public interface SysJobService {
	
	Page<SysJobEntity> list(Map<String, Object> params);
	
	int saveQuartzJob(SysJobEntity job);
	
	SysJobEntity getQuartzJobById(Long jobId);
	
	int updateQuartzJob(SysJobEntity job);
	
	int batchRemoveQuartzJob(Long[] id);
	
	int run(Long[] id);
	
	int pause(Long[] id);
	
	int resume(Long[] id);
	
}
