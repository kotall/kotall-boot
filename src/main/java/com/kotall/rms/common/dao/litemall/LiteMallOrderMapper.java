package com.kotall.rms.common.dao.litemall;

import org.apache.ibatis.annotations.Mapper;

import com.kotall.rms.common.entity.litemall.LiteMallOrderEntity;
import com.kotall.rms.common.dao.sys.BaseMapper;

/**
 * 订单表
 *
 * @author kotall
 * @date 2018年11月13日 下午4:22:38
 * @since 1.0.0
 */
@Mapper
public interface LiteMallOrderMapper extends BaseMapper<LiteMallOrderEntity> {
	
}
