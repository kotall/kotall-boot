package com.kotall.rms.common.dao.sys;

import com.kotall.rms.common.entity.sys.SysGenColumnEntity;
import com.kotall.rms.common.entity.sys.SysGenTableEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 代码生成器
 *
 * @author aracwong
 * @date 2017年8月28日 下午8:47:12
 */
@Mapper
public interface SysCodeGenMapper extends BaseMapper<SysGenTableEntity> {

	SysGenTableEntity getTableByName(String tableName);
	
	List<SysGenColumnEntity> listColumn(String tableName);
	
}
