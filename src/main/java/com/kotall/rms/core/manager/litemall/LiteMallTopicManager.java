package com.kotall.rms.core.manager.litemall;

import java.util.List;

import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Query;
import com.kotall.rms.common.entity.litemall.LiteMallTopicEntity;

/**
 * 专题表
 *
 * @author kotall
 * @date 2018年11月13日 下午6:17:39
 * @since 1.0.0
 */
public interface LiteMallTopicManager {

	List<LiteMallTopicEntity> listLiteMallTopic(Page<LiteMallTopicEntity> page, Query search);
	
	int saveLiteMallTopic(LiteMallTopicEntity liteMallTopic);
	
	LiteMallTopicEntity getLiteMallTopicById(Long id);
	
	int updateLiteMallTopic(LiteMallTopicEntity liteMallTopic);
	
	int batchRemove(Long[] id);
	
}
