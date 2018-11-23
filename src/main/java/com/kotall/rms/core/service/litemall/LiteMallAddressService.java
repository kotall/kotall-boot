package com.kotall.rms.core.service.litemall;

import java.util.List;
import java.util.Map;

import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.entity.litemall.LiteMallAddressEntity;

/**
 * 收货地址表
 *
 * @author kotall
 * @date 2018年11月13日 上午11:28:53
 * @since 1.0.0
 */
public interface LiteMallAddressService {

	Page<LiteMallAddressEntity> queryByPage(Map<String, Object> params);

	List<LiteMallAddressEntity> queryByList(Map<String, Object> params);

    int save(LiteMallAddressEntity liteMallAddress);

    LiteMallAddressEntity getById(Integer id);

    int update(LiteMallAddressEntity liteMallAddress);

    int deleteByIds(Integer[] id);

    /**
     * 根据用户ID查询地址信息
     * @param userId
     * @return
     */
    List<LiteMallAddressEntity> queryByUserId(Integer userId);

    void resetDefault(Integer userId);

    LiteMallAddressEntity getDefault(Integer userId);
}
