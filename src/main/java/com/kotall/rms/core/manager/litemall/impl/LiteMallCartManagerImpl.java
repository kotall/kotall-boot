package com.kotall.rms.core.manager.litemall.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Query;
import com.kotall.rms.common.dao.litemall.LiteMallCartMapper;
import com.kotall.rms.common.entity.litemall.LiteMallCartEntity;
import com.kotall.rms.core.manager.litemall.LiteMallCartManager;

/**
 * 购物车商品表
 *
 * @author kotall
 * @date 2018年11月20日 下午12:39:39
 * @since 1.0.0
 */
@Component("liteMallCartManager")
public class LiteMallCartManagerImpl implements LiteMallCartManager {

	@Autowired
	private LiteMallCartMapper liteMallCartMapper;
	

	@Override
	public List<LiteMallCartEntity> listLiteMallCart(Page<LiteMallCartEntity> page, Query search) {
		return liteMallCartMapper.listForPage(page, search);
	}

	@Override
	public List<LiteMallCartEntity> queryCartList(Query query) {
		return liteMallCartMapper.list(query);
	}

	@Override
	public int saveLiteMallCart(LiteMallCartEntity liteMallCart) {
		return liteMallCartMapper.save(liteMallCart);
	}

	@Override
	public LiteMallCartEntity getLiteMallCartById(Long id) {
		LiteMallCartEntity liteMallCart = liteMallCartMapper.getObjectById(id);
		return liteMallCart;
	}

	@Override
	public int updateLiteMallCart(LiteMallCartEntity liteMallCart) {
		return liteMallCartMapper.update(liteMallCart);
	}

	@Override
	public int batchRemove(Long[] id) {
		int count = liteMallCartMapper.batchRemove(id);
		return count;
	}

	@Override
	public void updateCartByCause(LiteMallCartEntity cart, Query query) {
		this.liteMallCartMapper.updateCart(cart, query);
	}

	@Override
	public void deleteCartByCause(Query query) {
		this.liteMallCartMapper.deleteCartByCause(query);
	}
}
