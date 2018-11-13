package com.kotall.rms.core.service.litemall;

import java.util.Map;

import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Result;
import com.kotall.rms.common.entity.litemall.LiteMallOrderGoodsEntity;

/**
 * 订单商品表
 *
 * @author kotall
 * @date 2018年11月13日 下午4:45:21
 * @since 1.0.0
 */
public interface LiteMallOrderGoodsService {

	Page<LiteMallOrderGoodsEntity> listLiteMallOrderGoods(Map<String, Object> params);

    int saveLiteMallOrderGoods(LiteMallOrderGoodsEntity liteMallOrderGoods);

    LiteMallOrderGoodsEntity getLiteMallOrderGoodsById(Long id);

    int updateLiteMallOrderGoods(LiteMallOrderGoodsEntity liteMallOrderGoods);

    int batchRemove(Long[] id);
	
}
