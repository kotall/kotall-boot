package com.kotall.rms.core.service.litemall.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kotall.rms.common.utils.Query;
import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.entity.litemall.LiteMallIssueEntity;
import com.kotall.rms.core.manager.litemall.LiteMallIssueManager;
import com.kotall.rms.core.service.litemall.LiteMallIssueService;

/**
 * 常见问题表
 *
 * @author kotall
 * @date 2018年11月13日 下午4:29:37
 * @since 1.0.0
 */
@Service("liteMallIssueService")
public class LiteMallIssueServiceImpl implements LiteMallIssueService {

	@Autowired
	private LiteMallIssueManager liteMallIssueManager;

	@Override
	public Page<LiteMallIssueEntity> listLiteMallIssue(Map<String, Object> params) {
		Query query = new Query(params);
		Page<LiteMallIssueEntity> page = new Page<>(query);
		liteMallIssueManager.listLiteMallIssue(page, query);
		return page;
	}

	@Override
	public int saveLiteMallIssue(LiteMallIssueEntity role) {
		int count = liteMallIssueManager.saveLiteMallIssue(role);
		return count;
	}

	@Override
	public LiteMallIssueEntity getLiteMallIssueById(Long id) {
		LiteMallIssueEntity liteMallIssue = liteMallIssueManager.getLiteMallIssueById(id);
		return liteMallIssue;
	}

	@Override
	public int updateLiteMallIssue(LiteMallIssueEntity liteMallIssue) {
		int count = liteMallIssueManager.updateLiteMallIssue(liteMallIssue);
		return count;
	}

	@Override
	public int batchRemove(Long[] id) {
		int count = liteMallIssueManager.batchRemove(id);
		return count;
	}

}
