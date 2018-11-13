package com.kotall.rms.core.service.sys.impl;

import com.kotall.rms.common.cloud.CloudStorageConfig;
import com.kotall.rms.common.entity.sys.SysConfigEntity;
import com.kotall.rms.common.manager.sys.SysConfigManager;
import com.kotall.rms.common.manager.sys.SysConfigRedis;
import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Query;
import com.kotall.rms.core.service.sys.SysConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 系统配置信息表
 *
 * @author kotall
 * @date 2018年11月12日 下午9:18:45
 * @since 1.0.0
 */
@Service("sysConfigService")
public class SysConfigServiceImpl implements SysConfigService {

	@Autowired
	private SysConfigRedis sysConfigRedis;

	@Autowired
	private SysConfigManager sysConfigManager;

	@Override
	public Page<SysConfigEntity> listSysConfig(Map<String, Object> params) {
		Query query = new Query(params);
		Page<SysConfigEntity> page = new Page<>(query);
		sysConfigManager.listSysConfig(page, query);
		return page;
	}

	@Override
	public int saveSysConfig(SysConfigEntity role) {
		int count = sysConfigManager.saveSysConfig(role);
		return count;
	}

	@Override
	public SysConfigEntity getSysConfigById(Long id) {
		SysConfigEntity sysConfig = sysConfigManager.getSysConfigById(id);
		return sysConfig;
	}

	@Override
	public int updateSysConfig(SysConfigEntity sysConfig) {
		int count = sysConfigManager.updateSysConfig(sysConfig);
		return count;
	}

	@Override
	public int batchRemove(Long[] id) {
		int count = sysConfigManager.batchRemove(id);
		return count;
	}


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
	public CloudStorageConfig getConfigObject(String cloudStorageConfigKey, Class<CloudStorageConfig> cloudStorageConfigClass) {
		return null;
	}
}
