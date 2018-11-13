package com.kotall.rms.core.service.litemall;

import java.util.Map;

import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Result;
import com.kotall.rms.common.entity.litemall.LiteMallFeedbackEntity;

/**
 * 意见反馈表
 *
 * @author kotall
 * @date 2018年11月13日 下午2:33:08
 * @since 1.0.0
 */
public interface LiteMallFeedbackService {

	Page<LiteMallFeedbackEntity> listLiteMallFeedback(Map<String, Object> params);

    int saveLiteMallFeedback(LiteMallFeedbackEntity liteMallFeedback);

    LiteMallFeedbackEntity getLiteMallFeedbackById(Long id);

    int updateLiteMallFeedback(LiteMallFeedbackEntity liteMallFeedback);

    int batchRemove(Long[] id);
	
}
