package com.kotall.rms.core.manager.litemall;

import java.util.List;

import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Query;
import com.kotall.rms.common.entity.litemall.LiteMallIssueEntity;

/**
 * 常见问题表
 *
 * @author kotall
 * @date 2018年11月13日 下午4:29:37
 * @since 1.0.0
 */
public interface LiteMallIssueManager {

	List<LiteMallIssueEntity> listLiteMallIssue(Page<LiteMallIssueEntity> page, Query search);
	
	int saveLiteMallIssue(LiteMallIssueEntity liteMallIssue);
	
	LiteMallIssueEntity getLiteMallIssueById(Long id);
	
	int updateLiteMallIssue(LiteMallIssueEntity liteMallIssue);
	
	int batchRemove(Long[] id);

    List<LiteMallIssueEntity> queryIssueList(Query query);
}
