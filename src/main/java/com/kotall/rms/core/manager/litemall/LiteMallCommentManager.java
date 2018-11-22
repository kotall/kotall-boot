package com.kotall.rms.core.manager.litemall;

import java.util.List;

import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Query;
import com.kotall.rms.common.entity.litemall.LiteMallCommentEntity;

/**
 * 评论表
 *
 * @author kotall
 * @date 2018年11月13日 下午4:55:35
 * @since 1.0.0
 */
public interface LiteMallCommentManager {

	List<LiteMallCommentEntity> listLiteMallComment(Page<LiteMallCommentEntity> page, Query search);
	
	int saveLiteMallComment(LiteMallCommentEntity liteMallComment);
	
	LiteMallCommentEntity getLiteMallCommentById(Long id);
	
	int updateLiteMallComment(LiteMallCommentEntity liteMallComment);
	
	int batchRemove(Long[] id);

    int countComment(Query query);

    List<LiteMallCommentEntity> queryCommentList(Query query);
}
