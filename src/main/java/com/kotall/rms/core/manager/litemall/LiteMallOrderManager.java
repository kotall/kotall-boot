package com.kotall.rms.core.manager.litemall;

import com.kotall.rms.common.entity.litemall.LiteMallOrderEntity;
import com.kotall.rms.common.utils.Query;
import com.kotall.rms.core.manager.BaseManager;

/**
 * 订单表
 *
 * @author kotall
 * @date 2018年11月13日 下午4:22:38
 * @since 1.0.0
 */
public interface LiteMallOrderManager extends BaseManager<LiteMallOrderEntity> {

    int countTotal(Query query);
}
