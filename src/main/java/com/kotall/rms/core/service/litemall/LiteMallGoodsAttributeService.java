package com.kotall.rms.core.service.litemall;

import com.kotall.rms.common.entity.litemall.LiteMallGoodsAttributeEntity;
import com.kotall.rms.core.service.BaseService;

import java.util.List;
import java.util.Map;

/**
 * 商品参数表
 *
 * @author kotall
 * @date 2018年11月20日 下午7:51:23
 * @since 1.0.0
 */
public interface LiteMallGoodsAttributeService extends BaseService<LiteMallGoodsAttributeEntity> {

    List<LiteMallGoodsAttributeEntity> queryByGoodsId(Map<String, Object> params);

    List<LiteMallGoodsAttributeEntity> getByGoodsId(String goodsId);
}
