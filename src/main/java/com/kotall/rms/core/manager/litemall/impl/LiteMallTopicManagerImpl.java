package com.kotall.rms.core.manager.litemall.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Query;
import com.kotall.rms.common.dao.litemall.LiteMallTopicMapper;
import com.kotall.rms.common.entity.litemall.LiteMallTopicEntity;
import com.kotall.rms.core.manager.litemall.LiteMallTopicManager;

/**
 * 专题表
 *
 * @author kotall
 * @date 2018年11月13日 下午6:17:39
 * @since 1.0.0
 */
@Component("liteMallTopicManager")
public class LiteMallTopicManagerImpl implements LiteMallTopicManager {

	@Autowired
	private LiteMallTopicMapper liteMallTopicMapper;
	

	@Override
	public List<LiteMallTopicEntity> listLiteMallTopic(Page<LiteMallTopicEntity> page, Query search) {
		return liteMallTopicMapper.listForPage(page, search);
	}

	@Override
	public int saveLiteMallTopic(LiteMallTopicEntity liteMallTopic) {
		return liteMallTopicMapper.save(liteMallTopic);
	}

	@Override
	public LiteMallTopicEntity getLiteMallTopicById(Long id) {
		LiteMallTopicEntity liteMallTopic = liteMallTopicMapper.getObjectById(id);
		return liteMallTopic;
	}

	@Override
	public int updateLiteMallTopic(LiteMallTopicEntity liteMallTopic) {
		return liteMallTopicMapper.update(liteMallTopic);
	}

	@Override
	public int batchRemove(Long[] id) {
		int count = liteMallTopicMapper.batchRemove(id);
		return count;
	}
	
}
