package com.kotall.rms.core.manager.sys;

import java.util.List;

import com.kotall.rms.common.utils.Query;
import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.entity.sys.SysLogEntity;

/**
 * 系统日志
 *
 * @author aracwong
 * @date 2017年8月14日 下午8:43:06
 */
public interface SysLogManager {

	void saveLog(SysLogEntity log);
	
	List<SysLogEntity> listLog(Page<SysLogEntity> page, Query query);
	
	int batchRemove(Long[] id);
	
	int batchRemoveAll();
	
}
