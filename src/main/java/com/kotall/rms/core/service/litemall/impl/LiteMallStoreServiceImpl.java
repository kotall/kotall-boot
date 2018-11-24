package com.kotall.rms.core.service.litemall.impl;

import com.kotall.rms.common.entity.litemall.LiteMallStoreEntity;
import com.kotall.rms.common.utils.Page;
import com.kotall.rms.core.annotation.StoreFilter;
import com.kotall.rms.core.manager.litemall.LiteMallStoreManager;
import com.kotall.rms.core.service.BaseServiceImpl;
import com.kotall.rms.core.service.litemall.LiteMallStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 店铺表 
 *
 * @author kotall
 * @date 2018年11月14日 下午6:05:16
 * @since 1.0.0
 */
@Service("liteMallStoreService")
public class LiteMallStoreServiceImpl extends BaseServiceImpl<LiteMallStoreManager, LiteMallStoreEntity> implements LiteMallStoreService {

	@Autowired
	private LiteMallStoreManager liteMallStoreManager;

	@StoreFilter(storeId = "id")
	@Override
	public Page<LiteMallStoreEntity> queryStoreByPage(Map<String, Object> params) {
		return super.queryByPage(params);
	}

	@Override
	public List<Integer> queryStoreIdListByUserId(Integer userId) {
		return this.liteMallStoreManager.queryIdListByUserId(userId);
	}
}
