package com.kotall.rms.core.service.litemall;

import java.util.List;
import java.util.Map;

import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Result;
import com.kotall.rms.common.entity.litemall.LiteMallOrderEntity;

/**
 * 订单表
 *
 * @author kotall
 * @date 2018年11月13日 下午4:22:38
 * @since 1.0.0
 */
public interface LiteMallOrderService {

	Page<LiteMallOrderEntity> listLiteMallOrder(Map<String, Object> params);

	List<LiteMallOrderEntity> queryOrderList(Map<String, Object> params);

    int saveLiteMallOrder(LiteMallOrderEntity liteMallOrder);

    LiteMallOrderEntity getLiteMallOrderById(Long id);

    int updateLiteMallOrder(LiteMallOrderEntity liteMallOrder);

    int batchRemove(Long[] id);

    Map<Object, Object> queryOrderInfo(Integer userId);
}
