package com.kotall.rms.common.manager.sys.impl;

import java.util.List;

import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Query;
import com.kotall.rms.common.dao.sys.SysCodeGenMapper;
import com.kotall.rms.common.entity.sys.SysGenColumnEntity;
import com.kotall.rms.common.entity.sys.SysGenTableEntity;
import com.kotall.rms.common.manager.sys.SysCodeGenManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 代码生成器
 *
 * @author aracwong
 * @date 2017年8月28日 下午8:54:44
 */
@Component("sysCodeGenManager")
public class SysCodeGenManagerImpl implements SysCodeGenManager {

	@Autowired
	private SysCodeGenMapper sysCodeGenMapper;
	
	@Override
	public void listTable(Page<SysGenTableEntity> page, Query query) {
		sysCodeGenMapper.listTable(page, query);
	}

	@Override
	public SysGenTableEntity getTableByName(String tableName) {
		return sysCodeGenMapper.getTableByName(tableName);
	}

	@Override
	public List<SysGenColumnEntity> listColumn(String tableName) {
		return sysCodeGenMapper.listColumn(tableName);
	}

}
