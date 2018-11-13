package com.kotall.rms.core.manager.litemall.impl;

import java.util.List;

import com.kotall.rms.core.manager.litemall.LiteMallFootprintManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Query;
import com.kotall.rms.common.dao.litemall.LiteMallFootprintMapper;
import com.kotall.rms.common.entity.litemall.LiteMallFootprintEntity;

/**
 * 用户浏览足迹表
 *
 * @author kotall
 * @date 2018年11月13日 下午2:10:19
 * @since 1.0.0
 */
@Component("liteMallFootprintManager")
public class LiteMallFootprintManagerImpl implements LiteMallFootprintManager {

	@Autowired
	private LiteMallFootprintMapper liteMallFootprintMapper;
	

	@Override
	public List<LiteMallFootprintEntity> listLiteMallFootprint(Page<LiteMallFootprintEntity> page, Query search) {
		return liteMallFootprintMapper.listForPage(page, search);
	}

	@Override
	public int saveLiteMallFootprint(LiteMallFootprintEntity liteMallFootprint) {
		return liteMallFootprintMapper.save(liteMallFootprint);
	}

	@Override
	public LiteMallFootprintEntity getLiteMallFootprintById(Long id) {
		LiteMallFootprintEntity liteMallFootprint = liteMallFootprintMapper.getObjectById(id);
		return liteMallFootprint;
	}

	@Override
	public int updateLiteMallFootprint(LiteMallFootprintEntity liteMallFootprint) {
		return liteMallFootprintMapper.update(liteMallFootprint);
	}

	@Override
	public int batchRemove(Long[] id) {
		int count = liteMallFootprintMapper.batchRemove(id);
		return count;
	}
	
}
