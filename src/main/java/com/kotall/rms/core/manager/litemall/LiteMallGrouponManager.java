package com.kotall.rms.core.manager.litemall;

import java.util.List;

import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Query;
import com.kotall.rms.common.entity.litemall.LiteMallGrouponEntity;

/**
 * 
 *
 * @author kotall
 * @date 2018年11月13日 下午6:32:18
 * @since 1.0.0
 */
public interface LiteMallGrouponManager {

	List<LiteMallGrouponEntity> listLiteMallGroupon(Page<LiteMallGrouponEntity> page, Query search);
	
	int saveLiteMallGroupon(LiteMallGrouponEntity liteMallGroupon);
	
	LiteMallGrouponEntity getLiteMallGrouponById(Long id);
	
	int updateLiteMallGroupon(LiteMallGrouponEntity liteMallGroupon);
	
	int batchRemove(Long[] id);

    List<LiteMallGrouponEntity> queryGroupOnList(Query query);

    int countGroupOn(Query query);
}
