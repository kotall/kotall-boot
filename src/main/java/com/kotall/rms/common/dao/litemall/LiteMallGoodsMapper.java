package com.kotall.rms.common.dao.litemall;

import org.apache.ibatis.annotations.Mapper;

import com.kotall.rms.common.entity.litemall.LiteMallGoodsEntity;
import com.kotall.rms.common.dao.sys.BaseMapper;

/**
 * 商品基本信息表
 *
 * @author kotall
 * @date 2018年11月19日 下午3:03:30
 * @since 1.0.0
 */
@Mapper
public interface LiteMallGoodsMapper extends BaseMapper<LiteMallGoodsEntity> {
	
}
