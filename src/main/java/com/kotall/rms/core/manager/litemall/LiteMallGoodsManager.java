package com.kotall.rms.core.manager.litemall;

import java.util.List;

import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Query;
import com.kotall.rms.common.entity.litemall.LiteMallGoodsEntity;

/**
 * 商品基本信息表
 *
 * @author kotall
 * @date 2018年11月19日 下午3:03:30
 * @since 1.0.0
 */
public interface LiteMallGoodsManager {

	List<LiteMallGoodsEntity> listLiteMallGoods(Page<LiteMallGoodsEntity> page, Query search);
	
	int saveLiteMallGoods(LiteMallGoodsEntity liteMallGoods);
	
	LiteMallGoodsEntity getLiteMallGoodsById(Long id);
	
	int updateLiteMallGoods(LiteMallGoodsEntity liteMallGoods);
	
	int batchRemove(Long[] id);

    Integer countOnSale(Query query);

	List<Integer> queryCategoryIds(Query query);
}
