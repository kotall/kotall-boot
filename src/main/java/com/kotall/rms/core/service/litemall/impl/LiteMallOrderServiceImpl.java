package com.kotall.rms.core.service.litemall.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kotall.rms.common.utils.OrderUtil;
import com.kotall.rms.core.annotation.StoreFilter;
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

	@StoreFilter
	@Override
	public Page<LiteMallOrderEntity> listLiteMallOrder(Map<String, Object> params) {
		Query query = new Query(params);
		Page<LiteMallOrderEntity> page = new Page<>(query);
		liteMallOrderManager.listLiteMallOrder(page, query);
		return page;
	}

	@Override
	public List<LiteMallOrderEntity> queryOrderList(Map<String, Object> params) {
		Query query = new Query(params);
		return this.liteMallOrderManager.queryOrderList(query);
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

	@Override
	public Map<Object, Object> queryOrderInfo(Integer userId) {
		Map<String, Object> params = new HashMap<>();
		//params.put("storeId", storeId);
		params.put("userId", userId);
		params.put("deleted", 0);
		List<LiteMallOrderEntity> orders = this.queryOrderList(params);

		int unpaid = 0;
		int unship = 0;
		int unrecv = 0;
		int uncomment = 0;
		for(LiteMallOrderEntity order : orders){
			if(OrderUtil.isCreateStatus(order)){
				unpaid++;
			}
			else if(OrderUtil.isPayStatus(order)){
				unship++;
			}
			else if(OrderUtil.isShipStatus(order)){
				unrecv++;
			}
			else if(OrderUtil.isConfirmStatus(order) || OrderUtil.isAutoConfirmStatus(order)){
				uncomment += order.getComments();
			}
			else {
				// do nothing
			}
		}

		Map<Object, Object> orderInfo = new HashMap<>();
		orderInfo.put("unpaid", unpaid);
		orderInfo.put("unship", unship);
		orderInfo.put("unrecv", unrecv);
		orderInfo.put("uncomment", uncomment);
		return orderInfo;
	}
}
