package com.kotall.rms.core.service.litemall.impl;

import com.kotall.rms.common.entity.litemall.LiteMallOrderEntity;
import com.kotall.rms.common.utils.OrderUtil;
import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Query;
import com.kotall.rms.core.annotation.StoreFilter;
import com.kotall.rms.core.manager.litemall.LiteMallOrderManager;
import com.kotall.rms.core.service.BaseServiceImpl;
import com.kotall.rms.core.service.litemall.LiteMallOrderService;
import org.apache.shiro.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.kotall.rms.common.utils.CharUtil.getRandomNum;

/**
 * 订单表
 *
 * @author kotall
 * @date 2018年11月13日 下午4:22:38
 * @since 1.0.0
 */
@Service("liteMallOrderService")
public class LiteMallOrderServiceImpl extends BaseServiceImpl<LiteMallOrderManager, LiteMallOrderEntity> implements LiteMallOrderService {

	@Autowired
	private LiteMallOrderManager liteMallOrderManager;

	@StoreFilter
	@Override
	public Page<LiteMallOrderEntity> queryOrderByPage(Map<String, Object> params) {
		return super.queryByPage(params);
	}

	@Override
	public Map<Object, Object> queryOrderInfo(Integer userId, Integer storeId) {
		Map<String, Object> params = new HashMap<>();
		params.put("storeId", storeId);
		params.put("userId", userId);
		params.put("deleted", 0);
		List<LiteMallOrderEntity> orders = this.queryByList(params);

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

	// TODO 这里应该产生一个唯一的订单，但是实际上这里仍然存在两个订单相同的可能性
	@Override
	public String generateOrderSn(Integer userId) {
		DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyyMMdd");
		String now = df.format(LocalDate.now());
		String orderSn = now + getRandomNum(6);
		while(countByOrderSn(userId, orderSn) != 0){
			orderSn = getRandomNum(6);
		}
		return orderSn;
	}

	private int countByOrderSn(Integer userId, String orderSn){
		Map<String, Object> params = new HashMap<>();
		params.put("userId", userId);
		params.put("orderSn", orderSn);
		Query query = new Query(params);
		return this.liteMallOrderManager.countTotal(query);
	}

	@Override
	public LiteMallOrderEntity findOrderBySn(Map<String, Object> params) {
		List<LiteMallOrderEntity> list = this.queryByList(params);
		return CollectionUtils.isEmpty(list) ? null : list.get(0);
	}

	@Override
	public boolean deleteById(Integer orderId) {
		LiteMallOrderEntity orderEntity = new LiteMallOrderEntity();
		orderEntity.setDeleted(true);
		orderEntity.setId(orderId);
		return super.update(orderEntity);
	}
}
