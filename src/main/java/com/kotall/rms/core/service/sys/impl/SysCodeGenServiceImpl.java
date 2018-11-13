package com.kotall.rms.core.service.sys.impl;

import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Query;
import com.kotall.rms.common.entity.sys.SysGenColumnEntity;
import com.kotall.rms.common.entity.sys.SysGenTableEntity;
import com.kotall.rms.common.manager.sys.SysCodeGenManager;
import com.kotall.rms.core.service.sys.SysCodeGenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 代码生成器
 *
 * @author aracwong
 * @date 2017年8月28日 下午8:55:51
 */
@Service("sysCodeGenService")
public class SysCodeGenServiceImpl implements SysCodeGenService {

	@Autowired
	private SysCodeGenManager sysCodeGenManager;
	
	@Override
	public Page<SysGenTableEntity> listTable(Map<String, Object> params) {
		Query query = new Query(params);
		Page<SysGenTableEntity> page = new Page<>(query);
		sysCodeGenManager.listTable(page, query);
		return page;
	}

	@Override
	public SysGenTableEntity getTableByName(String tableName) {
		return sysCodeGenManager.getTableByName(tableName);
	}

	@Override
	public List<SysGenColumnEntity> listColumn(String tableName) {
		return sysCodeGenManager.listColumn(tableName);
	}
}
