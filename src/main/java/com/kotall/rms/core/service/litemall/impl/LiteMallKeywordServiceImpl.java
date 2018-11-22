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
import com.kotall.rms.common.entity.litemall.LiteMallKeywordEntity;
import com.kotall.rms.core.manager.litemall.LiteMallKeywordManager;
import com.kotall.rms.core.service.litemall.LiteMallKeywordService;

/**
 * 关键字表
 *
 * @author kotall
 * @date 2018年11月13日 下午4:34:40
 * @since 1.0.0
 */
@Service("liteMallKeywordService")
public class LiteMallKeywordServiceImpl implements LiteMallKeywordService {

	@Autowired
	private LiteMallKeywordManager liteMallKeywordManager;

	@StoreFilter
	@Override
	public Page<LiteMallKeywordEntity> listLiteMallKeyword(Map<String, Object> params) {
		Query query = new Query(params);
		Page<LiteMallKeywordEntity> page = new Page<>(query);
		liteMallKeywordManager.listLiteMallKeyword(page, query);
		return page;
	}

	@Override
	public List<LiteMallKeywordEntity> queryKeywordList(Map<String, Object> params) {
		Query query = new Query(params);
		return liteMallKeywordManager.queryKeywordList(query);
	}

	@Override
	public int saveLiteMallKeyword(LiteMallKeywordEntity role) {
		int count = liteMallKeywordManager.saveLiteMallKeyword(role);
		return count;
	}

	@Override
	public LiteMallKeywordEntity getLiteMallKeywordById(Long id) {
		LiteMallKeywordEntity liteMallKeyword = liteMallKeywordManager.getLiteMallKeywordById(id);
		return liteMallKeyword;
	}

	@Override
	public int updateLiteMallKeyword(LiteMallKeywordEntity liteMallKeyword) {
		int count = liteMallKeywordManager.updateLiteMallKeyword(liteMallKeyword);
		return count;
	}

	@Override
	public int batchRemove(Long[] id) {
		int count = liteMallKeywordManager.batchRemove(id);
		return count;
	}

	@Override
	public LiteMallKeywordEntity queryDefault() {
		Map<String, Object> params = new HashMap<>();
		params.put("isDefault", 1);
		params.put("deleted", 0);

		List<LiteMallKeywordEntity> list = this.queryKeywordList(params);
		return CollectionUtils.isEmpty(list) ? null : list.get(0);
	}

	@Override
	public List<LiteMallKeywordEntity> queryHots() {
		Map<String, Object> params = new HashMap<>();
		params.put("isHot", 1);
		params.put("deleted", 0);

		return this.queryKeywordList(params);
	}
}
