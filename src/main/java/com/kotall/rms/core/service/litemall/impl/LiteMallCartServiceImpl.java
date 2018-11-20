package com.kotall.rms.core.service.litemall.impl;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kotall.rms.common.utils.Query;
import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.entity.litemall.LiteMallCartEntity;
import com.kotall.rms.core.manager.litemall.LiteMallCartManager;
import com.kotall.rms.core.service.litemall.LiteMallCartService;

/**
 * 购物车商品表
 *
 * @author kotall
 * @date 2018年11月20日 下午12:39:39
 * @since 1.0.0
 */
@Service("liteMallCartService")
public class LiteMallCartServiceImpl implements LiteMallCartService {

	@Autowired
	private LiteMallCartManager liteMallCartManager;

	@Override
	public Page<LiteMallCartEntity> listLiteMallCart(Map<String, Object> params) {
		Query query = new Query(params);
		Page<LiteMallCartEntity> page = new Page<>(query);
		liteMallCartManager.listLiteMallCart(page, query);
		return page;
	}

	@Override
	public List<LiteMallCartEntity> queryCartList(Map<String, Object> params) {
		Query query = new Query(params);
		return this.liteMallCartManager.queryCartList(query);
	}

	@Override
	public int saveLiteMallCart(LiteMallCartEntity role) {
		int count = liteMallCartManager.saveLiteMallCart(role);
		return count;
	}

	@Override
	public LiteMallCartEntity getLiteMallCartById(Long id) {
		LiteMallCartEntity liteMallCart = liteMallCartManager.getLiteMallCartById(id);
		return liteMallCart;
	}

	@Override
	public int updateLiteMallCart(LiteMallCartEntity liteMallCart) {
		int count = liteMallCartManager.updateLiteMallCart(liteMallCart);
		return count;
	}

	@Override
	public int batchRemove(Long[] id) {
		int count = liteMallCartManager.batchRemove(id);
		return count;
	}

	@Override
	public List<LiteMallCartEntity> queryByUserId(Integer userId) {
		Map<String, Object> params = new HashMap<>();
		return this.queryCartList(params);
	}

	@Override
	public LiteMallCartEntity queryExist(Integer goodsId, Integer productId, Integer userId) {
		Map<String, Object> params = new HashMap<>();
		//params.put("storeId", storeId);
		params.put("userId", userId);
		params.put("goodsId", goodsId);
		params.put("productId", productId);
		List<LiteMallCartEntity> list = this.queryCartList(params);
		return CollectionUtils.isEmpty(list) ? null : list.get(0);
	}

	@Override
	public List<LiteMallCartEntity> queryByUserIdAndChecked(Integer userId) {
		Map<String, Object> params = new HashMap<>();
		//params.put("storeId", storeId);
		params.put("userId", userId);
		params.put("deleted", 0);
		params.put("checked", 1);
		return this.queryCartList(params);
	}

	@Override
	public void updateCheck(Integer userId, List<Integer> productIds, Boolean isChecked) {
		Map<String, Object> params = new HashMap<>();
		//params.put("storeId", storeId);
		params.put("userId", userId);
		params.put("deleted", 0);
		params.put("productIds", productIds);

		LiteMallCartEntity cart = new LiteMallCartEntity();
		cart.setChecked(isChecked ? 1 : 0);
		cart.setUpdateTime(new Date());

		this.liteMallCartManager.updateCartByCause(cart, new Query(params));
	}

	@Override
	public void delete(List<Integer> productIds, Integer userId) {
		Map<String, Object> params = new HashMap<>();
		//params.put("storeId", storeId);
		params.put("userId", userId);
		params.put("productIds", productIds);

		this.liteMallCartManager.deleteCartByCause(new Query(params));
	}
}
