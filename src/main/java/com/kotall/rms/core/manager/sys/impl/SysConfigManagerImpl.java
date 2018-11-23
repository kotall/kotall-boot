package com.kotall.rms.core.manager.sys.impl;

import com.kotall.rms.common.dao.sys.SysConfigMapper;
import com.kotall.rms.common.entity.sys.SysConfigEntity;
import com.kotall.rms.common.utils.Query;
import com.kotall.rms.core.manager.BaseManagerImpl;
import com.kotall.rms.core.manager.sys.SysConfigManager;
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
public class SysConfigManagerImpl extends BaseManagerImpl<SysConfigMapper, SysConfigEntity> implements SysConfigManager {

	@Autowired
	private SysConfigMapper sysConfigMapper;


	@Override
	public SysConfigEntity queryByKey(String key) {
		return this.sysConfigMapper.queryByKey(key);
	}

	@Override
	public List<SysConfigEntity> queryAll(Query query) {
		return this.sysConfigMapper.list(query);
	}
}
