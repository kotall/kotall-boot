package com.kotall.rms.core.manager.sys.impl;

import com.kotall.rms.common.dao.sys.SysCodeGenMapper;
import com.kotall.rms.common.entity.sys.SysGenColumnEntity;
import com.kotall.rms.common.entity.sys.SysGenTableEntity;
import com.kotall.rms.core.manager.BaseManagerImpl;
import com.kotall.rms.core.manager.sys.SysCodeGenManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 代码生成器
 *
 * @author aracwong
 * @date 2017年8月28日 下午8:54:44
 */
@Component("sysCodeGenManager")
public class SysCodeGenManagerImpl extends BaseManagerImpl<SysCodeGenMapper, SysGenTableEntity> implements SysCodeGenManager {

	@Autowired
	private SysCodeGenMapper sysCodeGenMapper;
	
	@Override
	public SysGenTableEntity getTableByName(String tableName) {
		return sysCodeGenMapper.getTableByName(tableName);
	}

	@Override
	public List<SysGenColumnEntity> getColumnsForTable(String tableName) {
		return sysCodeGenMapper.listColumn(tableName);
	}

}
