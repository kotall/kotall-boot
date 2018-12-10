package com.kotall.rms.core.service.litemall;

import com.kotall.rms.common.entity.litemall.LiteMallGoodsProductEntity;
import com.kotall.rms.common.entity.litemall.LiteMallGoodsSpecificationEntity;
import com.kotall.rms.core.service.BaseService;

import java.util.List;
import java.util.Map;

/**
 * 商品货品表
 *
 * @author kotall
 * @date 2018年11月20日 下午12:58:29
 * @since 1.0.0
 */
public interface LiteMallGoodsProductService extends BaseService<LiteMallGoodsProductEntity>{

    List<LiteMallGoodsProductEntity> queryByGoodsId(Map<String, Object> params);

    List<LiteMallGoodsProductEntity> getByGoodsId(String goodsId);
}
