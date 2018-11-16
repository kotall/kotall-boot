package com.kotall.rms.core.service.litemall.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kotall.rms.common.utils.Query;
import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.entity.litemall.LiteMallStoreEntity;
import com.kotall.rms.core.manager.litemall.LiteMallStoreManager;
import com.kotall.rms.core.service.litemall.LiteMallStoreService;

/**
 * 店铺表 
 *
 * @author kotall
 * @date 2018年11月14日 下午6:05:16
 * @since 1.0.0
 */
@Service("liteMallStoreService")
public class LiteMallStoreServiceImpl implements LiteMallStoreService {

	@Autowired
	private LiteMallStoreManager liteMallStoreManager;

	@Override
	public Page<LiteMallStoreEntity> listLiteMallStore(Map<String, Object> params) {
		Query query = new Query(params);
		Page<LiteMallStoreEntity> page = new Page<>(query);
		liteMallStoreManager.listLiteMallStore(page, query);
		return page;
	}

	@Override
	public int saveLiteMallStore(LiteMallStoreEntity role) {
		int count = liteMallStoreManager.saveLiteMallStore(role);
		return count;
	}

	@Override
	public LiteMallStoreEntity getLiteMallStoreById(Long id) {
		LiteMallStoreEntity liteMallStore = liteMallStoreManager.getLiteMallStoreById(id);
		return liteMallStore;
	}

	@Override
	public int updateLiteMallStore(LiteMallStoreEntity liteMallStore) {
		int count = liteMallStoreManager.updateLiteMallStore(liteMallStore);
		return count;
	}

	@Override
	public int batchRemove(Long[] id) {
		int count = liteMallStoreManager.batchRemove(id);
		return count;
	}

	@Override
	public List<Integer> queryStoreIdListByUserId(Long userId) {
		return this.liteMallStoreManager.queryStoreIdListByUserId(userId);
	}
}
