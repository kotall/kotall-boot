package com.kotall.rms.core.service.litemall.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kotall.rms.common.utils.Query;
import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.entity.litemall.LiteMallUserFormidEntity;
import com.kotall.rms.core.manager.litemall.LiteMallUserFormidManager;
import com.kotall.rms.core.service.litemall.LiteMallUserFormidService;

/**
 * 
 *
 * @author kotall
 * @date 2018年11月20日 下午1:56:37
 * @since 1.0.0
 */
@Service("liteMallUserFormidService")
public class LiteMallUserFormidServiceImpl implements LiteMallUserFormidService {

	@Autowired
	private LiteMallUserFormidManager liteMallUserFormidManager;

	@Override
	public Page<LiteMallUserFormidEntity> listLiteMallUserFormid(Map<String, Object> params) {
		Query query = new Query(params);
		Page<LiteMallUserFormidEntity> page = new Page<>(query);
		liteMallUserFormidManager.listLiteMallUserFormid(page, query);
		return page;
	}

	@Override
	public int saveLiteMallUserFormid(LiteMallUserFormidEntity role) {
		int count = liteMallUserFormidManager.saveLiteMallUserFormid(role);
		return count;
	}

	@Override
	public LiteMallUserFormidEntity getLiteMallUserFormidById(Long id) {
		LiteMallUserFormidEntity liteMallUserFormid = liteMallUserFormidManager.getLiteMallUserFormidById(id);
		return liteMallUserFormid;
	}

	@Override
	public int updateLiteMallUserFormid(LiteMallUserFormidEntity liteMallUserFormid) {
		int count = liteMallUserFormidManager.updateLiteMallUserFormid(liteMallUserFormid);
		return count;
	}

	@Override
	public int batchRemove(Long[] id) {
		int count = liteMallUserFormidManager.batchRemove(id);
		return count;
	}

}
