package com.kotall.rms.core.service.litemall;

import java.util.Map;

import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Result;
import com.kotall.rms.common.entity.litemall.LiteMallSearchHistoryEntity;

/**
 * 搜索历史表
 *
 * @author kotall
 * @date 2018年11月13日 下午2:19:50
 * @since 1.0.0
 */
public interface LiteMallSearchHistoryService {

	Page<LiteMallSearchHistoryEntity> listLiteMallSearchHistory(Map<String, Object> params);

    int saveLiteMallSearchHistory(LiteMallSearchHistoryEntity liteMallSearchHistory);

    LiteMallSearchHistoryEntity getLiteMallSearchHistoryById(Long id);

    int updateLiteMallSearchHistory(LiteMallSearchHistoryEntity liteMallSearchHistory);

    int batchRemove(Long[] id);
	
}
