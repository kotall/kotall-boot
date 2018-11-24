package com.kotall.rms.core.service.litemall;

import com.kotall.rms.common.entity.litemall.LiteMallIssueEntity;
import com.kotall.rms.common.utils.Page;
import com.kotall.rms.core.service.BaseService;

import java.util.Map;

/**
 * 常见问题表
 *
 * @author kotall
 * @date 2018年11月13日 下午4:29:37
 * @since 1.0.0
 */
public interface LiteMallIssueService extends BaseService<LiteMallIssueEntity> {

    Page<LiteMallIssueEntity> queryIssueByPage(Map<String, Object> params);
}
