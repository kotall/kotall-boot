package com.kotall.rms.core.manager.litemall;

import java.util.List;

import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Query;
import com.kotall.rms.common.entity.litemall.LiteMallGrouponRulesEntity;

/**
 * 
 *
 * @author kotall
 * @date 2018年11月13日 下午6:25:19
 * @since 1.0.0
 */
public interface LiteMallGrouponRulesManager {

	List<LiteMallGrouponRulesEntity> listLiteMallGrouponRules(Page<LiteMallGrouponRulesEntity> page, Query search);
	
	int saveLiteMallGrouponRules(LiteMallGrouponRulesEntity liteMallGrouponRules);
	
	LiteMallGrouponRulesEntity getLiteMallGrouponRulesById(Long id);
	
	int updateLiteMallGrouponRules(LiteMallGrouponRulesEntity liteMallGrouponRules);
	
	int batchRemove(Long[] id);

    List<LiteMallGrouponRulesEntity> queryGrouponRules(Query query);
}
