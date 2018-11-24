package com.kotall.rms.common.dao.litemall;

import com.kotall.rms.common.utils.Query;
import org.apache.ibatis.annotations.Mapper;

import com.kotall.rms.common.entity.litemall.LiteMallAddressEntity;
import com.kotall.rms.common.dao.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 收货地址表
 *
 * @author kotall
 * @date 2018年11月13日 上午11:28:53
 * @since 1.0.0
 */
@Mapper
public interface LiteMallAddressMapper extends BaseMapper<LiteMallAddressEntity> {

    List<LiteMallAddressEntity> getByUserId(Integer userId);

    void resetDefault(@Param("address") LiteMallAddressEntity address, @Param("query") Query query);
}
