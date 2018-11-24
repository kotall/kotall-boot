package com.kotall.rms.common.dao.litemall;

import org.apache.ibatis.annotations.Mapper;

import com.kotall.rms.common.entity.litemall.LiteMallCommentEntity;
import com.kotall.rms.common.dao.BaseMapper;

/**
 * 评论表
 *
 * @author kotall
 * @date 2018年11月13日 下午4:55:35
 * @since 1.0.0
 */
@Mapper
public interface LiteMallCommentMapper extends BaseMapper<LiteMallCommentEntity> {
	
}
