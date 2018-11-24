package com.kotall.rms.common.dao.litemall;

import org.apache.ibatis.annotations.Mapper;

import com.kotall.rms.common.entity.litemall.LiteMallStoreEntity;
import com.kotall.rms.common.dao.BaseMapper;

import java.util.List;

/**
 * 店铺表 
 *
 * @author kotall
 * @date 2018年11月14日 下午6:05:16
 * @since 1.0.0
 */
@Mapper
public interface LiteMallStoreMapper extends BaseMapper<LiteMallStoreEntity> {

    List<Integer> queryStoreIdListByUserId(Integer userId);

}
