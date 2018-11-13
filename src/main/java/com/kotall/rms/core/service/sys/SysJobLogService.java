package com.kotall.rms.core.service.sys;

import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.entity.sys.SysJobLogEntity;

import java.util.Map;

/**
 * 定时任务日志
 *
 * @author aracwong
 * @date 2017年8月21日 上午11:17:26
 */
public interface SysJobLogService {

	Page<SysJobLogEntity> listForPage(Map<String, Object> params);
	
	int batchRemove(Long[] id);
	
	int batchRemoveAll();
	
}
