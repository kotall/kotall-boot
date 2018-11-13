package com.kotall.rms.core.service.litemall;

import java.util.Map;

import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Result;
import com.kotall.rms.common.entity.litemall.LiteMallCollectEntity;

/**
 * 收藏表
 *
 * @author kotall
 * @date 2018年11月13日 上午11:41:28
 * @since 1.0.0
 */
public interface LiteMallCollectService {

	Page<LiteMallCollectEntity> listLiteMallCollect(Map<String, Object> params);

    int saveLiteMallCollect(LiteMallCollectEntity liteMallCollect);

    LiteMallCollectEntity getLiteMallCollectById(Long id);

    int updateLiteMallCollect(LiteMallCollectEntity liteMallCollect);

    int batchRemove(Long[] id);
	
}
