package com.kotall.rms.core.manager.litemall.impl;

import com.kotall.rms.common.dao.litemall.LiteMallCartMapper;
import com.kotall.rms.common.entity.litemall.LiteMallCartEntity;
import com.kotall.rms.common.utils.Query;
import com.kotall.rms.core.manager.BaseManagerImpl;
import com.kotall.rms.core.manager.litemall.LiteMallCartManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 购物车商品表
 *
 * @author kotall
 * @date 2018年11月20日 下午12:39:39
 * @since 1.0.0
 */
@Component("liteMallCartManager")
public class LiteMallCartManagerImpl extends BaseManagerImpl<LiteMallCartMapper, LiteMallCartEntity> implements LiteMallCartManager {

	@Autowired
	private LiteMallCartMapper liteMallCartMapper;
	
	@Override
	public void updateCartByCause(LiteMallCartEntity cart, Query query) {
		this.liteMallCartMapper.updateCart(cart, query);
	}

	@Override
	public void deleteCartByCause(Query query) {
		this.liteMallCartMapper.deleteCartByCause(query);
	}
}
