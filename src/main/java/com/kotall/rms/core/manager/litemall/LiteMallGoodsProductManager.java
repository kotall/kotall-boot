package com.kotall.rms.core.manager.litemall;

import com.kotall.rms.common.entity.litemall.LiteMallGoodsProductEntity;
import com.kotall.rms.core.manager.BaseManager;

import java.util.List;

/**
 * 商品货品表
 *
 * @author kotall
 * @date 2018年11月20日 下午12:58:29
 * @since 1.0.0
 */
public interface LiteMallGoodsProductManager extends BaseManager<LiteMallGoodsProductEntity> {
    void insertBatch(List<LiteMallGoodsProductEntity> liteMallGoodsProducts);
}
