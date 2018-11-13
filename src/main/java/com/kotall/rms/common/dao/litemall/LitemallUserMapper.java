package com.kotall.rms.common.dao.litemall;

import org.apache.ibatis.annotations.Mapper;

import com.kotall.rms.common.entity.litemall.LitemallUserEntity;
import com.kotall.rms.common.dao.sys.BaseMapper;

/**
 * 用户表
 *
 * @author kotall
 * @date 2018年11月13日 上午9:47:19
 * @since 1.0.0
 */
@Mapper
public interface LitemallUserMapper extends BaseMapper<LitemallUserEntity> {
	
}
