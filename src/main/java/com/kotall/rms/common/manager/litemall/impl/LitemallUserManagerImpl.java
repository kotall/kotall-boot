package com.kotall.rms.common.manager.litemall.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Query;
import com.kotall.rms.common.dao.litemall.LitemallUserMapper;
import com.kotall.rms.common.entity.litemall.LitemallUserEntity;
import com.kotall.rms.common.manager.litemall.LitemallUserManager;

/**
 * 用户表
 *
 * @author kotall
 * @date 2018年11月13日 上午9:47:19
 * @since 1.0.0
 */
@Component("litemallUserManager")
public class LitemallUserManagerImpl implements LitemallUserManager {

	@Autowired
	private LitemallUserMapper litemallUserMapper;
	

	@Override
	public List<LitemallUserEntity> listLitemallUser(Page<LitemallUserEntity> page, Query search) {
		return litemallUserMapper.listForPage(page, search);
	}

	@Override
	public int saveLitemallUser(LitemallUserEntity litemallUser) {
		return litemallUserMapper.save(litemallUser);
	}

	@Override
	public LitemallUserEntity getLitemallUserById(Long id) {
		LitemallUserEntity litemallUser = litemallUserMapper.getObjectById(id);
		return litemallUser;
	}

	@Override
	public int updateLitemallUser(LitemallUserEntity litemallUser) {
		return litemallUserMapper.update(litemallUser);
	}

	@Override
	public int batchRemove(Long[] id) {
		int count = litemallUserMapper.batchRemove(id);
		return count;
	}
	
}
