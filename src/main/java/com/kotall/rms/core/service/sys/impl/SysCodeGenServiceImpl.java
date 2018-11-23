package com.kotall.rms.core.service.sys.impl;

import com.kotall.rms.common.entity.sys.SysGenColumnEntity;
import com.kotall.rms.common.entity.sys.SysGenTableEntity;
import com.kotall.rms.core.manager.sys.SysCodeGenManager;
import com.kotall.rms.core.service.BaseServiceImpl;
import com.kotall.rms.core.service.sys.SysCodeGenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 代码生成器
 *
 * @author aracwong
 * @date 2017年8月28日 下午8:55:51
 */
@Service("sysCodeGenService")
public class SysCodeGenServiceImpl extends BaseServiceImpl<SysCodeGenManager, SysGenTableEntity> implements SysCodeGenService {

	@Autowired
	private SysCodeGenManager sysCodeGenManager;
	
	@Override
	public SysGenTableEntity getTableByName(String tableName) {
		return sysCodeGenManager.getTableByName(tableName);
	}

	@Override
	public List<SysGenColumnEntity> getColumnsForTable(String tableName) {
		return sysCodeGenManager.getColumnsForTable(tableName);
	}
}
