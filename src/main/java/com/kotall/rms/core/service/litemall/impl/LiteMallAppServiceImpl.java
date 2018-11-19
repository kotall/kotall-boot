package com.kotall.rms.core.service.litemall.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kotall.rms.common.utils.Query;
import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.entity.litemall.LiteMallAppEntity;
import com.kotall.rms.core.manager.litemall.LiteMallAppManager;
import com.kotall.rms.core.service.litemall.LiteMallAppService;

/**
 * app配置表
 *
 * @author kotall
 * @date 2018年11月19日 上午10:17:16
 * @since 1.0.0
 */
@Service("liteMallAppService")
public class LiteMallAppServiceImpl implements LiteMallAppService {

	@Autowired
	private LiteMallAppManager liteMallAppManager;

	@Override
	public Page<LiteMallAppEntity> listLiteMallApp(Map<String, Object> params) {
		Query query = new Query(params);
		Page<LiteMallAppEntity> page = new Page<>(query);
		liteMallAppManager.listLiteMallApp(page, query);
		return page;
	}

	@Override
	public int saveLiteMallApp(LiteMallAppEntity role) {
		int count = liteMallAppManager.saveLiteMallApp(role);
		return count;
	}

	@Override
	public LiteMallAppEntity getLiteMallAppById(Long id) {
		LiteMallAppEntity liteMallApp = liteMallAppManager.getLiteMallAppById(id);
		return liteMallApp;
	}

	@Override
	public int updateLiteMallApp(LiteMallAppEntity liteMallApp) {
		int count = liteMallAppManager.updateLiteMallApp(liteMallApp);
		return count;
	}

	@Override
	public int batchRemove(Long[] id) {
		int count = liteMallAppManager.batchRemove(id);
		return count;
	}

	@Override
	public LiteMallAppEntity getLiteMallAppByAppId(String appId) {
		LiteMallAppEntity liteMallApp = liteMallAppManager.getLiteMallAppByAppId(appId);
		return liteMallApp;
	}
}
