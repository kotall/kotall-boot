package com.kotall.rms.core.service.litemall;

import com.kotall.rms.common.entity.litemall.LiteMallStoreEntity;
import com.kotall.rms.common.utils.Page;
import com.kotall.rms.core.service.BaseService;

import java.util.List;
import java.util.Map;

/**
 * 店铺表 
 *
 * @author kotall
 * @date 2018年11月14日 下午6:05:16
 * @since 1.0.0
 */
public interface LiteMallStoreService extends BaseService<LiteMallStoreEntity> {

	Page<LiteMallStoreEntity> queryStoreByPage(Map<String, Object> params);

    /**
     * 查询用户拥有的店铺ID 列表
     * @param userId
     * @return
     */
    List<Integer> queryStoreIdListByUserId(Integer userId);
}
