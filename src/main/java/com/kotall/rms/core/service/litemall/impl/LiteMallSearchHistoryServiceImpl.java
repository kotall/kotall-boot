package com.kotall.rms.core.service.litemall.impl;

import com.kotall.rms.common.entity.litemall.LiteMallSearchHistoryEntity;
import com.kotall.rms.common.utils.Page;
import com.kotall.rms.core.annotation.StoreFilter;
import com.kotall.rms.core.manager.litemall.LiteMallSearchHistoryManager;
import com.kotall.rms.core.service.BaseServiceImpl;
import com.kotall.rms.core.service.litemall.LiteMallSearchHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 搜索历史表
 *
 * @author kotall
 * @date 2018年11月13日 下午2:19:50
 * @since 1.0.0
 */
@Service("liteMallSearchHistoryService")
public class LiteMallSearchHistoryServiceImpl extends BaseServiceImpl<LiteMallSearchHistoryManager, LiteMallSearchHistoryEntity> implements LiteMallSearchHistoryService {

	@Autowired
	private LiteMallSearchHistoryManager liteMallSearchHistoryManager;

	@StoreFilter
	@Override
	public Page<LiteMallSearchHistoryEntity> querySearchHistoryByPage(Map<String, Object> params) {
		return super.queryByPage(params);
	}

	@Override
	public void deleteByUserId(Integer userId) {
		this.liteMallSearchHistoryManager.deleteByUserId(userId);
	}

	@Override
	public List<LiteMallSearchHistoryEntity> queryByUserId(Integer userId) {
		Map<String, Object> params = new HashMap<>();
		params.put("userId", userId);
		params.put("deleted", 0);
		return this.queryByList(params);
	}
}
