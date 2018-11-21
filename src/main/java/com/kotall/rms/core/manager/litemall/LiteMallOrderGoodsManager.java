package com.kotall.rms.core.manager.litemall;

import java.util.List;

import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Query;
import com.kotall.rms.common.entity.litemall.LiteMallOrderGoodsEntity;

/**
 * 订单商品表
 *
 * @author kotall
 * @date 2018年11月13日 下午4:45:21
 * @since 1.0.0
 */
public interface LiteMallOrderGoodsManager {

	List<LiteMallOrderGoodsEntity> listLiteMallOrderGoods(Page<LiteMallOrderGoodsEntity> page, Query search);
	
	int saveLiteMallOrderGoods(LiteMallOrderGoodsEntity liteMallOrderGoods);
	
	LiteMallOrderGoodsEntity getLiteMallOrderGoodsById(Long id);
	
	int updateLiteMallOrderGoods(LiteMallOrderGoodsEntity liteMallOrderGoods);
	
	int batchRemove(Long[] id);

    List<LiteMallOrderGoodsEntity> queryOrderGoodsList(Query query);

    Integer countTotal(Query query);
}
