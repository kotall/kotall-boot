package com.kotall.rms.core.service.litemall.impl;

import com.kotall.rms.common.entity.litemall.LiteMallAddressEntity;
import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Query;
import com.kotall.rms.core.annotation.StoreFilter;
import com.kotall.rms.core.manager.litemall.LiteMallAddressManager;
import com.kotall.rms.core.service.BaseServiceImpl;
import com.kotall.rms.core.service.litemall.LiteMallAddressService;
import org.apache.shiro.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 收货地址表
 *
 * @author kotall
 * @date 2018年11月13日 上午11:28:53
 * @since 1.0.0
 */
@Service("liteMallAddressService")
public class LiteMallAddressServiceImpl extends BaseServiceImpl<LiteMallAddressManager, LiteMallAddressEntity> implements LiteMallAddressService {

	@Autowired
	private LiteMallAddressManager liteMallAddressManager;

	@StoreFilter
	@Override
	public Page<LiteMallAddressEntity> queryAddressByPage(Map<String, Object> params) {
		return super.queryByPage(params);
	}

	@Override
	public List<LiteMallAddressEntity> queryByUserId(Integer userId) {
		return this.liteMallAddressManager.queryByUserId(userId);
	}

	@Override
	public void resetDefault(Integer userId) {
		LiteMallAddressEntity address = new LiteMallAddressEntity();
		address.setIsDefault(false);
		address.setUpdateTime(new Date());
		Map<String, Object> params = new HashMap<>();
		params.put("userId", userId);
		params.put("deleted", 0);
		Query query = new Query(params);
		this.liteMallAddressManager.resetDefault(address, query);
	}

	@Override
	public LiteMallAddressEntity getDefault(Integer userId) {
		Map<String, Object> params = new HashMap<>();
		params.put("userId", userId);
		params.put("isDefault", 1);
		params.put("deleted", 0);
		List<LiteMallAddressEntity> list = this.queryByList(params);
		return CollectionUtils.isEmpty(list) ? null : list.get(0);
	}
}
