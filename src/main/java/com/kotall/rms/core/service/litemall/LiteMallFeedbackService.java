package com.kotall.rms.core.service.litemall;

import com.kotall.rms.common.entity.litemall.LiteMallFeedbackEntity;
import com.kotall.rms.common.utils.Page;
import com.kotall.rms.core.service.BaseService;

import java.util.Map;

/**
 * 意见反馈表
 *
 * @author kotall
 * @date 2018年11月13日 下午2:33:08
 * @since 1.0.0
 */
public interface LiteMallFeedbackService extends BaseService<LiteMallFeedbackEntity> {

    Page<LiteMallFeedbackEntity> queryFeedbackByPage(Map<String, Object> params);
}
