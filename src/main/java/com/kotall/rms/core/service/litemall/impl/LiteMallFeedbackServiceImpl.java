package com.kotall.rms.core.service.litemall.impl;

import java.util.Map;

import com.kotall.rms.core.annotation.StoreFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kotall.rms.common.utils.Query;
import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.entity.litemall.LiteMallFeedbackEntity;
import com.kotall.rms.core.manager.litemall.LiteMallFeedbackManager;
import com.kotall.rms.core.service.litemall.LiteMallFeedbackService;

/**
 * 意见反馈表
 *
 * @author kotall
 * @date 2018年11月13日 下午2:33:08
 * @since 1.0.0
 */
@Service("liteMallFeedbackService")
public class LiteMallFeedbackServiceImpl implements LiteMallFeedbackService {

	@Autowired
	private LiteMallFeedbackManager liteMallFeedbackManager;

	@StoreFilter
	@Override
	public Page<LiteMallFeedbackEntity> listLiteMallFeedback(Map<String, Object> params) {
		Query query = new Query(params);
		Page<LiteMallFeedbackEntity> page = new Page<>(query);
		liteMallFeedbackManager.listLiteMallFeedback(page, query);
		return page;
	}

	@Override
	public int saveLiteMallFeedback(LiteMallFeedbackEntity role) {
		int count = liteMallFeedbackManager.saveLiteMallFeedback(role);
		return count;
	}

	@Override
	public LiteMallFeedbackEntity getLiteMallFeedbackById(Long id) {
		LiteMallFeedbackEntity liteMallFeedback = liteMallFeedbackManager.getLiteMallFeedbackById(id);
		return liteMallFeedback;
	}

	@Override
	public int updateLiteMallFeedback(LiteMallFeedbackEntity liteMallFeedback) {
		int count = liteMallFeedbackManager.updateLiteMallFeedback(liteMallFeedback);
		return count;
	}

	@Override
	public int batchRemove(Long[] id) {
		int count = liteMallFeedbackManager.batchRemove(id);
		return count;
	}

}
