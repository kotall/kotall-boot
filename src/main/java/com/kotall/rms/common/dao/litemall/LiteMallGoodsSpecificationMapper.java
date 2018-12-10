package com.kotall.rms.common.dao.litemall;

import org.apache.ibatis.annotations.Mapper;

import com.kotall.rms.common.entity.litemall.LiteMallGoodsSpecificationEntity;
import com.kotall.rms.common.dao.BaseMapper;

import java.util.List;

/**
 * 商品规格表
 *
 * @author kotall
 * @date 2018年11月20日 下午7:50:58
 * @since 1.0.0
 */
@Mapper
public interface LiteMallGoodsSpecificationMapper extends BaseMapper<LiteMallGoodsSpecificationEntity> {

    void insertBatch(List<LiteMallGoodsSpecificationEntity> liteMallGoodsSpecifications);
}
