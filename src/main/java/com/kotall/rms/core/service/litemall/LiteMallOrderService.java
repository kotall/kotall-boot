package com.kotall.rms.core.service.litemall;

import com.kotall.rms.common.entity.litemall.LiteMallOrderEntity;
import com.kotall.rms.common.utils.Page;
import com.kotall.rms.core.service.BaseService;

import java.util.Map;

/**
 * 订单表
 *
 * @author kotall
 * @date 2018年11月13日 下午4:22:38
 * @since 1.0.0
 */
public interface LiteMallOrderService extends BaseService<LiteMallOrderEntity> {

    Page<LiteMallOrderEntity> queryOrderByPage(Map<String, Object> params);

    Map<Object, Object> queryOrderInfo(Integer userId, Integer storeId);

    String generateOrderSn(Integer userId);

    LiteMallOrderEntity findOrderBySn(Map<String, Object> params);

}
