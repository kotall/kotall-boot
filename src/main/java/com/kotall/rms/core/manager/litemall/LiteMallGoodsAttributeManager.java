package com.kotall.rms.core.manager.litemall;

import com.kotall.rms.common.entity.litemall.LiteMallGoodsAttributeEntity;
import com.kotall.rms.core.manager.BaseManager;

import java.util.List;

/**
 * 商品参数表
 *
 * @author kotall
 * @date 2018年11月20日 下午7:51:23
 * @since 1.0.0
 */
public interface LiteMallGoodsAttributeManager extends BaseManager<LiteMallGoodsAttributeEntity> {

    void insertBatch(List<LiteMallGoodsAttributeEntity> liteMallGoodsAttributes);

    List<LiteMallGoodsAttributeEntity> getByGoodsId(String goodsId);
}
