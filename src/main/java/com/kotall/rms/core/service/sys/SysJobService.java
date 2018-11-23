package com.kotall.rms.core.service.sys;

import com.kotall.rms.common.entity.sys.SysJobEntity;
import com.kotall.rms.core.service.BaseService;

/**
 * 定时任务
 *
 * @author aracwong
 * @date 2017年8月20日 下午11:48:32
 */
public interface SysJobService extends BaseService<SysJobEntity> {

	boolean saveQuartzJob(SysJobEntity job);

	boolean updateQuartzJob(SysJobEntity job);

	boolean batchRemoveQuartzJob(Integer[] id);
	
	int run(Integer[] id);
	
	int pause(Integer[] id);
	
	int resume(Integer[] id);
	
}
