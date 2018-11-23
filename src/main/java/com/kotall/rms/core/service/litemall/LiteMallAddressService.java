package com.kotall.rms.core.service.litemall;

import com.kotall.rms.common.entity.litemall.LiteMallAddressEntity;
import com.kotall.rms.core.service.BaseService;

import java.util.List;

/**
 * 收货地址表
 *
 * @author kotall
 * @date 2018年11月13日 上午11:28:53
 * @since 1.0.0
 */
public interface LiteMallAddressService extends BaseService<LiteMallAddressEntity> {

    /**
     * 根据用户ID查询地址信息
     * @param userId
     * @return
     */
    List<LiteMallAddressEntity> queryByUserId(Integer userId);

    void resetDefault(Integer userId);

    LiteMallAddressEntity getDefault(Integer userId);
}
