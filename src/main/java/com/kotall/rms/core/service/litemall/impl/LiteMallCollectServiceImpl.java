package com.kotall.rms.core.service.litemall.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kotall.rms.common.utils.Query;
import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.entity.litemall.LiteMallCollectEntity;
import com.kotall.rms.core.manager.litemall.LiteMallCollectManager;
import com.kotall.rms.core.service.litemall.LiteMallCollectService;

/**
 * 收藏表
 *
 * @author kotall
 * @date 2018年11月13日 上午11:41:28
 * @since 1.0.0
 */
@Service("liteMallCollectService")
public class LiteMallCollectServiceImpl implements LiteMallCollectService {

	@Autowired
	private LiteMallCollectManager liteMallCollectManager;

	@Override
	public Page<LiteMallCollectEntity> listLiteMallCollect(Map<String, Object> params) {
		Query query = new Query(params);
		Page<LiteMallCollectEntity> page = new Page<>(query);
		liteMallCollectManager.listLiteMallCollect(page, query);
		return page;
	}

	@Override
	public int saveLiteMallCollect(LiteMallCollectEntity role) {
		int count = liteMallCollectManager.saveLiteMallCollect(role);
		return count;
	}

	@Override
	public LiteMallCollectEntity getLiteMallCollectById(Long id) {
		LiteMallCollectEntity liteMallCollect = liteMallCollectManager.getLiteMallCollectById(id);
		return liteMallCollect;
	}

	@Override
	public int updateLiteMallCollect(LiteMallCollectEntity liteMallCollect) {
		int count = liteMallCollectManager.updateLiteMallCollect(liteMallCollect);
		return count;
	}

	@Override
	public int batchRemove(Long[] id) {
		int count = liteMallCollectManager.batchRemove(id);
		return count;
	}

}
