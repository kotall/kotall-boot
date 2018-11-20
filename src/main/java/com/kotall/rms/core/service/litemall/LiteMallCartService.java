package com.kotall.rms.core.service.litemall;

import java.util.List;
import java.util.Map;

import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Result;
import com.kotall.rms.common.entity.litemall.LiteMallCartEntity;

/**
 * 购物车商品表
 *
 * @author kotall
 * @date 2018年11月20日 下午12:39:39
 * @since 1.0.0
 */
public interface LiteMallCartService {

	Page<LiteMallCartEntity> listLiteMallCart(Map<String, Object> params);

    List<LiteMallCartEntity> queryCartList(Map<String, Object> params);

    int saveLiteMallCart(LiteMallCartEntity liteMallCart);

    LiteMallCartEntity getLiteMallCartById(Long id);

    int updateLiteMallCart(LiteMallCartEntity liteMallCart);

    int batchRemove(Long[] id);

    List<LiteMallCartEntity> queryByUserId(Integer userId);

    LiteMallCartEntity queryExist(Integer goodsId, Integer productId, Integer userId);

    List<LiteMallCartEntity> queryByUserIdAndChecked(Integer userId);

    void updateCheck(Integer userId, List<Integer> productIds, Boolean isChecked);

    void delete(List<Integer> productIds, Integer userId);
}
