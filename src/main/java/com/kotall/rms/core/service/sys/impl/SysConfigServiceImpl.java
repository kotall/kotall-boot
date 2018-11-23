package com.kotall.rms.core.service.sys.impl;

import com.kotall.rms.common.entity.sys.SysConfigEntity;
import com.kotall.rms.common.utils.Query;
import com.kotall.rms.core.manager.sys.SysConfigManager;
import com.kotall.rms.core.manager.sys.SysConfigRedis;
import com.kotall.rms.core.service.BaseServiceImpl;
import com.kotall.rms.core.service.sys.SysConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 系统配置信息表
 *
 * @author kotall
 * @date 2018年11月12日 下午9:18:45
 * @since 1.0.0
 */
@Service("sysConfigService")
public class SysConfigServiceImpl extends BaseServiceImpl<SysConfigManager, SysConfigEntity> implements SysConfigService {

	@Autowired
	private SysConfigRedis sysConfigRedis;

	@Autowired
	private SysConfigManager sysConfigManager;

	@Override
	public String getValue(String key) {
		SysConfigEntity config = sysConfigRedis.get(key);
		if(config == null){
			config = sysConfigManager.queryByKey(key);
			sysConfigRedis.saveOrUpdate(config);
		}
		return config == null ? null : config.getParamValue();
	}

	@Override
	public List<SysConfigEntity> queryAll(Map<String, Object> params) {
		Query query = new Query(params);
		return this.sysConfigManager.queryAll(query);
	}
}
