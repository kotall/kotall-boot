package com.kotall.rms.core.manager.litemall.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Query;
import com.kotall.rms.common.dao.litemall.LiteMallFeedbackMapper;
import com.kotall.rms.common.entity.litemall.LiteMallFeedbackEntity;
import com.kotall.rms.core.manager.litemall.LiteMallFeedbackManager;

/**
 * 意见反馈表
 *
 * @author kotall
 * @date 2018年11月13日 下午2:33:08
 * @since 1.0.0
 */
@Component("liteMallFeedbackManager")
public class LiteMallFeedbackManagerImpl implements LiteMallFeedbackManager {

	@Autowired
	private LiteMallFeedbackMapper liteMallFeedbackMapper;
	

	@Override
	public List<LiteMallFeedbackEntity> listLiteMallFeedback(Page<LiteMallFeedbackEntity> page, Query search) {
		return liteMallFeedbackMapper.listForPage(page, search);
	}

	@Override
	public int saveLiteMallFeedback(LiteMallFeedbackEntity liteMallFeedback) {
		return liteMallFeedbackMapper.save(liteMallFeedback);
	}

	@Override
	public LiteMallFeedbackEntity getLiteMallFeedbackById(Long id) {
		LiteMallFeedbackEntity liteMallFeedback = liteMallFeedbackMapper.getObjectById(id);
		return liteMallFeedback;
	}

	@Override
	public int updateLiteMallFeedback(LiteMallFeedbackEntity liteMallFeedback) {
		return liteMallFeedbackMapper.update(liteMallFeedback);
	}

	@Override
	public int batchRemove(Long[] id) {
		int count = liteMallFeedbackMapper.batchRemove(id);
		return count;
	}
	
}
