package com.kotall.rms.core.service.litemall.impl;

import com.kotall.rms.common.entity.litemall.LiteMallTopicEntity;
import com.kotall.rms.common.utils.Page;
import com.kotall.rms.core.annotation.StoreFilter;
import com.kotall.rms.core.manager.litemall.LiteMallTopicManager;
import com.kotall.rms.core.service.BaseServiceImpl;
import com.kotall.rms.core.service.litemall.LiteMallTopicService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 专题表
 *
 * @author kotall
 * @date 2018年11月13日 下午6:17:39
 * @since 1.0.0
 */
@Service("liteMallTopicService")
public class LiteMallTopicServiceImpl extends BaseServiceImpl<LiteMallTopicManager, LiteMallTopicEntity> implements LiteMallTopicService {

	@Autowired
	private LiteMallTopicManager liteMallTopicManager;

	@StoreFilter
	@Override
	public Page<LiteMallTopicEntity> queryTopicByPage(Map<String, Object> params) {
		return super.queryByPage(params);
	}

	@Override
	public List<LiteMallTopicEntity> queryByList(Map<String, Object> params) {
		params.put("deleted", false);
		return super.queryByList(params);
	}

	@Override
	public List<LiteMallTopicEntity> queryRelatedTopicList(Integer topicId) {
		List<LiteMallTopicEntity> relatedTopicList;

		Map<String, Object> params = new HashMap<>();
		int pageNumber = 1, pageSize = 4;
		LiteMallTopicEntity mainTopic = this.getById(topicId);
		if (null != mainTopic && !mainTopic.getDeleted()) {
			params = new HashMap<>();
			params.put("deleted", false);
			params.put("idNotEqual", mainTopic.getId());
			params.put("pageNumber", pageNumber);
			params.put("pageSize", pageSize);
			relatedTopicList = super.queryByPage(params).getRows();
		}
		else {
			params.put("pageNumber", pageNumber);
			params.put("pageSize", pageSize);
			params.put("deleted", false);
			relatedTopicList = super.queryByPage(params).getRows();
		}
		return relatedTopicList;
	}
}
