package com.kotall.rms.core.service.litemall.impl;

import com.kotall.rms.common.entity.litemall.LiteMallCartEntity;
import com.kotall.rms.common.utils.Query;
import com.kotall.rms.core.manager.litemall.LiteMallCartManager;
import com.kotall.rms.core.service.BaseServiceImpl;
import com.kotall.rms.core.service.litemall.LiteMallCartService;
import org.apache.shiro.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 购物车商品表
 *
 * @author kotall
 * @date 2018年11月20日 下午12:39:39
 * @since 1.0.0
 */
@Service("liteMallCartService")
public class LiteMallCartServiceImpl extends BaseServiceImpl<LiteMallCartManager, LiteMallCartEntity> implements LiteMallCartService {

	@Autowired
	private LiteMallCartManager liteMallCartManager;

	@Override
	public List<LiteMallCartEntity> queryByUserId(Integer storeId, Integer userId) {
		Map<String, Object> params = new HashMap<>();
		params.put("storeId", storeId);
		params.put("userId", userId);
		return this.queryByList(params);
	}

	@Override
	public LiteMallCartEntity queryExist(Integer storeId, Integer goodsId, Integer productId, Integer userId) {
		Map<String, Object> params = new HashMap<>();
		params.put("storeId", storeId);
		params.put("userId", userId);
		params.put("goodsId", goodsId);
		params.put("productId", productId);
		List<LiteMallCartEntity> list = this.queryByList(params);
		return CollectionUtils.isEmpty(list) ? null : list.get(0);
	}

	@Override
	public List<LiteMallCartEntity> queryByUserIdAndChecked(Integer userId) {
		Map<String, Object> params = new HashMap<>();
		//params.put("storeId", storeId);
		params.put("userId", userId);
		params.put("deleted", 0);
		params.put("checked", 1);
		return this.queryByList(params);
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

	@Override
	public void clearGoods(Integer userId) {
		Map<String, Object> params = new HashMap<>();
		//params.put("storeId", storeId);
		params.put("userId", userId);
		params.put("checked", 1);

		LiteMallCartEntity cartEntity = new LiteMallCartEntity();
		cartEntity.setDeleted(1);

		this.liteMallCartManager.updateCartByCause(cartEntity, new Query(params));
	}
}
