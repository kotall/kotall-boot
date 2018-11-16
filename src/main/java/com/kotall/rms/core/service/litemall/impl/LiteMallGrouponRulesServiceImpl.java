package com.kotall.rms.core.service.litemall.impl;

import java.util.Map;

import com.kotall.rms.core.annotation.StoreFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kotall.rms.common.utils.Query;
import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.entity.litemall.LiteMallGrouponRulesEntity;
import com.kotall.rms.core.manager.litemall.LiteMallGrouponRulesManager;
import com.kotall.rms.core.service.litemall.LiteMallGrouponRulesService;

/**
 * 
 *
 * @author kotall
 * @date 2018年11月13日 下午6:25:19
 * @since 1.0.0
 */
@Service("liteMallGrouponRulesService")
public class LiteMallGrouponRulesServiceImpl implements LiteMallGrouponRulesService {

	@Autowired
	private LiteMallGrouponRulesManager liteMallGrouponRulesManager;

	@StoreFilter
	@Override
	public Page<LiteMallGrouponRulesEntity> listLiteMallGrouponRules(Map<String, Object> params) {
		Query query = new Query(params);
		Page<LiteMallGrouponRulesEntity> page = new Page<>(query);
		liteMallGrouponRulesManager.listLiteMallGrouponRules(page, query);
		return page;
	}

	@Override
	public int saveLiteMallGrouponRules(LiteMallGrouponRulesEntity role) {
		int count = liteMallGrouponRulesManager.saveLiteMallGrouponRules(role);
		return count;
	}

	@Override
	public LiteMallGrouponRulesEntity getLiteMallGrouponRulesById(Long id) {
		LiteMallGrouponRulesEntity liteMallGrouponRules = liteMallGrouponRulesManager.getLiteMallGrouponRulesById(id);
		return liteMallGrouponRules;
	}

	@Override
	public int updateLiteMallGrouponRules(LiteMallGrouponRulesEntity liteMallGrouponRules) {
		int count = liteMallGrouponRulesManager.updateLiteMallGrouponRules(liteMallGrouponRules);
		return count;
	}

	@Override
	public int batchRemove(Long[] id) {
		int count = liteMallGrouponRulesManager.batchRemove(id);
		return count;
	}

}
