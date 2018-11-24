package com.kotall.rms.core.manager.litemall.impl;

import com.kotall.rms.common.dao.litemall.LiteMallAppMapper;
import com.kotall.rms.common.entity.litemall.LiteMallAppEntity;
import com.kotall.rms.core.manager.BaseManagerImpl;
import com.kotall.rms.core.manager.litemall.LiteMallAppManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * app配置表
 *
 * @author kotall
 * @date 2018年11月19日 上午10:17:16
 * @since 1.0.0
 */
@Component("liteMallAppManager")
public class LiteMallAppManagerImpl extends BaseManagerImpl<LiteMallAppMapper, LiteMallAppEntity> implements LiteMallAppManager {

	@Autowired
	private LiteMallAppMapper liteMallAppMapper;
	
	@Override
	public LiteMallAppEntity getByAppId(String appId) {
		return this.liteMallAppMapper.getObjectByAppId(appId);
	}
}
