package com.kotall.rms.core.manager.litemall.impl;

import com.kotall.rms.common.dao.litemall.LiteMallGrouponRulesMapper;
import com.kotall.rms.common.entity.litemall.LiteMallGrouponRulesEntity;
import com.kotall.rms.core.manager.BaseManagerImpl;
import com.kotall.rms.core.manager.litemall.LiteMallGrouponRulesManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 
 *
 * @author kotall
 * @date 2018年11月13日 下午6:25:19
 * @since 1.0.0
 */
@Component("liteMallGrouponRulesManager")
public class LiteMallGrouponRulesManagerImpl extends BaseManagerImpl<LiteMallGrouponRulesMapper, LiteMallGrouponRulesEntity> implements LiteMallGrouponRulesManager {

	@Autowired
	private LiteMallGrouponRulesMapper liteMallGrouponRulesMapper;

}
