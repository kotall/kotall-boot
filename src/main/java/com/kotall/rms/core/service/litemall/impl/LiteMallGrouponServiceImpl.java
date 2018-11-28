package com.kotall.rms.core.service.litemall.impl;

import com.kotall.rms.common.entity.litemall.LiteMallGrouponEntity;
import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Query;
import com.kotall.rms.core.annotation.StoreFilter;
import com.kotall.rms.core.manager.litemall.LiteMallGrouponManager;
import com.kotall.rms.core.service.BaseServiceImpl;
import com.kotall.rms.core.service.litemall.LiteMallGrouponService;
import org.apache.shiro.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author kotall
 * @date 2018年11月13日 下午6:32:18
 * @since 1.0.0
 */
@Service("liteMallGrouponService")
public class LiteMallGrouponServiceImpl extends BaseServiceImpl<LiteMallGrouponManager, LiteMallGrouponEntity> implements LiteMallGrouponService {

	@Autowired
	private LiteMallGrouponManager liteMallGrouponManager;

	@StoreFilter
	@Override
	public Page<LiteMallGrouponEntity> queryGroupOnByPage(Map<String, Object> params) {
		return super.queryByPage(params);
	}


	@Override
	public List<LiteMallGrouponEntity> queryJoinRecord(Map<String, Object> params) {
		return this.queryByList(params);
	}

	@Override
	public List<LiteMallGrouponEntity> queryMyGroupon(Map<String, Object> params) {
		return this.queryByList(params);
	}

	@Override
	public List<LiteMallGrouponEntity> queryMyJoinGroupon(Map<String, Object> params) {
		return this.queryByList(params);
	}

	@Override
	public int countGroupOn(Map<String, Object> params) {
		Query query = new Query(params);
		return this.liteMallGrouponManager.countGroupOn(query);
	}

	@Override
	public LiteMallGrouponEntity queryByOrderId(Integer orderId) {
		Map<String, Object> params = new HashMap<>();
		params.put("orderId", orderId);
		params.put("deleted", false);
		List<LiteMallGrouponEntity> list = this.queryByList(params);

		return CollectionUtils.isEmpty(list) ? null : list.get(0);
	}
}
