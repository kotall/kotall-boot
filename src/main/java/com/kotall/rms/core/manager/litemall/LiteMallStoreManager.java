package com.kotall.rms.core.manager.litemall;

import java.util.List;

import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Query;
import com.kotall.rms.common.entity.litemall.LiteMallStoreEntity;

/**
 * 店铺表 
 *
 * @author kotall
 * @date 2018年11月14日 下午6:05:16
 * @since 1.0.0
 */
public interface LiteMallStoreManager {

	List<LiteMallStoreEntity> listLiteMallStore(Page<LiteMallStoreEntity> page, Query search);
	
	int saveLiteMallStore(LiteMallStoreEntity liteMallStore);
	
	LiteMallStoreEntity getLiteMallStoreById(Long id);
	
	int updateLiteMallStore(LiteMallStoreEntity liteMallStore);
	
	int batchRemove(Long[] id);

    List<Integer> queryStoreIdListByUserId(Integer userId);
}
