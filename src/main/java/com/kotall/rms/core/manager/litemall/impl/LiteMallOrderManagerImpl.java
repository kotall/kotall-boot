package com.kotall.rms.core.manager.litemall.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Query;
import com.kotall.rms.common.dao.litemall.LiteMallOrderMapper;
import com.kotall.rms.common.entity.litemall.LiteMallOrderEntity;
import com.kotall.rms.core.manager.litemall.LiteMallOrderManager;

/**
 * 订单表
 *
 * @author kotall
 * @date 2018年11月13日 下午4:22:38
 * @since 1.0.0
 */
@Component("liteMallOrderManager")
public class LiteMallOrderManagerImpl implements LiteMallOrderManager {

	@Autowired
	private LiteMallOrderMapper liteMallOrderMapper;
	

	@Override
	public List<LiteMallOrderEntity> listLiteMallOrder(Page<LiteMallOrderEntity> page, Query search) {
		return liteMallOrderMapper.listForPage(page, search);
	}

	@Override
	public int saveLiteMallOrder(LiteMallOrderEntity liteMallOrder) {
		return liteMallOrderMapper.save(liteMallOrder);
	}

	@Override
	public LiteMallOrderEntity getLiteMallOrderById(Long id) {
		LiteMallOrderEntity liteMallOrder = liteMallOrderMapper.getObjectById(id);
		return liteMallOrder;
	}

	@Override
	public int updateLiteMallOrder(LiteMallOrderEntity liteMallOrder) {
		return liteMallOrderMapper.update(liteMallOrder);
	}

	@Override
	public int batchRemove(Long[] id) {
		int count = liteMallOrderMapper.batchRemove(id);
		return count;
	}
	
}
