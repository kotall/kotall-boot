package com.kotall.rms.common.dao.sys;

import java.util.List;

import com.kotall.rms.common.utils.Query;
import com.kotall.rms.common.entity.sys.SysGenTableEntity;
import org.apache.ibatis.annotations.Mapper;
import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.entity.sys.SysGenColumnEntity;

/**
 * 代码生成器
 *
 * @author aracwong
 * @date 2017年8月28日 下午8:47:12
 */
@Mapper
public interface SysCodeGenMapper {

	List<SysGenTableEntity> listTable(Page<SysGenTableEntity> page, Query query);
	
	SysGenTableEntity getTableByName(String tableName);
	
	List<SysGenColumnEntity> listColumn(String tableName);
	
}
