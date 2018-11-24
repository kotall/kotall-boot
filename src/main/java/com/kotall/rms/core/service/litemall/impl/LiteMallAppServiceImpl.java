package com.kotall.rms.core.service.litemall.impl;

import com.kotall.rms.common.entity.litemall.LiteMallAppEntity;
import com.kotall.rms.core.manager.litemall.LiteMallAppManager;
import com.kotall.rms.core.service.BaseServiceImpl;
import com.kotall.rms.core.service.litemall.LiteMallAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * app配置表
 *
 * @author kotall
 * @date 2018年11月19日 上午10:17:16
 * @since 1.0.0
 */
@Service("liteMallAppService")
public class LiteMallAppServiceImpl extends BaseServiceImpl<LiteMallAppManager, LiteMallAppEntity> implements LiteMallAppService {

	@Autowired
	private LiteMallAppManager liteMallAppManager;


	@Override
	public LiteMallAppEntity getByAppId(String appId) {
		LiteMallAppEntity liteMallApp = liteMallAppManager.getByAppId(appId);
		return liteMallApp;
	}
}
