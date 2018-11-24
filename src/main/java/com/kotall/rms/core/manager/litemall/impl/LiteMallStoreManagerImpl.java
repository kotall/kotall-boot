package com.kotall.rms.core.manager.litemall.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Query;
import com.kotall.rms.common.dao.litemall.LiteMallStoreMapper;
import com.kotall.rms.common.entity.litemall.LiteMallStoreEntity;
import com.kotall.rms.core.manager.litemall.LiteMallStoreManager;

/**
 * 店铺表 
 *
 * @author kotall
 * @date 2018年11月14日 下午6:05:16
 * @since 1.0.0
 */
@Component("liteMallStoreManager")
public class LiteMallStoreManagerImpl implements LiteMallStoreManager {

	@Autowired
	private LiteMallStoreMapper liteMallStoreMapper;
	

	@Override
	public List<LiteMallStoreEntity> listLiteMallStore(Page<LiteMallStoreEntity> page, Query search) {
		return liteMallStoreMapper.listForPage(page, search);
	}

	@Override
	public int saveLiteMallStore(LiteMallStoreEntity liteMallStore) {
		return liteMallStoreMapper.save(liteMallStore);
	}

	@Override
	public LiteMallStoreEntity getLiteMallStoreById(Long id) {
		LiteMallStoreEntity liteMallStore = liteMallStoreMapper.getObjectById(id);
		return liteMallStore;
	}

	@Override
	public int updateLiteMallStore(LiteMallStoreEntity liteMallStore) {
		return liteMallStoreMapper.update(liteMallStore);
	}

	@Override
	public int batchRemove(Long[] id) {
		int count = liteMallStoreMapper.batchRemove(id);
		return count;
	}

	@Override
	public List<Integer> queryStoreIdListByUserId(Integer userId) {
		return this.liteMallStoreMapper.queryStoreIdListByUserId(userId);
	}
}
