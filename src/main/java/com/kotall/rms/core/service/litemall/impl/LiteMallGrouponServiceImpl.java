package com.kotall.rms.core.service.litemall.impl;

import java.util.Map;

import com.kotall.rms.core.annotation.StoreFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kotall.rms.common.utils.Query;
import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.entity.litemall.LiteMallGrouponEntity;
import com.kotall.rms.core.manager.litemall.LiteMallGrouponManager;
import com.kotall.rms.core.service.litemall.LiteMallGrouponService;

/**
 * 
 *
 * @author kotall
 * @date 2018年11月13日 下午6:32:18
 * @since 1.0.0
 */
@Service("liteMallGrouponService")
public class LiteMallGrouponServiceImpl implements LiteMallGrouponService {

	@Autowired
	private LiteMallGrouponManager liteMallGrouponManager;

	@StoreFilter
	@Override
	public Page<LiteMallGrouponEntity> listLiteMallGroupon(Map<String, Object> params) {
		Query query = new Query(params);
		Page<LiteMallGrouponEntity> page = new Page<>(query);
		liteMallGrouponManager.listLiteMallGroupon(page, query);
		return page;
	}

	@Override
	public int saveLiteMallGroupon(LiteMallGrouponEntity role) {
		int count = liteMallGrouponManager.saveLiteMallGroupon(role);
		return count;
	}

	@Override
	public LiteMallGrouponEntity getLiteMallGrouponById(Long id) {
		LiteMallGrouponEntity liteMallGroupon = liteMallGrouponManager.getLiteMallGrouponById(id);
		return liteMallGroupon;
	}

	@Override
	public int updateLiteMallGroupon(LiteMallGrouponEntity liteMallGroupon) {
		int count = liteMallGrouponManager.updateLiteMallGroupon(liteMallGroupon);
		return count;
	}

	@Override
	public int batchRemove(Long[] id) {
		int count = liteMallGrouponManager.batchRemove(id);
		return count;
	}

}
