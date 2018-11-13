package com.kotall.rms.core.service.litemall;

import java.util.Map;

import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Result;
import com.kotall.rms.common.entity.litemall.LiteMallIssueEntity;

/**
 * 常见问题表
 *
 * @author kotall
 * @date 2018年11月13日 下午4:29:37
 * @since 1.0.0
 */
public interface LiteMallIssueService {

	Page<LiteMallIssueEntity> listLiteMallIssue(Map<String, Object> params);

    int saveLiteMallIssue(LiteMallIssueEntity liteMallIssue);

    LiteMallIssueEntity getLiteMallIssueById(Long id);

    int updateLiteMallIssue(LiteMallIssueEntity liteMallIssue);

    int batchRemove(Long[] id);
	
}
