package com.kotall.rms.common.dao.litemall;

import com.kotall.rms.common.utils.Query;
import org.apache.ibatis.annotations.Mapper;

import com.kotall.rms.common.entity.litemall.LiteMallGoodsEntity;
import com.kotall.rms.common.dao.BaseMapper;

import java.util.List;

/**
 * 商品基本信息表
 *
 * @author kotall
 * @date 2018年11月19日 下午3:03:30
 * @since 1.0.0
 */
@Mapper
public interface LiteMallGoodsMapper extends BaseMapper<LiteMallGoodsEntity> {

    List<Integer> queryCategoryIds(Query query);
}
