package com.kotall.rms.core.service.litemall;

import java.util.List;
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

    /**
     * 查询最新商品列表
     * @param params
     * @return
     */
    List<LiteMallGoodsEntity> queryByNew(Map<String, Object> params);

    /**
     * 查询热卖商品
     * @param params
     * @return
     */
    List<LiteMallGoodsEntity> queryByHot(Map<String, Object> params);

    /**
     * 根据类别查询产品列表
     * @param params
     * @return
     */
    List<LiteMallGoodsEntity> queryByCategory(Map<String, Object> params);
}
