package com.kotall.rms.core.manager.litemall.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Query;
import com.kotall.rms.common.dao.litemall.LiteMallIssueMapper;
import com.kotall.rms.common.entity.litemall.LiteMallIssueEntity;
import com.kotall.rms.core.manager.litemall.LiteMallIssueManager;

/**
 * 常见问题表
 *
 * @author kotall
 * @date 2018年11月13日 下午4:29:37
 * @since 1.0.0
 */
@Component("liteMallIssueManager")
public class LiteMallIssueManagerImpl implements LiteMallIssueManager {

	@Autowired
	private LiteMallIssueMapper liteMallIssueMapper;
	

	@Override
	public List<LiteMallIssueEntity> listLiteMallIssue(Page<LiteMallIssueEntity> page, Query search) {
		return liteMallIssueMapper.listForPage(page, search);
	}

	@Override
	public int saveLiteMallIssue(LiteMallIssueEntity liteMallIssue) {
		return liteMallIssueMapper.save(liteMallIssue);
	}

	@Override
	public LiteMallIssueEntity getLiteMallIssueById(Long id) {
		LiteMallIssueEntity liteMallIssue = liteMallIssueMapper.getObjectById(id);
		return liteMallIssue;
	}

	@Override
	public int updateLiteMallIssue(LiteMallIssueEntity liteMallIssue) {
		return liteMallIssueMapper.update(liteMallIssue);
	}

	@Override
	public int batchRemove(Long[] id) {
		int count = liteMallIssueMapper.batchRemove(id);
		return count;
	}
	
}
