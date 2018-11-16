package com.kotall.rms.core.service.litemall.impl;

import java.util.Map;

import com.kotall.rms.core.annotation.StoreFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kotall.rms.common.utils.Query;
import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.entity.litemall.LiteMallSearchHistoryEntity;
import com.kotall.rms.core.manager.litemall.LiteMallSearchHistoryManager;
import com.kotall.rms.core.service.litemall.LiteMallSearchHistoryService;

/**
 * 搜索历史表
 *
 * @author kotall
 * @date 2018年11月13日 下午2:19:50
 * @since 1.0.0
 */
@Service("liteMallSearchHistoryService")
public class LiteMallSearchHistoryServiceImpl implements LiteMallSearchHistoryService {

	@Autowired
	private LiteMallSearchHistoryManager liteMallSearchHistoryManager;

	@StoreFilter
	@Override
	public Page<LiteMallSearchHistoryEntity> listLiteMallSearchHistory(Map<String, Object> params) {
		Query query = new Query(params);
		Page<LiteMallSearchHistoryEntity> page = new Page<>(query);
		liteMallSearchHistoryManager.listLiteMallSearchHistory(page, query);
		return page;
	}

	@Override
	public int saveLiteMallSearchHistory(LiteMallSearchHistoryEntity role) {
		int count = liteMallSearchHistoryManager.saveLiteMallSearchHistory(role);
		return count;
	}

	@Override
	public LiteMallSearchHistoryEntity getLiteMallSearchHistoryById(Long id) {
		LiteMallSearchHistoryEntity liteMallSearchHistory = liteMallSearchHistoryManager.getLiteMallSearchHistoryById(id);
		return liteMallSearchHistory;
	}

	@Override
	public int updateLiteMallSearchHistory(LiteMallSearchHistoryEntity liteMallSearchHistory) {
		int count = liteMallSearchHistoryManager.updateLiteMallSearchHistory(liteMallSearchHistory);
		return count;
	}

	@Override
	public int batchRemove(Long[] id) {
		int count = liteMallSearchHistoryManager.batchRemove(id);
		return count;
	}

}
