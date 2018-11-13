package com.kotall.rms.common.manager.sys;

import java.util.List;

import com.kotall.rms.common.utils.Query;
import com.kotall.rms.common.entity.sys.SysJobLogEntity;
import com.kotall.rms.common.utils.Page;

/**
 * 定时任务日志
 *
 * @author aracwong
 * @date 2017年8月20日 下午11:06:56
 */
public interface SysJobLogManager {

	List<SysJobLogEntity> listForPage(Page<SysJobLogEntity> page, Query query);
	
	int saveQuartzJobLog(SysJobLogEntity log);
	
	int batchRemove(Long[] id);
	
	int batchRemoveAll();
	
}
