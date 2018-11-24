package com.kotall.rms.core.manager.litemall.impl;

import com.kotall.rms.common.dao.litemall.LiteMallTopicMapper;
import com.kotall.rms.common.entity.litemall.LiteMallTopicEntity;
import com.kotall.rms.core.manager.BaseManagerImpl;
import com.kotall.rms.core.manager.litemall.LiteMallTopicManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 专题表
 *
 * @author kotall
 * @date 2018年11月13日 下午6:17:39
 * @since 1.0.0
 */
@Component("liteMallTopicManager")
public class LiteMallTopicManagerImpl extends BaseManagerImpl<LiteMallTopicMapper, LiteMallTopicEntity> implements LiteMallTopicManager {

	@Autowired
	private LiteMallTopicMapper liteMallTopicMapper;
	
}
