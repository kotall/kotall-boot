package com.kotall.rms.core.manager.litemall.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Query;
import com.kotall.rms.common.dao.litemall.LiteMallSearchHistoryMapper;
import com.kotall.rms.common.entity.litemall.LiteMallSearchHistoryEntity;
import com.kotall.rms.core.manager.litemall.LiteMallSearchHistoryManager;

/**
 * 搜索历史表
 *
 * @author kotall
 * @date 2018年11月13日 下午2:19:50
 * @since 1.0.0
 */
@Component("liteMallSearchHistoryManager")
public class LiteMallSearchHistoryManagerImpl implements LiteMallSearchHistoryManager {

	@Autowired
	private LiteMallSearchHistoryMapper liteMallSearchHistoryMapper;
	

	@Override
	public List<LiteMallSearchHistoryEntity> listLiteMallSearchHistory(Page<LiteMallSearchHistoryEntity> page, Query search) {
		return liteMallSearchHistoryMapper.listForPage(page, search);
	}

	@Override
	public List<LiteMallSearchHistoryEntity> querySearchHistoryList(Query query) {
		return liteMallSearchHistoryMapper.list(query);
	}

	@Override
	public int saveLiteMallSearchHistory(LiteMallSearchHistoryEntity liteMallSearchHistory) {
		return liteMallSearchHistoryMapper.save(liteMallSearchHistory);
	}

	@Override
	public LiteMallSearchHistoryEntity getLiteMallSearchHistoryById(Long id) {
		LiteMallSearchHistoryEntity liteMallSearchHistory = liteMallSearchHistoryMapper.getObjectById(id);
		return liteMallSearchHistory;
	}

	@Override
	public int updateLiteMallSearchHistory(LiteMallSearchHistoryEntity liteMallSearchHistory) {
		return liteMallSearchHistoryMapper.update(liteMallSearchHistory);
	}

	@Override
	public int batchRemove(Long[] id) {
		int count = liteMallSearchHistoryMapper.batchRemove(id);
		return count;
	}

	@Override
	public void deleteByUserId(Integer userId) {
		this.liteMallSearchHistoryMapper.deleteByUserId(userId);
	}
}
