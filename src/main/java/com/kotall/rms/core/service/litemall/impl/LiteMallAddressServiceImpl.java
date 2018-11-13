package com.kotall.rms.core.service.litemall.impl;

import java.util.Map;

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

	@Override
	public Page<LiteMallAddressEntity> listLiteMallAddress(Map<String, Object> params) {
		Query query = new Query(params);
		Page<LiteMallAddressEntity> page = new Page<>(query);
		liteMallAddressManager.listLiteMallAddress(page, query);
		return page;
	}

	@Override
	public int saveLiteMallAddress(LiteMallAddressEntity role) {
		int count = liteMallAddressManager.saveLiteMallAddress(role);
		return count;
	}

	@Override
	public LiteMallAddressEntity getLiteMallAddressById(Long id) {
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

}
