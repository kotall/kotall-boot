package com.kotall.rms.common.dao.litemall;

import org.apache.ibatis.annotations.Mapper;

import com.kotall.rms.common.entity.litemall.LiteMallUserEntity;
import com.kotall.rms.common.dao.BaseMapper;

/**
 * 用户表
 *
 * @author kotall
 * @date 2018年11月13日 上午10:18:32
 * @since 1.0.0
 */
@Mapper
public interface LiteMallUserMapper extends BaseMapper<LiteMallUserEntity> {
	
}
