package com.kotall.rms.common.dao.litemall;

import org.apache.ibatis.annotations.Mapper;

import com.kotall.rms.common.entity.litemall.LiteMallGoodsAttributeEntity;
import com.kotall.rms.common.dao.BaseMapper;

import java.util.List;

/**
 * 商品参数表
 *
 * @author kotall
 * @date 2018年11月20日 下午7:51:23
 * @since 1.0.0
 */
@Mapper
public interface LiteMallGoodsAttributeMapper extends BaseMapper<LiteMallGoodsAttributeEntity> {

    void insertBatch(List<LiteMallGoodsAttributeEntity> liteMallGoodsAttributes);

    List<LiteMallGoodsAttributeEntity> getByGoodsId(String goodsId);
}
