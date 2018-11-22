package com.kotall.rms.core.service.litemall;

import java.util.List;
import java.util.Map;

import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Result;
import com.kotall.rms.common.entity.litemall.LiteMallGoodsProductEntity;

/**
 * 商品货品表
 *
 * @author kotall
 * @date 2018年11月20日 下午12:58:29
 * @since 1.0.0
 */
public interface LiteMallGoodsProductService {

	Page<LiteMallGoodsProductEntity> listLiteMallGoodsProduct(Map<String, Object> params);

    List<LiteMallGoodsProductEntity> queryGoodsProductList(Map<String, Object> params);

    int saveLiteMallGoodsProduct(LiteMallGoodsProductEntity liteMallGoodsProduct);

    LiteMallGoodsProductEntity getLiteMallGoodsProductById(Long id);

    int updateLiteMallGoodsProduct(LiteMallGoodsProductEntity liteMallGoodsProduct);

    int batchRemove(Long[] id);

    List<LiteMallGoodsProductEntity> queryByGoodsId(Map<String, Object> params);
}
