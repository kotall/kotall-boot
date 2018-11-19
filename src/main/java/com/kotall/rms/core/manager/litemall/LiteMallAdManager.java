package com.kotall.rms.core.manager.litemall;

import java.util.List;
import java.util.Map;

import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Query;
import com.kotall.rms.common.entity.litemall.LiteMallAdEntity;

/**
 * 广告表
 *
 * @author kotall
 * @date 2018年11月13日 下午6:08:21
 * @since 1.0.0
 */
public interface LiteMallAdManager {

	List<LiteMallAdEntity> listLiteMallAd(Page<LiteMallAdEntity> page, Query search);
	
	int saveLiteMallAd(LiteMallAdEntity liteMallAd);
	
	LiteMallAdEntity getLiteMallAdById(Long id);
	
	int updateLiteMallAd(LiteMallAdEntity liteMallAd);
	
	int batchRemove(Long[] id);

	List<LiteMallAdEntity> queryAdList(Query search);
}
