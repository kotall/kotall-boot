package com.kotall.rms.core.manager.litemall;

import java.util.List;

import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Query;
import com.kotall.rms.common.entity.litemall.LiteMallCollectEntity;

/**
 * 收藏表
 *
 * @author kotall
 * @date 2018年11月13日 上午11:41:28
 * @since 1.0.0
 */
public interface LiteMallCollectManager {

	List<LiteMallCollectEntity> listLiteMallCollect(Page<LiteMallCollectEntity> page, Query search);
	
	int saveLiteMallCollect(LiteMallCollectEntity liteMallCollect);
	
	LiteMallCollectEntity getLiteMallCollectById(Long id);
	
	int updateLiteMallCollect(LiteMallCollectEntity liteMallCollect);
	
	int batchRemove(Long[] id);
	
}
