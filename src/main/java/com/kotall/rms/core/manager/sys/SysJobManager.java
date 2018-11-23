package com.kotall.rms.core.manager.sys;

import com.kotall.rms.common.entity.sys.SysJobEntity;
import com.kotall.rms.core.manager.BaseManager;

import java.util.List;

/**
 * 定时任务
 *
 * @author aracwong
 * @date 2017年8月20日 下午11:46:30
 */
public interface SysJobManager extends BaseManager<SysJobEntity> {

	List<SysJobEntity> listNormalJob();

	int batchUpdate(Integer[] jobId, Integer status);
	
}
