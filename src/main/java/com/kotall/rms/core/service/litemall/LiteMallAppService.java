package com.kotall.rms.core.service.litemall;

import java.util.Map;

import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Result;
import com.kotall.rms.common.entity.litemall.LiteMallAppEntity;

/**
 * app配置表
 *
 * @author kotall
 * @date 2018年11月19日 上午10:17:16
 * @since 1.0.0
 */
public interface LiteMallAppService {

	Page<LiteMallAppEntity> listLiteMallApp(Map<String, Object> params);

    int saveLiteMallApp(LiteMallAppEntity liteMallApp);

    LiteMallAppEntity getLiteMallAppById(Long id);

    int updateLiteMallApp(LiteMallAppEntity liteMallApp);

    int batchRemove(Long[] id);

    LiteMallAppEntity getLiteMallAppByAppId(String appId);
}
