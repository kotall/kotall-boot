package com.kotall.rms.core.manager.litemall.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Query;
import com.kotall.rms.common.dao.litemall.LiteMallUserFormidMapper;
import com.kotall.rms.common.entity.litemall.LiteMallUserFormidEntity;
import com.kotall.rms.core.manager.litemall.LiteMallUserFormidManager;

/**
 * 
 *
 * @author kotall
 * @date 2018年11月20日 下午1:56:37
 * @since 1.0.0
 */
@Component("liteMallUserFormidManager")
public class LiteMallUserFormidManagerImpl implements LiteMallUserFormidManager {

	@Autowired
	private LiteMallUserFormidMapper liteMallUserFormidMapper;
	

	@Override
	public List<LiteMallUserFormidEntity> listLiteMallUserFormid(Page<LiteMallUserFormidEntity> page, Query search) {
		return liteMallUserFormidMapper.listForPage(page, search);
	}

	@Override
	public int saveLiteMallUserFormid(LiteMallUserFormidEntity liteMallUserFormid) {
		return liteMallUserFormidMapper.save(liteMallUserFormid);
	}

	@Override
	public LiteMallUserFormidEntity getLiteMallUserFormidById(Long id) {
		LiteMallUserFormidEntity liteMallUserFormid = liteMallUserFormidMapper.getObjectById(id);
		return liteMallUserFormid;
	}

	@Override
	public int updateLiteMallUserFormid(LiteMallUserFormidEntity liteMallUserFormid) {
		return liteMallUserFormidMapper.update(liteMallUserFormid);
	}

	@Override
	public int batchRemove(Long[] id) {
		int count = liteMallUserFormidMapper.batchRemove(id);
		return count;
	}
	
}
