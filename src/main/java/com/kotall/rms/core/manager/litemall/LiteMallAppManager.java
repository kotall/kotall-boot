package com.kotall.rms.core.manager.litemall;

import java.util.List;

import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Query;
import com.kotall.rms.common.entity.litemall.LiteMallAppEntity;

/**
 * app配置表
 *
 * @author kotall
 * @date 2018年11月19日 上午10:17:16
 * @since 1.0.0
 */
public interface LiteMallAppManager {

	List<LiteMallAppEntity> listLiteMallApp(Page<LiteMallAppEntity> page, Query search);
	
	int saveLiteMallApp(LiteMallAppEntity liteMallApp);
	
	LiteMallAppEntity getLiteMallAppById(Long id);
	
	int updateLiteMallApp(LiteMallAppEntity liteMallApp);
	
	int batchRemove(Long[] id);

    LiteMallAppEntity getLiteMallAppByAppId(String appId);
}
