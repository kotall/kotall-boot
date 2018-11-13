package com.kotall.rms.core.service.litemall;

import java.util.Map;

import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Result;
import com.kotall.rms.common.entity.litemall.LiteMallGrouponEntity;

/**
 * 
 *
 * @author kotall
 * @date 2018年11月13日 下午6:32:18
 * @since 1.0.0
 */
public interface LiteMallGrouponService {

	Page<LiteMallGrouponEntity> listLiteMallGroupon(Map<String, Object> params);

    int saveLiteMallGroupon(LiteMallGrouponEntity liteMallGroupon);

    LiteMallGrouponEntity getLiteMallGrouponById(Long id);

    int updateLiteMallGroupon(LiteMallGrouponEntity liteMallGroupon);

    int batchRemove(Long[] id);
	
}
