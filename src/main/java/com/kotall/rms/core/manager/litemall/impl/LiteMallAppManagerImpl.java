package com.kotall.rms.core.manager.litemall.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Query;
import com.kotall.rms.common.dao.litemall.LiteMallAppMapper;
import com.kotall.rms.common.entity.litemall.LiteMallAppEntity;
import com.kotall.rms.core.manager.litemall.LiteMallAppManager;

/**
 * app配置表
 *
 * @author kotall
 * @date 2018年11月19日 上午10:17:16
 * @since 1.0.0
 */
@Component("liteMallAppManager")
public class LiteMallAppManagerImpl implements LiteMallAppManager {

	@Autowired
	private LiteMallAppMapper liteMallAppMapper;
	

	@Override
	public List<LiteMallAppEntity> listLiteMallApp(Page<LiteMallAppEntity> page, Query search) {
		return liteMallAppMapper.listForPage(page, search);
	}

	@Override
	public int saveLiteMallApp(LiteMallAppEntity liteMallApp) {
		return liteMallAppMapper.save(liteMallApp);
	}

	@Override
	public LiteMallAppEntity getLiteMallAppById(Long id) {
		LiteMallAppEntity liteMallApp = liteMallAppMapper.getObjectById(id);
		return liteMallApp;
	}

	@Override
	public int updateLiteMallApp(LiteMallAppEntity liteMallApp) {
		return liteMallAppMapper.update(liteMallApp);
	}

	@Override
	public int batchRemove(Long[] id) {
		int count = liteMallAppMapper.batchRemove(id);
		return count;
	}
	
}
