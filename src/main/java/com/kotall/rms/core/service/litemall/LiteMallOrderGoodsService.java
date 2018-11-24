package com.kotall.rms.core.service.litemall;

import com.kotall.rms.common.entity.litemall.LiteMallOrderGoodsEntity;
import com.kotall.rms.common.utils.Page;
import com.kotall.rms.core.service.BaseService;

import java.util.List;
import java.util.Map;

/**
 * 订单商品表
 *
 * @author kotall
 * @date 2018年11月13日 下午4:45:21
 * @since 1.0.0
 */
public interface LiteMallOrderGoodsService extends BaseService<LiteMallOrderGoodsEntity> {

    Page<LiteMallOrderGoodsEntity> queryOrderGoodsByPage(Map<String, Object> params);

    List<LiteMallOrderGoodsEntity> queryByOrderId(Map<String, Object> params);

    Integer countCommentIds(Map<String, Object> params);

}
