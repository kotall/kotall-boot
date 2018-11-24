package com.kotall.rms.core.manager.litemall;

import com.kotall.rms.common.entity.litemall.LiteMallAppEntity;
import com.kotall.rms.core.manager.BaseManager;

/**
 * app配置表
 *
 * @author kotall
 * @date 2018年11月19日 上午10:17:16
 * @since 1.0.0
 */
public interface LiteMallAppManager extends BaseManager<LiteMallAppEntity> {

    LiteMallAppEntity getByAppId(String appId);
}
