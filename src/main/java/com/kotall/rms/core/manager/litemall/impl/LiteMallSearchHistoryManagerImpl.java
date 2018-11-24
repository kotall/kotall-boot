package com.kotall.rms.core.manager.litemall.impl;

import com.kotall.rms.common.dao.litemall.LiteMallSearchHistoryMapper;
import com.kotall.rms.common.entity.litemall.LiteMallSearchHistoryEntity;
import com.kotall.rms.core.manager.BaseManagerImpl;
import com.kotall.rms.core.manager.litemall.LiteMallSearchHistoryManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 搜索历史表
 *
 * @author kotall
 * @date 2018年11月13日 下午2:19:50
 * @since 1.0.0
 */
@Component("liteMallSearchHistoryManager")
public class LiteMallSearchHistoryManagerImpl extends BaseManagerImpl<LiteMallSearchHistoryMapper, LiteMallSearchHistoryEntity> implements LiteMallSearchHistoryManager{

	@Autowired
	private LiteMallSearchHistoryMapper liteMallSearchHistoryMapper;
	
	@Override
	public void deleteByUserId(Integer userId) {
		this.liteMallSearchHistoryMapper.deleteByUserId(userId);
	}
}
