package com.kotall.rms.core.service.litemall;

import com.kotall.rms.common.entity.litemall.LiteMallCollectEntity;
import com.kotall.rms.common.utils.Page;
import com.kotall.rms.core.service.BaseService;

import java.util.Map;

/**
 * 收藏表
 *
 * @author kotall
 * @date 2018年11月13日 上午11:41:28
 * @since 1.0.0
 */
public interface LiteMallCollectService extends BaseService<LiteMallCollectEntity> {

    Page<LiteMallCollectEntity> queryByType(Map<String, Object> params);

    Page<LiteMallCollectEntity> queryCollectListByPage(Map<String, Object> params);

    LiteMallCollectEntity queryByTypeAndValue(Map<String, Object> params);

    int countUserCollect(Map<String, Object> params);
}
