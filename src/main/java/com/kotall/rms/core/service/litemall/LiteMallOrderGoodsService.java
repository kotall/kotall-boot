package com.kotall.rms.core.service.litemall;

import com.kotall.rms.common.entity.litemall.LiteMallOrderGoodsEntity;
import com.kotall.rms.common.utils.Page;

import java.util.Map;

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
