package com.kotall.rms.common.dao.litemall;

import org.apache.ibatis.annotations.Mapper;

import com.kotall.rms.common.entity.litemall.LiteMallAddressEntity;
import com.kotall.rms.common.dao.sys.BaseMapper;

/**
 * 收货地址表
 *
 * @author kotall
 * @date 2018年11月13日 上午11:28:53
 * @since 1.0.0
 */
@Mapper
public interface LiteMallAddressMapper extends BaseMapper<LiteMallAddressEntity> {
	
}
