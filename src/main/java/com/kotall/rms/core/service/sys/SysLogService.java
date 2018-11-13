package com.kotall.rms.core.service.sys;

import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.entity.sys.SysLogEntity;

import java.util.Map;

/**
 * 系统日志
 *
 * @author aracwong
 * @date 2017年8月14日 下午8:40:52
 */
public interface SysLogService {

	Page<SysLogEntity> listLog(Map<String, Object> params);
	
	int batchRemove(Long[] id);
	
	int batchRemoveAll();
	
}
