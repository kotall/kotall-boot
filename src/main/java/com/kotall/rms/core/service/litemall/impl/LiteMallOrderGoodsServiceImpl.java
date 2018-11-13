package com.kotall.rms.core.service.litemall.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kotall.rms.common.utils.Query;
import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.entity.litemall.LiteMallOrderGoodsEntity;
import com.kotall.rms.core.manager.litemall.LiteMallOrderGoodsManager;
import com.kotall.rms.core.service.litemall.LiteMallOrderGoodsService;

/**
 * 订单商品表
 *
 * @author kotall
 * @date 2018年11月13日 下午4:45:21
 * @since 1.0.0
 */
@Service("liteMallOrderGoodsService")
public class LiteMallOrderGoodsServiceImpl implements LiteMallOrderGoodsService {

	@Autowired
	private LiteMallOrderGoodsManager liteMallOrderGoodsManager;

	@Override
	public Page<LiteMallOrderGoodsEntity> listLiteMallOrderGoods(Map<String, Object> params) {
		Query query = new Query(params);
		Page<LiteMallOrderGoodsEntity> page = new Page<>(query);
		liteMallOrderGoodsManager.listLiteMallOrderGoods(page, query);
		return page;
	}

	@Override
	public int saveLiteMallOrderGoods(LiteMallOrderGoodsEntity role) {
		int count = liteMallOrderGoodsManager.saveLiteMallOrderGoods(role);
		return count;
	}

	@Override
	public LiteMallOrderGoodsEntity getLiteMallOrderGoodsById(Long id) {
		LiteMallOrderGoodsEntity liteMallOrderGoods = liteMallOrderGoodsManager.getLiteMallOrderGoodsById(id);
		return liteMallOrderGoods;
	}

	@Override
	public int updateLiteMallOrderGoods(LiteMallOrderGoodsEntity liteMallOrderGoods) {
		int count = liteMallOrderGoodsManager.updateLiteMallOrderGoods(liteMallOrderGoods);
		return count;
	}

	@Override
	public int batchRemove(Long[] id) {
		int count = liteMallOrderGoodsManager.batchRemove(id);
		return count;
	}

}
