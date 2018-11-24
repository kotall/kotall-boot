package com.kotall.rms.core.manager.litemall.impl;

import com.kotall.rms.common.dao.litemall.LiteMallFeedbackMapper;
import com.kotall.rms.common.entity.litemall.LiteMallFeedbackEntity;
import com.kotall.rms.core.manager.BaseManagerImpl;
import com.kotall.rms.core.manager.litemall.LiteMallFeedbackManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 意见反馈表
 *
 * @author kotall
 * @date 2018年11月13日 下午2:33:08
 * @since 1.0.0
 */
@Component("liteMallFeedbackManager")
public class LiteMallFeedbackManagerImpl extends BaseManagerImpl<LiteMallFeedbackMapper, LiteMallFeedbackEntity> implements LiteMallFeedbackManager {

	@Autowired
	private LiteMallFeedbackMapper liteMallFeedbackMapper;
	
}
