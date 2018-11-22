package com.kotall.rms.core.manager.litemall;

import java.util.List;

import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Query;
import com.kotall.rms.common.entity.litemall.LiteMallCartEntity;

/**
 * 购物车商品表
 *
 * @author kotall
 * @date 2018年11月20日 下午12:39:39
 * @since 1.0.0
 */
public interface LiteMallCartManager {

	List<LiteMallCartEntity> listLiteMallCart(Page<LiteMallCartEntity> page, Query search);
	
	int saveLiteMallCart(LiteMallCartEntity liteMallCart);
	
	LiteMallCartEntity getLiteMallCartById(Long id);
	
	int updateLiteMallCart(LiteMallCartEntity liteMallCart);
	
	int batchRemove(Long[] id);

    List<LiteMallCartEntity> queryCartList(Query query);

	void updateCartByCause(LiteMallCartEntity cart, Query query);

	void deleteCartByCause(Query query);
}
