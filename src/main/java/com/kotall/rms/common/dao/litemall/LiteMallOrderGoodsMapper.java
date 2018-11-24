package com.kotall.rms.common.dao.litemall;

import org.apache.ibatis.annotations.Mapper;

import com.kotall.rms.common.entity.litemall.LiteMallOrderGoodsEntity;
import com.kotall.rms.common.dao.BaseMapper;

/**
 * 订单商品表
 *
 * @author kotall
 * @date 2018年11月13日 下午4:45:21
 * @since 1.0.0
 */
@Mapper
public interface LiteMallOrderGoodsMapper extends BaseMapper<LiteMallOrderGoodsEntity> {
	
}
