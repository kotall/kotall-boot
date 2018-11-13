package com.kotall.rms.core.service.litemall.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kotall.rms.common.utils.Query;
import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.entity.litemall.LiteMallOrderEntity;
import com.kotall.rms.core.manager.litemall.LiteMallOrderManager;
import com.kotall.rms.core.service.litemall.LiteMallOrderService;

/**
 * 订单表
 *
 * @author kotall
 * @date 2018年11月13日 下午4:22:38
 * @since 1.0.0
 */
@Service("liteMallOrderService")
public class LiteMallOrderServiceImpl implements LiteMallOrderService {

	@Autowired
	private LiteMallOrderManager liteMallOrderManager;

	@Override
	public Page<LiteMallOrderEntity> listLiteMallOrder(Map<String, Object> params) {
		Query query = new Query(params);
		Page<LiteMallOrderEntity> page = new Page<>(query);
		liteMallOrderManager.listLiteMallOrder(page, query);
		return page;
	}

	@Override
	public int saveLiteMallOrder(LiteMallOrderEntity role) {
		int count = liteMallOrderManager.saveLiteMallOrder(role);
		return count;
	}

	@Override
	public LiteMallOrderEntity getLiteMallOrderById(Long id) {
		LiteMallOrderEntity liteMallOrder = liteMallOrderManager.getLiteMallOrderById(id);
		return liteMallOrder;
	}

	@Override
	public int updateLiteMallOrder(LiteMallOrderEntity liteMallOrder) {
		int count = liteMallOrderManager.updateLiteMallOrder(liteMallOrder);
		return count;
	}

	@Override
	public int batchRemove(Long[] id) {
		int count = liteMallOrderManager.batchRemove(id);
		return count;
	}

}
