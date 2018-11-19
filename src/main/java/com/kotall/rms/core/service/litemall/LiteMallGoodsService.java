package com.kotall.rms.core.service.litemall;

import java.util.Map;

import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Result;
import com.kotall.rms.common.entity.litemall.LiteMallGoodsEntity;

/**
 * 商品基本信息表
 *
 * @author kotall
 * @date 2018年11月19日 下午3:03:30
 * @since 1.0.0
 */
public interface LiteMallGoodsService {

	Page<LiteMallGoodsEntity> listLiteMallGoods(Map<String, Object> params);

    int saveLiteMallGoods(LiteMallGoodsEntity liteMallGoods);

    LiteMallGoodsEntity getLiteMallGoodsById(Long id);

    int updateLiteMallGoods(LiteMallGoodsEntity liteMallGoods);

    int batchRemove(Long[] id);
	
}
