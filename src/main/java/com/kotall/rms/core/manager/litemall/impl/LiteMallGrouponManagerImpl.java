package com.kotall.rms.core.manager.litemall.impl;

import com.kotall.rms.common.dao.litemall.LiteMallGrouponMapper;
import com.kotall.rms.common.entity.litemall.LiteMallGrouponEntity;
import com.kotall.rms.common.utils.Query;
import com.kotall.rms.core.manager.BaseManagerImpl;
import com.kotall.rms.core.manager.litemall.LiteMallGrouponManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 
 *
 * @author kotall
 * @date 2018年11月13日 下午6:32:18
 * @since 1.0.0
 */
@Component("liteMallGrouponManager")
public class LiteMallGrouponManagerImpl extends BaseManagerImpl<LiteMallGrouponMapper, LiteMallGrouponEntity> implements LiteMallGrouponManager {

	@Autowired
	private LiteMallGrouponMapper liteMallGrouponMapper;

	@Override
	public int countGroupOn(Query query) {
		return this.liteMallGrouponMapper.countTotal(query);
	}
}
