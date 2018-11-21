package com.kotall.rms.core.manager.litemall;

import java.util.List;

import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Query;
import com.kotall.rms.common.entity.litemall.LiteMallOrderEntity;

/**
 * 订单表
 *
 * @author kotall
 * @date 2018年11月13日 下午4:22:38
 * @since 1.0.0
 */
public interface LiteMallOrderManager {

	List<LiteMallOrderEntity> listLiteMallOrder(Page<LiteMallOrderEntity> page, Query search);
	
	int saveLiteMallOrder(LiteMallOrderEntity liteMallOrder);
	
	LiteMallOrderEntity getLiteMallOrderById(Long id);
	
	int updateLiteMallOrder(LiteMallOrderEntity liteMallOrder);
	
	int batchRemove(Long[] id);

    List<LiteMallOrderEntity> queryOrderList(Query query);

    int countTotal(Query query);
}
