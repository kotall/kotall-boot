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

	Page<LiteMallAddressEntity> listLiteMallAddress(Map<String, Object> params);

	List<LiteMallAddressEntity> queryAddressList(Map<String, Object> params);

    int saveLiteMallAddress(LiteMallAddressEntity liteMallAddress);

    LiteMallAddressEntity getLiteMallAddressById(Integer id);

    int updateLiteMallAddress(LiteMallAddressEntity liteMallAddress);

    int batchRemove(Long[] id);

    /**
     * 根据用户ID查询地址信息
     * @param userId
     * @return
     */
    List<LiteMallAddressEntity> queryByUid(Integer userId);

    void resetDefault(Integer userId);

    LiteMallAddressEntity findDefault(Integer userId);
}
