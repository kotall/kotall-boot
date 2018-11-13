package com.kotall.rms.core.manager.sys.impl;

import com.kotall.rms.common.dao.sys.SysConfigMapper;
import com.kotall.rms.common.entity.sys.SysConfigEntity;
import com.kotall.rms.core.manager.sys.SysConfigManager;
import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 系统配置信息表
 *
 * @author kotall
 * @date 2018年11月12日 下午9:18:45
 * @since 1.0.0
 */
@Component("sysConfigManager")
public class SysConfigManagerImpl implements SysConfigManager {

	@Autowired
	private SysConfigMapper sysConfigMapper;

	@Override
	public List<SysConfigEntity> listSysConfig(Page<SysConfigEntity> page, Query search) {
		return sysConfigMapper.listForPage(page, search);
	}

	@Override
	public int saveSysConfig(SysConfigEntity sysConfig) {
		return sysConfigMapper.save(sysConfig);
	}

	@Override
	public SysConfigEntity getSysConfigById(Long id) {
		SysConfigEntity sysConfig = sysConfigMapper.getObjectById(id);
		return sysConfig;
	}

	@Override
	public int updateSysConfig(SysConfigEntity sysConfig) {
		return sysConfigMapper.update(sysConfig);
	}

	@Override
	public int batchRemove(Long[] id) {
		int count = sysConfigMapper.batchRemove(id);
		return count;
	}

	@Override
	public SysConfigEntity queryByKey(String key) {
		return this.sysConfigMapper.queryByKey(key);
	}
}
