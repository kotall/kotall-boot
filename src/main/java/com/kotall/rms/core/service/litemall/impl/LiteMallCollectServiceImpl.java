package com.kotall.rms.core.service.litemall.impl;

import com.kotall.rms.common.entity.litemall.LiteMallCollectEntity;
import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Query;
import com.kotall.rms.core.annotation.StoreFilter;
import com.kotall.rms.core.manager.litemall.LiteMallCollectManager;
import com.kotall.rms.core.service.BaseServiceImpl;
import com.kotall.rms.core.service.litemall.LiteMallCollectService;
import org.apache.shiro.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 收藏表
 *
 * @author kotall
 * @date 2018年11月13日 上午11:41:28
 * @since 1.0.0
 */
@Service("liteMallCollectService")
public class LiteMallCollectServiceImpl extends BaseServiceImpl<LiteMallCollectManager, LiteMallCollectEntity> implements LiteMallCollectService {

	@Autowired
	private LiteMallCollectManager liteMallCollectManager;

	@Override
	public Page<LiteMallCollectEntity> queryByType(Map<String, Object> params) {

		return this.queryCollectListByPage(params);
	}

	@Override
	public LiteMallCollectEntity queryByTypeAndValue(Map<String, Object> params) {
		List<LiteMallCollectEntity> list = this.queryByList(params);
		return CollectionUtils.isEmpty(list) ? null : list.get(0);
	}

	@StoreFilter
	@Override
	public Page<LiteMallCollectEntity> queryCollectListByPage(Map<String, Object> params) {
		return super.queryByPage(params);
	}

	@Override
	public int countUserCollect(Map<String, Object> params) {
		Query query = new Query(params);
		return this.liteMallCollectManager.countUserCollect(query);
	}
}
