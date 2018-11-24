package com.kotall.rms.core.manager.litemall.impl;

import com.kotall.rms.common.dao.litemall.LiteMallIssueMapper;
import com.kotall.rms.common.entity.litemall.LiteMallIssueEntity;
import com.kotall.rms.core.manager.BaseManagerImpl;
import com.kotall.rms.core.manager.litemall.LiteMallIssueManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 常见问题表
 *
 * @author kotall
 * @date 2018年11月13日 下午4:29:37
 * @since 1.0.0
 */
@Component("liteMallIssueManager")
public class LiteMallIssueManagerImpl extends BaseManagerImpl<LiteMallIssueMapper, LiteMallIssueEntity> implements LiteMallIssueManager {

	@Autowired
	private LiteMallIssueMapper liteMallIssueMapper;
}
