package com.kotall.rms.core.service.litemall.impl;

import com.kotall.rms.common.entity.litemall.LiteMallCategoryEntity;
import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Query;
import com.kotall.rms.core.manager.litemall.LiteMallCategoryManager;
import com.kotall.rms.core.service.BaseServiceImpl;
import com.kotall.rms.core.service.litemall.LiteMallCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 类目表
 *
 * @author kotall
 * @date 2018年11月13日 下午4:12:36
 * @since 1.0.0
 */
@Service("liteMallCategoryService")
public class LiteMallCategoryServiceImpl extends BaseServiceImpl<LiteMallCategoryManager, LiteMallCategoryEntity> implements LiteMallCategoryService {

	@Autowired
	private LiteMallCategoryManager liteMallCategoryManager;

	@Override
	public List<LiteMallCategoryEntity> queryL2ByIds(Map<String, Object> params) {
		return this.queryByList(params);
	}

	@Override
	public List<LiteMallCategoryEntity> getParentCategory(Map<String, Object> params) {
		return liteMallCategoryManager.getParentCategory(params);
	}

	@Override
	public List<LiteMallCategoryEntity> queryChannel(Map<String, Object> params) {
		params.put("level", "L1");
		params.put("deleted", 0);
		Query query = new Query(params);
		return this.liteMallCategoryManager.queryByList(query);
	}

	@Override
	public List<LiteMallCategoryEntity> queryL1WithoutRecommend(Map<String, Object> params) {
		params.put("level", "L1");
		params.put("deleted", 0);
		// params.put("name", "推荐");
		Query query = new Query(params);
		Page<LiteMallCategoryEntity> page = new Page<>(query);
		this.liteMallCategoryManager.queryByPage(page, query);
		return page.getRows();
	}
	public List<LiteMallCategoryEntity> getSecondCategory() {
		return liteMallCategoryManager.getSecondCategory();
	}

	@Override
	public List<LiteMallCategoryEntity> queryByPid(Integer pid) {
		return this.liteMallCategoryManager.queryByPid(pid);
	}

	@Override
	public List<LiteMallCategoryEntity> queryL1(Integer storeId) {
		Map<String, Object> params = new HashMap<>();
		params.put("storeId", storeId);
		params.put("level", "L1");
		params.put("deleted", 0);

		Query query = new Query(params);
		return this.liteMallCategoryManager.queryByList(query);
	}
}
