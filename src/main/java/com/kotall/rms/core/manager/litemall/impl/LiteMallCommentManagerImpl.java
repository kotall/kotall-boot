package com.kotall.rms.core.manager.litemall.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Query;
import com.kotall.rms.common.dao.litemall.LiteMallCommentMapper;
import com.kotall.rms.common.entity.litemall.LiteMallCommentEntity;
import com.kotall.rms.core.manager.litemall.LiteMallCommentManager;

/**
 * 评论表
 *
 * @author kotall
 * @date 2018年11月13日 下午4:55:35
 * @since 1.0.0
 */
@Component("liteMallCommentManager")
public class LiteMallCommentManagerImpl implements LiteMallCommentManager {

	@Autowired
	private LiteMallCommentMapper liteMallCommentMapper;
	

	@Override
	public List<LiteMallCommentEntity> listLiteMallComment(Page<LiteMallCommentEntity> page, Query search) {
		return liteMallCommentMapper.listForPage(page, search);
	}

	@Override
	public int saveLiteMallComment(LiteMallCommentEntity liteMallComment) {
		return liteMallCommentMapper.save(liteMallComment);
	}

	@Override
	public LiteMallCommentEntity getLiteMallCommentById(Long id) {
		LiteMallCommentEntity liteMallComment = liteMallCommentMapper.getObjectById(id);
		return liteMallComment;
	}

	@Override
	public int updateLiteMallComment(LiteMallCommentEntity liteMallComment) {
		return liteMallCommentMapper.update(liteMallComment);
	}

	@Override
	public int batchRemove(Long[] id) {
		int count = liteMallCommentMapper.batchRemove(id);
		return count;
	}

	@Override
	public int countComment(Query query) {
		return this.liteMallCommentMapper.countTotal(query);
	}
}
