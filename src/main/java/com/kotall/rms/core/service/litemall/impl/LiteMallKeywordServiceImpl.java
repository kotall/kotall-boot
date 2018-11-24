package com.kotall.rms.core.service.litemall.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kotall.rms.core.annotation.StoreFilter;
import com.kotall.rms.core.service.BaseServiceImpl;
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
public class LiteMallKeywordServiceImpl extends BaseServiceImpl<LiteMallKeywordManager, LiteMallKeywordEntity> implements LiteMallKeywordService {

	@Autowired
	private LiteMallKeywordManager liteMallKeywordManager;

	@StoreFilter
	@Override
	public Page<LiteMallKeywordEntity> queryKeywordByPage(Map<String, Object> params) {
		Query query = new Query(params);
		Page<LiteMallKeywordEntity> page = new Page<>(query);
		liteMallKeywordManager.queryByPage(page, query);
		return super.queryByPage(params);
	}

	@Override
	public LiteMallKeywordEntity queryDefault(Integer storeId) {
		Map<String, Object> params = new HashMap<>();
		params.put("storeId", storeId);
		params.put("isDefault", 1);
		params.put("deleted", 0);

		List<LiteMallKeywordEntity> list = this.queryByList(params);
		return CollectionUtils.isEmpty(list) ? null : list.get(0);
	}

	@Override
	public List<LiteMallKeywordEntity> queryHots(Integer storeId) {
		Map<String, Object> params = new HashMap<>();
		params.put("storeId", storeId);
		params.put("isHot", 1);
		params.put("deleted", 0);

		return this.queryByList(params);
	}
}
