package com.kotall.rms.core.manager.litemall;

import com.kotall.rms.common.entity.litemall.LiteMallCartEntity;
import com.kotall.rms.common.utils.Query;
import com.kotall.rms.core.manager.BaseManager;

/**
 * 购物车商品表
 *
 * @author kotall
 * @date 2018年11月20日 下午12:39:39
 * @since 1.0.0
 */
public interface LiteMallCartManager extends BaseManager<LiteMallCartEntity> {

	void updateCartByCause(LiteMallCartEntity cart, Query query);

	void deleteCartByCause(Query query);
}
