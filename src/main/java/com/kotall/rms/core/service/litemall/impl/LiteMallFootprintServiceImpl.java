package com.kotall.rms.core.service.litemall.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kotall.rms.common.utils.Query;
import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.entity.litemall.LiteMallFootprintEntity;
import com.kotall.rms.core.manager.litemall.LiteMallFootprintManager;
import com.kotall.rms.core.service.litemall.LiteMallFootprintService;

/**
 * 用户浏览足迹表
 *
 * @author kotall
 * @date 2018年11月13日 下午2:10:19
 * @since 1.0.0
 */
@Service("liteMallFootprintService")
public class LiteMallFootprintServiceImpl implements LiteMallFootprintService {

	@Autowired
	private LiteMallFootprintManager liteMallFootprintManager;

	@Override
	public Page<LiteMallFootprintEntity> listLiteMallFootprint(Map<String, Object> params) {
		Query query = new Query(params);
		Page<LiteMallFootprintEntity> page = new Page<>(query);
		liteMallFootprintManager.listLiteMallFootprint(page, query);
		return page;
	}

	@Override
	public int saveLiteMallFootprint(LiteMallFootprintEntity role) {
		int count = liteMallFootprintManager.saveLiteMallFootprint(role);
		return count;
	}

	@Override
	public LiteMallFootprintEntity getLiteMallFootprintById(Long id) {
		LiteMallFootprintEntity liteMallFootprint = liteMallFootprintManager.getLiteMallFootprintById(id);
		return liteMallFootprint;
	}

	@Override
	public int updateLiteMallFootprint(LiteMallFootprintEntity liteMallFootprint) {
		int count = liteMallFootprintManager.updateLiteMallFootprint(liteMallFootprint);
		return count;
	}

	@Override
	public int batchRemove(Long[] id) {
		int count = liteMallFootprintManager.batchRemove(id);
		return count;
	}

}
