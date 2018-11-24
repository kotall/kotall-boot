package com.kotall.rms.core.service.litemall;

import com.kotall.rms.common.entity.litemall.LiteMallCommentEntity;
import com.kotall.rms.common.utils.Page;
import com.kotall.rms.core.service.BaseService;

import java.util.Map;

/**
 * 评论表
 *
 * @author kotall
 * @date 2018年11月13日 下午4:55:35
 * @since 1.0.0
 */
public interface LiteMallCommentService extends BaseService<LiteMallCommentEntity> {

    int count(Integer storeId, int showType, int type, int valueId);

    Page<LiteMallCommentEntity> queryCommentByPage(Integer showType, Map<String, Object> params);

    Page<LiteMallCommentEntity> queryCommentByPage(Map<String, Object> params);
}
