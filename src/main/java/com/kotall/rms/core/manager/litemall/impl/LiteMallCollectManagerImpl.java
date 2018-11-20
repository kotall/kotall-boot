package com.kotall.rms.core.manager.litemall.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Query;
import com.kotall.rms.common.dao.litemall.LiteMallCollectMapper;
import com.kotall.rms.common.entity.litemall.LiteMallCollectEntity;
import com.kotall.rms.core.manager.litemall.LiteMallCollectManager;

/**
 * 收藏表
 *
 * @author kotall
 * @date 2018年11月13日 上午11:41:28
 * @since 1.0.0
 */
@Component("liteMallCollectManager")
public class LiteMallCollectManagerImpl implements LiteMallCollectManager {

	@Autowired
	private LiteMallCollectMapper liteMallCollectMapper;
	

	@Override
	public List<LiteMallCollectEntity> listLiteMallCollect(Page<LiteMallCollectEntity> page, Query search) {
		return liteMallCollectMapper.listForPage(page, search);
	}

	@Override
	public int saveLiteMallCollect(LiteMallCollectEntity liteMallCollect) {
		return liteMallCollectMapper.save(liteMallCollect);
	}

	@Override
	public LiteMallCollectEntity getLiteMallCollectById(Long id) {
		LiteMallCollectEntity liteMallCollect = liteMallCollectMapper.getObjectById(id);
		return liteMallCollect;
	}

	@Override
	public int updateLiteMallCollect(LiteMallCollectEntity liteMallCollect) {
		return liteMallCollectMapper.update(liteMallCollect);
	}

	@Override
	public int batchRemove(Long[] id) {
		int count = liteMallCollectMapper.batchRemove(id);
		return count;
	}

	@Override
	public List<LiteMallCollectEntity> queryCollectList(Query query) {
		return this.liteMallCollectMapper.list(query);
	}
}
