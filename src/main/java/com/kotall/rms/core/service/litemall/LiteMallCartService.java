package com.kotall.rms.core.service.litemall;

import com.kotall.rms.common.entity.litemall.LiteMallCartEntity;
import com.kotall.rms.core.service.BaseService;

import java.util.List;

/**
 * 购物车商品表
 *
 * @author kotall
 * @date 2018年11月20日 下午12:39:39
 * @since 1.0.0
 */
public interface LiteMallCartService extends BaseService<LiteMallCartEntity> {

    List<LiteMallCartEntity> queryByUserId(Integer userId);

    LiteMallCartEntity queryExist(Integer userId, Integer goodsId, Integer productId);

    List<LiteMallCartEntity> queryByUserIdAndChecked(Integer userId);

    void updateCheck(Integer userId, List<Integer> productIds, Boolean isChecked);

    void delete(List<Integer> productIds, Integer userId);

    void clearGoods(Integer userId);

    /**
     * 添加购物车功能
     * @param isFastAddCart
     *       是否是直接添加
     * @param cart
     *       购物车条目
     */
    void saveOrUpdateCart(Boolean isFastAddCart, LiteMallCartEntity cart);

    /**
     * 统计购物车商品数量
     * @param userId
     * @return
     */
    Integer countGoodsInCart(Integer userId);
}
