package com.kotall.rms.core.manager.litemall.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Query;
import com.kotall.rms.common.dao.litemall.LiteMallAddressMapper;
import com.kotall.rms.common.entity.litemall.LiteMallAddressEntity;
import com.kotall.rms.core.manager.litemall.LiteMallAddressManager;

/**
 * 收货地址表
 *
 * @author kotall
 * @date 2018年11月13日 上午11:28:53
 * @since 1.0.0
 */
@Component("liteMallAddressManager")
public class LiteMallAddressManagerImpl implements LiteMallAddressManager {

	@Autowired
	private LiteMallAddressMapper liteMallAddressMapper;
	

	@Override
	public List<LiteMallAddressEntity> listLiteMallAddress(Page<LiteMallAddressEntity> page, Query search) {
		return liteMallAddressMapper.listForPage(page, search);
	}

	@Override
	public int saveLiteMallAddress(LiteMallAddressEntity liteMallAddress) {
		return liteMallAddressMapper.save(liteMallAddress);
	}

	@Override
	public LiteMallAddressEntity getLiteMallAddressById(Long id) {
		LiteMallAddressEntity liteMallAddress = liteMallAddressMapper.getObjectById(id);
		return liteMallAddress;
	}

	@Override
	public int updateLiteMallAddress(LiteMallAddressEntity liteMallAddress) {
		return liteMallAddressMapper.update(liteMallAddress);
	}

	@Override
	public int batchRemove(Long[] id) {
		int count = liteMallAddressMapper.batchRemove(id);
		return count;
	}
	
}
