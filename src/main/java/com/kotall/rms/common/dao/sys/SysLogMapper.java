package com.kotall.rms.common.dao.sys;

import com.kotall.rms.common.dao.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import com.kotall.rms.common.entity.sys.SysLogEntity;

/**
 * 系统日志 
 *
 * @author aracwong
 * @date 2017年8月14日 下午8:19:01
 */
@Mapper
public interface SysLogMapper extends BaseMapper<SysLogEntity> {

	int batchRemoveAll();
	
}
