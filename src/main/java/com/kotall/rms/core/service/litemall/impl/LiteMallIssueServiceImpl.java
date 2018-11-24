package com.kotall.rms.core.service.litemall.impl;

import com.kotall.rms.common.entity.litemall.LiteMallIssueEntity;
import com.kotall.rms.common.utils.Page;
import com.kotall.rms.core.annotation.StoreFilter;
import com.kotall.rms.core.manager.litemall.LiteMallIssueManager;
import com.kotall.rms.core.service.BaseServiceImpl;
import com.kotall.rms.core.service.litemall.LiteMallIssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 常见问题表
 *
 * @author kotall
 * @date 2018年11月13日 下午4:29:37
 * @since 1.0.0
 */
@Service("liteMallIssueService")
public class LiteMallIssueServiceImpl extends BaseServiceImpl<LiteMallIssueManager, LiteMallIssueEntity> implements LiteMallIssueService {

	@Autowired
	private LiteMallIssueManager liteMallIssueManager;

	@StoreFilter
	@Override
	public Page<LiteMallIssueEntity> queryIssueByPage(Map<String, Object> params) {
		return super.queryByPage(params);
	}
}
