package com.kotall.rms.core.manager.litemall;

import java.util.List;

import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Query;
import com.kotall.rms.common.entity.litemall.LiteMallGoodsAttributeEntity;

/**
 * 商品参数表
 *
 * @author kotall
 * @date 2018年11月20日 下午7:51:23
 * @since 1.0.0
 */
public interface LiteMallGoodsAttributeManager {

	List<LiteMallGoodsAttributeEntity> listLiteMallGoodsAttribute(Page<LiteMallGoodsAttributeEntity> page, Query search);
	
	int saveLiteMallGoodsAttribute(LiteMallGoodsAttributeEntity liteMallGoodsAttribute);
	
	LiteMallGoodsAttributeEntity getLiteMallGoodsAttributeById(Long id);
	
	int updateLiteMallGoodsAttribute(LiteMallGoodsAttributeEntity liteMallGoodsAttribute);
	
	int batchRemove(Long[] id);

    List<LiteMallGoodsAttributeEntity> queryGoodsAttributeList(Query query);
}