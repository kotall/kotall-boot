package com.kotall.rms.core.manager.litemall;

import java.util.List;

import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Query;
import com.kotall.rms.common.entity.litemall.LiteMallGoodsSpecificationEntity;

/**
 * 商品规格表
 *
 * @author kotall
 * @date 2018年11月20日 下午7:50:58
 * @since 1.0.0
 */
public interface LiteMallGoodsSpecificationManager {

	List<LiteMallGoodsSpecificationEntity> listLiteMallGoodsSpecification(Page<LiteMallGoodsSpecificationEntity> page, Query search);
	
	int saveLiteMallGoodsSpecification(LiteMallGoodsSpecificationEntity liteMallGoodsSpecification);
	
	LiteMallGoodsSpecificationEntity getLiteMallGoodsSpecificationById(Long id);
	
	int updateLiteMallGoodsSpecification(LiteMallGoodsSpecificationEntity liteMallGoodsSpecification);
	
	int batchRemove(Long[] id);
	
}
