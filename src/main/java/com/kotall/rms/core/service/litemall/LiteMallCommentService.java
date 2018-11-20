package com.kotall.rms.core.service.litemall;

import java.util.Map;

import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Result;
import com.kotall.rms.common.entity.litemall.LiteMallCommentEntity;

/**
 * 评论表
 *
 * @author kotall
 * @date 2018年11月13日 下午4:55:35
 * @since 1.0.0
 */
public interface LiteMallCommentService {

	Page<LiteMallCommentEntity> listLiteMallComment(Map<String, Object> params);

    int saveLiteMallComment(LiteMallCommentEntity liteMallComment);

    LiteMallCommentEntity getLiteMallCommentById(Long id);

    int updateLiteMallComment(LiteMallCommentEntity liteMallComment);

    int batchRemove(Long[] id);

    int count(int showType, int type, int valueId);

    Page<LiteMallCommentEntity> queryCommentByPage(Integer showType, Map<String, Object> params);
}
