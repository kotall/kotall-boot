package com.kotall.rms.core.service.litemall;

import java.util.Map;

import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Result;
import com.kotall.rms.common.entity.litemall.LiteMallGoodsAttributeEntity;

/**
 * 商品参数表
 *
 * @author kotall
 * @date 2018年11月20日 下午7:51:23
 * @since 1.0.0
 */
public interface LiteMallGoodsAttributeService {

	Page<LiteMallGoodsAttributeEntity> listLiteMallGoodsAttribute(Map<String, Object> params);

    int saveLiteMallGoodsAttribute(LiteMallGoodsAttributeEntity liteMallGoodsAttribute);

    LiteMallGoodsAttributeEntity getLiteMallGoodsAttributeById(Long id);

    int updateLiteMallGoodsAttribute(LiteMallGoodsAttributeEntity liteMallGoodsAttribute);

    int batchRemove(Long[] id);
	
}
