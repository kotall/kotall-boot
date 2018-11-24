package com.kotall.rms.core.manager.litemall;

import com.kotall.rms.common.entity.litemall.LiteMallStoreEntity;
import com.kotall.rms.core.manager.BaseManager;

import java.util.List;

/**
 * 店铺表 
 *
 * @author kotall
 * @date 2018年11月14日 下午6:05:16
 * @since 1.0.0
 */
public interface LiteMallStoreManager extends BaseManager<LiteMallStoreEntity>{

    List<Integer> queryIdListByUserId(Integer userId);
}
