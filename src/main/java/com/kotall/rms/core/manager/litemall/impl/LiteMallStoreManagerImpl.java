package com.kotall.rms.core.manager.litemall.impl;

import com.kotall.rms.common.dao.litemall.LiteMallStoreMapper;
import com.kotall.rms.common.entity.litemall.LiteMallStoreEntity;
import com.kotall.rms.core.manager.BaseManagerImpl;
import com.kotall.rms.core.manager.litemall.LiteMallStoreManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 店铺表 
 *
 * @author kotall
 * @date 2018年11月14日 下午6:05:16
 * @since 1.0.0
 */
@Component("liteMallStoreManager")
public class LiteMallStoreManagerImpl extends BaseManagerImpl<LiteMallStoreMapper, LiteMallStoreEntity> implements LiteMallStoreManager {

	@Autowired
	private LiteMallStoreMapper liteMallStoreMapper;

	@Override
	public List<Integer> queryIdListByUserId(Integer userId) {
		return this.liteMallStoreMapper.queryStoreIdListByUserId(userId);
	}
}
