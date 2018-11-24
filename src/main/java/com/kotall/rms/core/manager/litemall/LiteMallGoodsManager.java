package com.kotall.rms.core.manager.litemall;

import com.kotall.rms.common.entity.litemall.LiteMallGoodsEntity;
import com.kotall.rms.common.utils.Query;
import com.kotall.rms.core.manager.BaseManager;

import java.util.List;

/**
 * 商品基本信息表
 *
 * @author kotall
 * @date 2018年11月19日 下午3:03:30
 * @since 1.0.0
 */
public interface LiteMallGoodsManager extends BaseManager<LiteMallGoodsEntity> {

    Integer countOnSale(Query query);

	List<Integer> queryCategoryIds(Query query);
}
