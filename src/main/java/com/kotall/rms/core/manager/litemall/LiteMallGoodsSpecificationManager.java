package com.kotall.rms.core.manager.litemall;

import com.kotall.rms.common.entity.litemall.LiteMallGoodsSpecificationEntity;
import com.kotall.rms.core.manager.BaseManager;

import java.util.List;

/**
 * 商品规格表
 *
 * @author kotall
 * @date 2018年11月20日 下午7:50:58
 * @since 1.0.0
 */
public interface LiteMallGoodsSpecificationManager extends BaseManager<LiteMallGoodsSpecificationEntity> {

    void insertBatch(List<LiteMallGoodsSpecificationEntity> liteMallGoodsSpecifications);
}
