package com.kotall.rms.core.service.litemall.impl;

import java.util.List;
import java.util.Map;

import com.kotall.rms.common.entity.litemall.LiteMallAdEntity;
import com.kotall.rms.core.annotation.StoreFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kotall.rms.common.utils.Query;
import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.entity.litemall.LiteMallCategoryEntity;
import com.kotall.rms.core.manager.litemall.LiteMallCategoryManager;
import com.kotall.rms.core.service.litemall.LiteMallCategoryService;

/**
 * 类目表
 *
 * @author kotall
 * @date 2018年11月13日 下午4:12:36
 * @since 1.0.0
 */
@Service("liteMallCategoryService")
public class LiteMallCategoryServiceImpl implements LiteMallCategoryService {

	@Autowired
	private LiteMallCategoryManager liteMallCategoryManager;

	@StoreFilter
	@Override
	public Page<LiteMallCategoryEntity> listLiteMallCategory(Map<String, Object> params) {
		Query query = new Query(params);
		Page<LiteMallCategoryEntity> page = new Page<>(query);
		liteMallCategoryManager.listLiteMallCategory(page, query);
		return page;
	}

	@Override
	public int saveLiteMallCategory(LiteMallCategoryEntity role) {
		int count = liteMallCategoryManager.saveLiteMallCategory(role);
		return count;
	}

	@Override
	public LiteMallCategoryEntity getLiteMallCategoryById(Long id) {
		LiteMallCategoryEntity liteMallCategory = liteMallCategoryManager.getLiteMallCategoryById(id);
		return liteMallCategory;
	}

	@Override
	public int updateLiteMallCategory(LiteMallCategoryEntity liteMallCategory) {
		int count = liteMallCategoryManager.updateLiteMallCategory(liteMallCategory);
		return count;
	}

	@Override
	public int batchRemove(Long[] id) {
		int count = liteMallCategoryManager.batchRemove(id);
		return count;
	}

	@Override
	public List<LiteMallCategoryEntity> queryChannel(Map<String, Object> params) {
		params.put("level", "L1");
		params.put("deleted", 0);
		Query query = new Query(params);
		return this.liteMallCategoryManager.queryChannel(query);
	}
}
