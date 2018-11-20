package com.kotall.rms.core.service.litemall;

import java.util.Map;

import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Result;
import com.kotall.rms.common.entity.litemall.LiteMallGoodsSpecificationEntity;

/**
 * 商品规格表
 *
 * @author kotall
 * @date 2018年11月20日 下午7:50:58
 * @since 1.0.0
 */
public interface LiteMallGoodsSpecificationService {

	Page<LiteMallGoodsSpecificationEntity> listLiteMallGoodsSpecification(Map<String, Object> params);

    int saveLiteMallGoodsSpecification(LiteMallGoodsSpecificationEntity liteMallGoodsSpecification);

    LiteMallGoodsSpecificationEntity getLiteMallGoodsSpecificationById(Long id);

    int updateLiteMallGoodsSpecification(LiteMallGoodsSpecificationEntity liteMallGoodsSpecification);

    int batchRemove(Long[] id);
	
}
