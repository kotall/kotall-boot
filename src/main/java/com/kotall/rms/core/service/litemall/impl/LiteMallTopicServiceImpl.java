package com.kotall.rms.core.service.litemall.impl;

import com.kotall.rms.common.entity.litemall.LiteMallTopicEntity;
import com.kotall.rms.common.utils.Page;
import com.kotall.rms.core.annotation.StoreFilter;
import com.kotall.rms.core.manager.litemall.LiteMallTopicManager;
import com.kotall.rms.core.service.BaseServiceImpl;
import com.kotall.rms.core.service.litemall.LiteMallTopicService;
import org.apache.shiro.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		params.put("deleted", 0);
		return super.queryByList(params);
	}

	@Override
	public List<LiteMallTopicEntity> queryRelatedList(Map<String, Object> params) {
		List<LiteMallTopicEntity> list = this.queryByList(params);
		Integer pageNumber = (Integer)params.get("pageNumber");
		Integer pageSize = (Integer)params.get("pageSize");
		if (list.size() == 0) {
           params = new HashMap<>();
           params.put("pageNumber", pageNumber);
           params.put("pageSize", pageSize);
           return super.queryByPage(params).getRows();
		}

		LiteMallTopicEntity topic = list.get(0);
		params = new HashMap<>();
		params.put("deleted", 0);
		params.put("idNotEqual", topic.getId());
		list = this.queryByList(params);
		if (!CollectionUtils.isEmpty(list)) {
			return list;
		}

		params = new HashMap<>();
		params.put("pageNumber", pageNumber);
		params.put("pageSize", pageSize);
		return this.queryByList(params);
	}
}
