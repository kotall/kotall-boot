package com.kotall.rms.core.manager.litemall.impl;

import com.kotall.rms.common.dao.litemall.LiteMallAddressMapper;
import com.kotall.rms.common.entity.litemall.LiteMallAddressEntity;
import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Query;
import com.kotall.rms.core.manager.litemall.LiteMallAddressManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

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
	public List<LiteMallAddressEntity> queryByPage(Page<LiteMallAddressEntity> page, Query search) {
		return liteMallAddressMapper.listForPage(page, search);
	}

	@Override
	public List<LiteMallAddressEntity> queryByList(Query query) {
		return liteMallAddressMapper.list(query);
	}

	@Override
	public int save(LiteMallAddressEntity liteMallAddress) {
		return liteMallAddressMapper.save(liteMallAddress);
	}

	@Override
	public LiteMallAddressEntity getById(Integer id) {
		LiteMallAddressEntity liteMallAddress = liteMallAddressMapper.getObjectById(id);
		return liteMallAddress;
	}

	@Override
	public int update(LiteMallAddressEntity liteMallAddress) {
		return liteMallAddressMapper.update(liteMallAddress);
	}

	@Override
	public int deleteByIds(Integer[] id) {
		int count = liteMallAddressMapper.batchRemove(id);
		return count;
	}

	@Override
	public List<LiteMallAddressEntity> queryByUserId(Integer userId) {
		return this.liteMallAddressMapper.getByUserId(userId);
	}

	@Override
	public void resetDefault(LiteMallAddressEntity address, Query query) {
		this.liteMallAddressMapper.resetDefault(address, query);
	}
}
