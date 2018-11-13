package com.kotall.rms.core.manager.litemall;

import java.util.List;

import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Query;
import com.kotall.rms.common.entity.litemall.LiteMallFootprintEntity;

/**
 * 用户浏览足迹表
 *
 * @author kotall
 * @date 2018年11月13日 下午2:10:19
 * @since 1.0.0
 */
public interface LiteMallFootprintManager {

	List<LiteMallFootprintEntity> listLiteMallFootprint(Page<LiteMallFootprintEntity> page, Query search);
	
	int saveLiteMallFootprint(LiteMallFootprintEntity liteMallFootprint);
	
	LiteMallFootprintEntity getLiteMallFootprintById(Long id);
	
	int updateLiteMallFootprint(LiteMallFootprintEntity liteMallFootprint);
	
	int batchRemove(Long[] id);
	
}
