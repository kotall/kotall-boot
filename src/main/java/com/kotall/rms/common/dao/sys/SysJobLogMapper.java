package com.kotall.rms.common.dao.sys;

import org.apache.ibatis.annotations.Mapper;
import com.kotall.rms.common.entity.sys.SysJobLogEntity;

/**
 * 定时任务日志
 *
 * @author aracwong
 * @date 2017年8月20日 下午11:04:51
 */
@Mapper
public interface SysJobLogMapper extends BaseMapper<SysJobLogEntity> {

	int batchRemoveAll();
	
}
