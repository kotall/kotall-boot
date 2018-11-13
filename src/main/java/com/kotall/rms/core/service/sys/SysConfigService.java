package com.kotall.rms.core.service.sys;

import com.kotall.rms.common.cloud.CloudStorageConfig;
import com.kotall.rms.common.entity.sys.SysConfigEntity;
import com.kotall.rms.common.utils.Page;

import java.util.Map;

/**
 * 系统配置信息表
 *
 * @author kotall
 * @date 2018年11月12日 下午9:18:45
 * @since 1.0.0
 */
public interface SysConfigService {

	Page<SysConfigEntity> listSysConfig(Map<String, Object> params);

    int saveSysConfig(SysConfigEntity sysConfig);

    SysConfigEntity getSysConfigById(Long id);

    int updateSysConfig(SysConfigEntity sysConfig);

    int batchRemove(Long[] id);

    /**
     * 根据key，获取配置的value值
     *
     * @param key           key
     */
    String getValue(String key);

    CloudStorageConfig getConfigObject(String cloudStorageConfigKey, Class<CloudStorageConfig> cloudStorageConfigClass);

}
