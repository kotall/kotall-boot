package com.kotall.rms.core.manager.litemall.impl;

import com.kotall.rms.common.dao.litemall.LiteMallOrderMapper;
import com.kotall.rms.common.entity.litemall.LiteMallOrderEntity;
import com.kotall.rms.common.utils.Query;
import com.kotall.rms.core.manager.BaseManagerImpl;
import com.kotall.rms.core.manager.litemall.LiteMallOrderManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 订单表
 *
 * @author kotall
 * @date 2018年11月13日 下午4:22:38
 * @since 1.0.0
 */
@Component("liteMallOrderManager")
public class LiteMallOrderManagerImpl extends BaseManagerImpl<LiteMallOrderMapper, LiteMallOrderEntity> implements LiteMallOrderManager {

	@Autowired
	private LiteMallOrderMapper liteMallOrderMapper;
	
	@Override
	public int countTotal(Query query) {
		return this.liteMallOrderMapper.countTotal(query);
	}
}
