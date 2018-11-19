package com.kotall.rms.core.service.litemall.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kotall.rms.core.annotation.StoreFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kotall.rms.common.utils.Query;
import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.entity.litemall.LiteMallAdEntity;
import com.kotall.rms.core.manager.litemall.LiteMallAdManager;
import com.kotall.rms.core.service.litemall.LiteMallAdService;

/**
 * 广告表
 *
 * @author kotall
 * @date 2018年11月13日 下午6:08:21
 * @since 1.0.0
 */
@Service("liteMallAdService")
public class LiteMallAdServiceImpl implements LiteMallAdService {

	@Autowired
	private LiteMallAdManager liteMallAdManager;

	@StoreFilter
	@Override
	public Page<LiteMallAdEntity> listLiteMallAd(Map<String, Object> params) {
		Query query = new Query(params);
		Page<LiteMallAdEntity> page = new Page<>(query);
		liteMallAdManager.listLiteMallAd(page, query);
		return page;
	}

	@Override
	public int saveLiteMallAd(LiteMallAdEntity role) {
		int count = liteMallAdManager.saveLiteMallAd(role);
		return count;
	}

	@Override
	public LiteMallAdEntity getLiteMallAdById(Long id) {
		LiteMallAdEntity liteMallAd = liteMallAdManager.getLiteMallAdById(id);
		return liteMallAd;
	}

	@Override
	public int updateLiteMallAd(LiteMallAdEntity liteMallAd) {
		int count = liteMallAdManager.updateLiteMallAd(liteMallAd);
		return count;
	}

	@Override
	public int batchRemove(Long[] id) {
		int count = liteMallAdManager.batchRemove(id);
		return count;
	}

	@Override
	public List<LiteMallAdEntity> queryIndex(Map<String, Object> params) {
		params.put("position", 1);
		params.put("deleted", 0);
		params.put("enabled", 1);
		Query query = new Query(params);
		return this.liteMallAdManager.queryAdList(query);
	}
}
