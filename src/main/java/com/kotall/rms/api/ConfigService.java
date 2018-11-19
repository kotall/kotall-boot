package com.kotall.rms.api;

import com.kotall.rms.common.entity.sys.SysConfigEntity;
import com.kotall.rms.core.service.sys.SysConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;

/**
 * 该类用于自动初始化数据库配置到BaseConfig中，以便BaseConfig的子类调用
 */
@Component
class ConfigService {
    private static ConfigService systemConfigService;

    static ConfigService getSystemConfigService() {
        return systemConfigService;
    }

    @Autowired
    private SysConfigService sysConfigService;

    // 不允许实例化
    private ConfigService() {
    }

    @PostConstruct
    public void inist() {
        systemConfigService = this;
        systemConfigService.initConfigs();
    }

    /**
     * 根据 prefix 重置该 prefix 下所有设置
     *
     * @param prefix
     */
    public void reloadConfig(String prefix) {
        List<SysConfigEntity> list = this.sysConfigService.queryAll(new HashMap<>());
        for (SysConfigEntity item : list) {
            //符合条件，添加
            if (item.getParamKey().startsWith(prefix))
                BaseConfig.addConfig(item.getParamKey(), item.getParamValue());
        }
    }

    /**
     * 读取全部配置
     */
    private void initConfigs() {
        List<SysConfigEntity> list = this.sysConfigService.queryAll(new HashMap<>());
        for (SysConfigEntity item : list) {
            BaseConfig.addConfig(item.getParamKey(), item.getParamValue());
        }
    }
}