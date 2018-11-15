package com.kotall.rms.core.service.litemall;

import java.util.Map;

import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Result;
import com.kotall.rms.common.entity.litemall.LiteMallStoreEntity;

/**
 * 店铺表 
 *
 * @author kotall
 * @date 2018年11月14日 下午6:05:16
 * @since 1.0.0
 */
public interface LiteMallStoreService {

	Page<LiteMallStoreEntity> listLiteMallStore(Map<String, Object> params);

    int saveLiteMallStore(LiteMallStoreEntity liteMallStore);

    LiteMallStoreEntity getLiteMallStoreById(Long id);

    int updateLiteMallStore(LiteMallStoreEntity liteMallStore);

    int batchRemove(Long[] id);
	
}
