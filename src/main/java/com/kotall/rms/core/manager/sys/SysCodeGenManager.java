package com.kotall.rms.core.manager.sys;

import java.util.List;

import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Query;
import com.kotall.rms.common.entity.sys.SysGenColumnEntity;
import com.kotall.rms.common.entity.sys.SysGenTableEntity;

/**
 * 代码生成器
 *
 * @author aracwong
 * @date 2017年8月28日 下午8:54:09
 */
public interface SysCodeGenManager {

	void listTable(Page<SysGenTableEntity> page, Query query);
	
	SysGenTableEntity getTableByName(String tableName);
	
	List<SysGenColumnEntity> listColumn(String tableName);
	
}
