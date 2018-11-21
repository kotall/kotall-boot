package com.kotall.rms.core.manager.litemall;

import java.util.List;

import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Query;
import com.kotall.rms.common.entity.litemall.LiteMallGoodsProductEntity;

/**
 * 商品货品表
 *
 * @author kotall
 * @date 2018年11月20日 下午12:58:29
 * @since 1.0.0
 */
public interface LiteMallGoodsProductManager {

	List<LiteMallGoodsProductEntity> listLiteMallGoodsProduct(Page<LiteMallGoodsProductEntity> page, Query search);
	
	int saveLiteMallGoodsProduct(LiteMallGoodsProductEntity liteMallGoodsProduct);
	
	LiteMallGoodsProductEntity getLiteMallGoodsProductById(Long id);
	
	int updateLiteMallGoodsProduct(LiteMallGoodsProductEntity liteMallGoodsProduct);
	
	int batchRemove(Long[] id);

    List<LiteMallGoodsProductEntity> queryGoodsProductList(Query query);
}
