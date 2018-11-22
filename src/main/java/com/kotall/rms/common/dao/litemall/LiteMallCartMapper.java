package com.kotall.rms.common.dao.litemall;

import com.kotall.rms.common.utils.Query;
import org.apache.ibatis.annotations.Mapper;

import com.kotall.rms.common.entity.litemall.LiteMallCartEntity;
import com.kotall.rms.common.dao.sys.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * 购物车商品表
 *
 * @author kotall
 * @date 2018年11月20日 下午12:39:39
 * @since 1.0.0
 */
@Mapper
public interface LiteMallCartMapper extends BaseMapper<LiteMallCartEntity> {


    void updateCart(@Param("cart") LiteMallCartEntity cart, @Param("query") Query query);

    void deleteCartByCause(Query query);
}
