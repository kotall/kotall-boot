package com.kotall.rms.core.service.litemall.impl;

import com.kotall.rms.common.entity.litemall.LiteMallCartEntity;
import com.kotall.rms.common.entity.litemall.LiteMallGoodsEntity;
import com.kotall.rms.common.entity.litemall.LiteMallGoodsProductEntity;
import com.kotall.rms.common.utils.Query;
import com.kotall.rms.core.RmsException;
import com.kotall.rms.core.manager.litemall.LiteMallCartManager;
import com.kotall.rms.core.manager.litemall.LiteMallGoodsManager;
import com.kotall.rms.core.manager.litemall.LiteMallGoodsProductManager;
import com.kotall.rms.core.service.BaseServiceImpl;
import com.kotall.rms.core.service.litemall.LiteMallCartService;
import org.apache.shiro.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

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
	@Autowired
	private LiteMallGoodsManager liteMallGoodsManager;
	@Autowired
	private LiteMallGoodsProductManager liteMallGoodsProductManager;

	@Override
	public List<LiteMallCartEntity> queryByUserId(Integer userId) {
		Map<String, Object> params = new HashMap<>();
		params.put("userId", userId);
		return this.queryByList(params);
	}

	@Override
	public LiteMallCartEntity queryExist(Integer userId, Integer goodsId, Integer productId) {
		Map<String, Object> params = new HashMap<>();
		params.put("userId", userId);
		params.put("goodsId", goodsId);
		params.put("productId", productId);
		List<LiteMallCartEntity> list = this.queryByList(params);
		return CollectionUtils.isEmpty(list) ? null : list.get(0);
	}

	@Override
	public List<LiteMallCartEntity> queryByUserIdAndChecked(Integer userId) {
		Map<String, Object> params = new HashMap<>();
		params.put("userId", userId);
		params.put("deleted", 0);
		params.put("checked", 1);
		return this.queryByList(params);
	}

	@Override
	public void updateCheck(Integer userId, List<Integer> productIds, Boolean isChecked) {
		Map<String, Object> params = new HashMap<>();
		params.put("userId", userId);
		params.put("deleted", 0);
		params.put("productIds", productIds);

		LiteMallCartEntity cart = new LiteMallCartEntity();
		cart.setChecked(isChecked);
		cart.setUpdateTime(new Date());

		this.liteMallCartManager.updateCartByCause(cart, new Query(params));
	}

	@Override
	public void delete(List<Integer> productIds, Integer userId) {
		Map<String, Object> params = new HashMap<>();
		params.put("userId", userId);
		params.put("productIds", productIds);

		this.liteMallCartManager.deleteCartByCause(new Query(params));
	}

	@Override
	public void clearGoods(Integer userId) {
		Map<String, Object> params = new HashMap<>();
		params.put("userId", userId);
		params.put("checked", 1);

		LiteMallCartEntity cartEntity = new LiteMallCartEntity();
		cartEntity.setDeleted(1);

		this.liteMallCartManager.updateCartByCause(cartEntity, new Query(params));
	}

	@Override
	public void saveOrUpdateCart(Boolean isFastAddCart, LiteMallCartEntity cart) {
		/** 1.判断商品是否可以购买 */
		LiteMallGoodsEntity goods = this.liteMallGoodsManager.getById(cart.getGoodsId());
		if (goods == null || !goods.getIsOnSale()) {
			throw new RmsException(400, "商品已下架");
		}

		/** 2.货品检查 */
		LiteMallGoodsProductEntity product = liteMallGoodsProductManager.getById(cart.getProductId());
		Assert.notNull(product, "购物车对应的货品不存在");

		LiteMallCartEntity existCart = this.queryExist(cart.getUserId(), cart.getGoodsId(), cart.getProductId());

		if (cart.getNumber() > product.getNumber()) {
			throw new RmsException(403, "库存不足");
		}
		// 新增购物车条目
		if (null == existCart) {
            cart.setId(null);
			cart.setGoodsSn(goods.getGoodsSn());
			cart.setGoodsName((goods.getName()));
			cart.setPicUrl(goods.getPicUrl());
			cart.setPrice(product.getPrice());
			cart.setSpecifications(product.getSpecifications());
			cart.setChecked(true);
			cart.setAddTime(new Date());
			this.save(cart);
		}
		// 更新购物车
		else {
			Integer number = cart.getNumber();
			if (!isFastAddCart) {
				number += existCart.getNumber();
				if (number > product.getNumber()) {
					throw new RmsException(403, "库存不足");
				}
			}

			existCart.setNumber(number);

            if (!this.update(existCart)) {
               throw new RmsException(404, "更新数据失败！");
			}

		}
	}

	@Override
	public Integer countGoodsInCart(Integer userId) {
		Integer goodsCount = 0;
		List<LiteMallCartEntity> cartItems = this.queryByUserId(userId);
		for (LiteMallCartEntity item : cartItems) {
			goodsCount += item.getNumber();
		}
		return goodsCount;
	}
}
