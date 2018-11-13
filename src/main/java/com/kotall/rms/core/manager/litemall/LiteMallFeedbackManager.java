package com.kotall.rms.core.manager.litemall;

import java.util.List;

import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Query;
import com.kotall.rms.common.entity.litemall.LiteMallFeedbackEntity;

/**
 * 意见反馈表
 *
 * @author kotall
 * @date 2018年11月13日 下午2:33:08
 * @since 1.0.0
 */
public interface LiteMallFeedbackManager {

	List<LiteMallFeedbackEntity> listLiteMallFeedback(Page<LiteMallFeedbackEntity> page, Query search);
	
	int saveLiteMallFeedback(LiteMallFeedbackEntity liteMallFeedback);
	
	LiteMallFeedbackEntity getLiteMallFeedbackById(Long id);
	
	int updateLiteMallFeedback(LiteMallFeedbackEntity liteMallFeedback);
	
	int batchRemove(Long[] id);
	
}
