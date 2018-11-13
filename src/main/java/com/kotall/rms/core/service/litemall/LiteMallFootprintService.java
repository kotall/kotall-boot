package com.kotall.rms.core.service.litemall;

import java.util.Map;

import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Result;
import com.kotall.rms.common.entity.litemall.LiteMallFootprintEntity;

/**
 * 用户浏览足迹表
 *
 * @author kotall
 * @date 2018年11月13日 下午2:10:19
 * @since 1.0.0
 */
public interface LiteMallFootprintService {

	Page<LiteMallFootprintEntity> listLiteMallFootprint(Map<String, Object> params);

    int saveLiteMallFootprint(LiteMallFootprintEntity liteMallFootprint);

    LiteMallFootprintEntity getLiteMallFootprintById(Long id);

    int updateLiteMallFootprint(LiteMallFootprintEntity liteMallFootprint);

    int batchRemove(Long[] id);
	
}
