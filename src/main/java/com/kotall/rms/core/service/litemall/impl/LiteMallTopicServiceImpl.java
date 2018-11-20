package com.kotall.rms.core.service.litemall.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kotall.rms.core.annotation.StoreFilter;
import org.apache.shiro.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kotall.rms.common.utils.Query;
import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.entity.litemall.LiteMallTopicEntity;
import com.kotall.rms.core.manager.litemall.LiteMallTopicManager;
import com.kotall.rms.core.service.litemall.LiteMallTopicService;

/**
 * 专题表
 *
 * @author kotall
 * @date 2018年11月13日 下午6:17:39
 * @since 1.0.0
 */
@Service("liteMallTopicService")
public class LiteMallTopicServiceImpl implements LiteMallTopicService {

	@Autowired
	private LiteMallTopicManager liteMallTopicManager;

	@StoreFilter
	@Override
	public Page<LiteMallTopicEntity> listLiteMallTopic(Map<String, Object> params) {
		Query query = new Query(params);
		Page<LiteMallTopicEntity> page = new Page<>(query);
		liteMallTopicManager.listLiteMallTopic(page, query);
		return page;
	}

	@Override
	public Page<LiteMallTopicEntity> queryListByPage(Map<String, Object> params) {
		Query query = new Query(params);
		Page<LiteMallTopicEntity> page = new Page<>(query);
		liteMallTopicManager.listLiteMallTopic(page, query);
		return page;
	}

	@Override
	public List<LiteMallTopicEntity> queryTopicList(Map<String, Object> params) {
		params.put("deleted", 0);
		Query query = new Query(params);
		Page<LiteMallTopicEntity> page = new Page<>(query);
		liteMallTopicManager.listLiteMallTopic(page, query);
		return page.getRows();
	}

	@Override
	public int saveLiteMallTopic(LiteMallTopicEntity role) {
		int count = liteMallTopicManager.saveLiteMallTopic(role);
		return count;
	}

	@Override
	public LiteMallTopicEntity getLiteMallTopicById(Long id) {
		LiteMallTopicEntity liteMallTopic = liteMallTopicManager.getLiteMallTopicById(id);
		return liteMallTopic;
	}

	@Override
	public int updateLiteMallTopic(LiteMallTopicEntity liteMallTopic) {
		int count = liteMallTopicManager.updateLiteMallTopic(liteMallTopic);
		return count;
	}

	@Override
	public int batchRemove(Long[] id) {
		int count = liteMallTopicManager.batchRemove(id);
		return count;
	}

	@Override
	public List<LiteMallTopicEntity> queryRelatedList(Map<String, Object> params) {
		List<LiteMallTopicEntity> list = this.queryTopicList(params);
		Integer pageNumber = (Integer)params.get("pageNumber");
		Integer pageSize = (Integer)params.get("pageSize");
		if (list.size() == 0) {
           params = new HashMap<>();
           params.put("pageNumber", pageNumber);
           params.put("pageSize", pageSize);
           return this.queryTopicList(params);
		}

		LiteMallTopicEntity topic = list.get(0);
		params = new HashMap<>();
		params.put("deleted", 0);
		params.put("idNotEqual", topic.getId());
		list = this.queryTopicList(params);
		if (!CollectionUtils.isEmpty(list)) {
			return list;
		}

		params = new HashMap<>();
		params.put("pageNumber", pageNumber);
		params.put("pageSize", pageSize);
		return this.queryTopicList(params);
	}
}
