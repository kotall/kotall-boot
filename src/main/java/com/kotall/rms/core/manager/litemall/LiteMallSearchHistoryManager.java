package com.kotall.rms.core.manager.litemall;

import java.util.List;

import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Query;
import com.kotall.rms.common.entity.litemall.LiteMallSearchHistoryEntity;

/**
 * 搜索历史表
 *
 * @author kotall
 * @date 2018年11月13日 下午2:19:50
 * @since 1.0.0
 */
public interface LiteMallSearchHistoryManager {

	List<LiteMallSearchHistoryEntity> listLiteMallSearchHistory(Page<LiteMallSearchHistoryEntity> page, Query search);
	
	int saveLiteMallSearchHistory(LiteMallSearchHistoryEntity liteMallSearchHistory);
	
	LiteMallSearchHistoryEntity getLiteMallSearchHistoryById(Long id);
	
	int updateLiteMallSearchHistory(LiteMallSearchHistoryEntity liteMallSearchHistory);
	
	int batchRemove(Long[] id);

    void deleteByUserId(Integer userId);

    List<LiteMallSearchHistoryEntity> querySearchHistoryList(Query query);
}
