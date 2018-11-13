package com.kotall.rms.core.manager.litemall;

import java.util.List;

import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Query;
import com.kotall.rms.common.entity.litemall.LiteMallKeywordEntity;

/**
 * 关键字表
 *
 * @author kotall
 * @date 2018年11月13日 下午4:34:40
 * @since 1.0.0
 */
public interface LiteMallKeywordManager {

	List<LiteMallKeywordEntity> listLiteMallKeyword(Page<LiteMallKeywordEntity> page, Query search);
	
	int saveLiteMallKeyword(LiteMallKeywordEntity liteMallKeyword);
	
	LiteMallKeywordEntity getLiteMallKeywordById(Long id);
	
	int updateLiteMallKeyword(LiteMallKeywordEntity liteMallKeyword);
	
	int batchRemove(Long[] id);
	
}
