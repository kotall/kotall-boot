package com.kotall.rms.core.manager.litemall.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Query;
import com.kotall.rms.common.dao.litemall.LiteMallGrouponRulesMapper;
import com.kotall.rms.common.entity.litemall.LiteMallGrouponRulesEntity;
import com.kotall.rms.core.manager.litemall.LiteMallGrouponRulesManager;

/**
 * 
 *
 * @author kotall
 * @date 2018年11月13日 下午6:25:19
 * @since 1.0.0
 */
@Component("liteMallGrouponRulesManager")
public class LiteMallGrouponRulesManagerImpl implements LiteMallGrouponRulesManager {

	@Autowired
	private LiteMallGrouponRulesMapper liteMallGrouponRulesMapper;
	

	@Override
	public List<LiteMallGrouponRulesEntity> listLiteMallGrouponRules(Page<LiteMallGrouponRulesEntity> page, Query search) {
		return liteMallGrouponRulesMapper.listForPage(page, search);
	}

	@Override
	public int saveLiteMallGrouponRules(LiteMallGrouponRulesEntity liteMallGrouponRules) {
		return liteMallGrouponRulesMapper.save(liteMallGrouponRules);
	}

	@Override
	public LiteMallGrouponRulesEntity getLiteMallGrouponRulesById(Long id) {
		LiteMallGrouponRulesEntity liteMallGrouponRules = liteMallGrouponRulesMapper.getObjectById(id);
		return liteMallGrouponRules;
	}

	@Override
	public int updateLiteMallGrouponRules(LiteMallGrouponRulesEntity liteMallGrouponRules) {
		return liteMallGrouponRulesMapper.update(liteMallGrouponRules);
	}

	@Override
	public int batchRemove(Long[] id) {
		int count = liteMallGrouponRulesMapper.batchRemove(id);
		return count;
	}
	
}
