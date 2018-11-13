package com.kotall.rms.core.service.sys;

import java.util.List;
import java.util.Map;

import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.entity.sys.SysGenColumnEntity;
import com.kotall.rms.common.entity.sys.SysGenTableEntity;

/**
 * 代码生成器
 *
 * @author aracwong
 * @date 2017年8月28日 下午8:55:29
 */
public interface SysCodeGenService {

	Page<SysGenTableEntity> listTable(Map<String, Object> params);
	

	/**
	 * 根据表名获取表实体
	 *
	 * @param tableName
	 * @return
	 */
	SysGenTableEntity getTableByName(String tableName);

	/**
	 * 根据表名字获取表字段对象
	 *
	 * @param tableName
	 * @return
	 */
	List<SysGenColumnEntity> listColumn(String tableName);
}
