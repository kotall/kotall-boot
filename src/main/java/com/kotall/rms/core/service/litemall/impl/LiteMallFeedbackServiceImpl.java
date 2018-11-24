package com.kotall.rms.core.service.litemall.impl;

import com.kotall.rms.common.entity.litemall.LiteMallFeedbackEntity;
import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Query;
import com.kotall.rms.core.annotation.StoreFilter;
import com.kotall.rms.core.manager.litemall.LiteMallFeedbackManager;
import com.kotall.rms.core.service.BaseServiceImpl;
import com.kotall.rms.core.service.litemall.LiteMallFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 意见反馈表
 *
 * @author kotall
 * @date 2018年11月13日 下午2:33:08
 * @since 1.0.0
 */
@Service("liteMallFeedbackService")
public class LiteMallFeedbackServiceImpl extends BaseServiceImpl<LiteMallFeedbackManager, LiteMallFeedbackEntity> implements LiteMallFeedbackService {

	@Autowired
	private LiteMallFeedbackManager liteMallFeedbackManager;

	@StoreFilter
	@Override
	public Page<LiteMallFeedbackEntity> queryFeedbackByPage(Map<String, Object> params) {
		return super.queryByPage(params);
	}
}
