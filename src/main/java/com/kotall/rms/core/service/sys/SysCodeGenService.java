package com.kotall.rms.core.service.sys;

import com.kotall.rms.common.entity.sys.SysGenColumnEntity;
import com.kotall.rms.common.entity.sys.SysGenTableEntity;
import com.kotall.rms.core.service.BaseService;

import java.util.List;

/**
 * 代码生成器
 *
 * @author aracwong
 * @date 2017年8月28日 下午8:55:29
 */
public interface SysCodeGenService extends BaseService<SysGenTableEntity> {


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
	List<SysGenColumnEntity> getColumnsForTable(String tableName);
}
