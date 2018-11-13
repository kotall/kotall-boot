package com.kotall.rms.core.manager.litemall.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Query;
import com.kotall.rms.common.dao.litemall.LiteMallGrouponMapper;
import com.kotall.rms.common.entity.litemall.LiteMallGrouponEntity;
import com.kotall.rms.core.manager.litemall.LiteMallGrouponManager;

/**
 * 
 *
 * @author kotall
 * @date 2018年11月13日 下午6:32:18
 * @since 1.0.0
 */
@Component("liteMallGrouponManager")
public class LiteMallGrouponManagerImpl implements LiteMallGrouponManager {

	@Autowired
	private LiteMallGrouponMapper liteMallGrouponMapper;
	

	@Override
	public List<LiteMallGrouponEntity> listLiteMallGroupon(Page<LiteMallGrouponEntity> page, Query search) {
		return liteMallGrouponMapper.listForPage(page, search);
	}

	@Override
	public int saveLiteMallGroupon(LiteMallGrouponEntity liteMallGroupon) {
		return liteMallGrouponMapper.save(liteMallGroupon);
	}

	@Override
	public LiteMallGrouponEntity getLiteMallGrouponById(Long id) {
		LiteMallGrouponEntity liteMallGroupon = liteMallGrouponMapper.getObjectById(id);
		return liteMallGroupon;
	}

	@Override
	public int updateLiteMallGroupon(LiteMallGrouponEntity liteMallGroupon) {
		return liteMallGrouponMapper.update(liteMallGroupon);
	}

	@Override
	public int batchRemove(Long[] id) {
		int count = liteMallGrouponMapper.batchRemove(id);
		return count;
	}
	
}
