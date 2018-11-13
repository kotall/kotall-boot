package com.kotall.rms.core.manager.litemall.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Query;
import com.kotall.rms.common.dao.litemall.LiteMallUserMapper;
import com.kotall.rms.common.entity.litemall.LiteMallUserEntity;
import com.kotall.rms.core.manager.litemall.LiteMallUserManager;

/**
 * 用户表
 *
 * @author kotall
 * @date 2018年11月13日 上午10:18:32
 * @since 1.0.0
 */
@Component("liteMallUserManager")
public class LiteMallUserManagerImpl implements LiteMallUserManager {

	@Autowired
	private LiteMallUserMapper liteMallUserMapper;
	

	@Override
	public List<LiteMallUserEntity> listLiteMallUser(Page<LiteMallUserEntity> page, Query search) {
		return liteMallUserMapper.listForPage(page, search);
	}

	@Override
	public int saveLiteMallUser(LiteMallUserEntity liteMallUser) {
		return liteMallUserMapper.save(liteMallUser);
	}

	@Override
	public LiteMallUserEntity getLiteMallUserById(Long id) {
		LiteMallUserEntity liteMallUser = liteMallUserMapper.getObjectById(id);
		return liteMallUser;
	}

	@Override
	public int updateLiteMallUser(LiteMallUserEntity liteMallUser) {
		return liteMallUserMapper.update(liteMallUser);
	}

	@Override
	public int batchRemove(Long[] id) {
		int count = liteMallUserMapper.batchRemove(id);
		return count;
	}
	
}
