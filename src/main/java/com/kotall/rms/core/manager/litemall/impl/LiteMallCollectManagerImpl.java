package com.kotall.rms.core.manager.litemall.impl;

import com.kotall.rms.common.dao.litemall.LiteMallCollectMapper;
import com.kotall.rms.common.entity.litemall.LiteMallCollectEntity;
import com.kotall.rms.common.utils.Query;
import com.kotall.rms.core.manager.BaseManagerImpl;
import com.kotall.rms.core.manager.litemall.LiteMallCollectManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 收藏表
 *
 * @author kotall
 * @date 2018年11月13日 上午11:41:28
 * @since 1.0.0
 */
@Component("liteMallCollectManager")
public class LiteMallCollectManagerImpl extends BaseManagerImpl<LiteMallCollectMapper, LiteMallCollectEntity> implements LiteMallCollectManager {

	@Autowired
	private LiteMallCollectMapper liteMallCollectMapper;
	
	@Override
	public int countUserCollect(Query query) {
		return this.liteMallCollectMapper.countTotal(query);
	}
}
