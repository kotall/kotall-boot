package com.kotall.rms.core.service.litemall.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kotall.rms.core.annotation.StoreFilter;
import org.apache.shiro.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kotall.rms.common.utils.Query;
import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.entity.litemall.LiteMallAddressEntity;
import com.kotall.rms.core.manager.litemall.LiteMallAddressManager;
import com.kotall.rms.core.service.litemall.LiteMallAddressService;

/**
 * 收货地址表
 *
 * @author kotall
 * @date 2018年11月13日 上午11:28:53
 * @since 1.0.0
 */
@Service("liteMallAddressService")
public class LiteMallAddressServiceImpl implements LiteMallAddressService {

	@Autowired
	private LiteMallAddressManager liteMallAddressManager;

	@StoreFilter
	@Override
	public Page<LiteMallAddressEntity> listLiteMallAddress(Map<String, Object> params) {
		Query query = new Query(params);
		Page<LiteMallAddressEntity> page = new Page<>(query);
		liteMallAddressManager.listLiteMallAddress(page, query);
		return page;
	}

	@Override
	public List<LiteMallAddressEntity> queryAddressList(Map<String, Object> params) {
		Query query = new Query(params);
		return liteMallAddressManager.queryAddressList(query);
	}

	@Override
	public List<LiteMallAddressEntity> queryByUid(Integer userId) {
		return this.liteMallAddressManager.queryByUserId(userId);
	}

	@Override
	public int saveLiteMallAddress(LiteMallAddressEntity role) {
		int count = liteMallAddressManager.saveLiteMallAddress(role);
		return count;
	}

	@Override
	public LiteMallAddressEntity getLiteMallAddressById(Integer id) {
		LiteMallAddressEntity liteMallAddress = liteMallAddressManager.getLiteMallAddressById(id);
		return liteMallAddress;
	}

	@Override
	public int updateLiteMallAddress(LiteMallAddressEntity liteMallAddress) {
		int count = liteMallAddressManager.updateLiteMallAddress(liteMallAddress);
		return count;
	}

	@Override
	public int batchRemove(Long[] id) {
		int count = liteMallAddressManager.batchRemove(id);
		return count;
	}

	@Override
	public void resetDefault(Integer userId) {
		LiteMallAddressEntity address = new LiteMallAddressEntity();
		address.setIsDefault(0);
		address.setUpdateTime(new Date());
		Map<String, Object> params = new HashMap<>();
		params.put("userId", userId);
		params.put("deleted", 0);
		Query query = new Query(params);
		this.liteMallAddressManager.resetDefault(address, query);
	}

	@Override
	public LiteMallAddressEntity findDefault(Integer userId) {
		Map<String, Object> params = new HashMap<>();
		params.put("userId", userId);
		params.put("isDefault", 1);
		params.put("deleted", 0);
		List<LiteMallAddressEntity> list = this.queryAddressList(params);
		return CollectionUtils.isEmpty(list) ? null : list.get(0);
	}
}
