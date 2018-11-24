package com.kotall.rms.core.manager.litemall.impl;

import com.kotall.rms.common.dao.litemall.LiteMallCommentMapper;
import com.kotall.rms.common.entity.litemall.LiteMallCommentEntity;
import com.kotall.rms.common.utils.Query;
import com.kotall.rms.core.manager.BaseManagerImpl;
import com.kotall.rms.core.manager.litemall.LiteMallCommentManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 评论表
 *
 * @author kotall
 * @date 2018年11月13日 下午4:55:35
 * @since 1.0.0
 */
@Component("liteMallCommentManager")
public class LiteMallCommentManagerImpl extends BaseManagerImpl<LiteMallCommentMapper, LiteMallCommentEntity> implements LiteMallCommentManager {

	@Autowired
	private LiteMallCommentMapper liteMallCommentMapper;

	@Override
	public int countComment(Query query) {
		return this.liteMallCommentMapper.countTotal(query);
	}
}
