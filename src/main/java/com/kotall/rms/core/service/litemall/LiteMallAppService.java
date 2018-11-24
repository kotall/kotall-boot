package com.kotall.rms.core.service.litemall;

import com.kotall.rms.common.entity.litemall.LiteMallAppEntity;
import com.kotall.rms.core.service.BaseService;

/**
 * app配置表
 *
 * @author kotall
 * @date 2018年11月19日 上午10:17:16
 * @since 1.0.0
 */
public interface LiteMallAppService  extends BaseService<LiteMallAppEntity> {


    /**
     * 根据appId查询
     * @param appId
     * @return
     */
    LiteMallAppEntity getByAppId(String appId);
}
