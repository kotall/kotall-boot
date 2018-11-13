package com.kotall.rms.core.service.litemall.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kotall.rms.common.utils.Query;
import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.entity.litemall.LiteMallUserEntity;
import com.kotall.rms.common.manager.litemall.LiteMallUserManager;
import com.kotall.rms.core.service.litemall.LiteMallUserService;

/**
 * 用户表
 *
 * @author kotall
 * @date 2018年11月13日 上午10:18:32
 * @since 1.0.0
 */
@Service("liteMallUserService")
public class LiteMallUserServiceImpl implements LiteMallUserService {

	@Autowired
	private LiteMallUserManager liteMallUserManager;

	@Override
	public Page<LiteMallUserEntity> listLiteMallUser(Map<String, Object> params) {
		Query query = new Query(params);
		Page<LiteMallUserEntity> page = new Page<>(query);
		liteMallUserManager.listLiteMallUser(page, query);
		return page;
	}

	@Override
	public int saveLiteMallUser(LiteMallUserEntity role) {
		int count = liteMallUserManager.saveLiteMallUser(role);
		return count;
	}

	@Override
	public LiteMallUserEntity getLiteMallUserById(Long id) {
		LiteMallUserEntity liteMallUser = liteMallUserManager.getLiteMallUserById(id);
		return liteMallUser;
	}

	@Override
	public int updateLiteMallUser(LiteMallUserEntity liteMallUser) {
		int count = liteMallUserManager.updateLiteMallUser(liteMallUser);
		return count;
	}

	@Override
	public int batchRemove(Long[] id) {
		int count = liteMallUserManager.batchRemove(id);
		return count;
	}

}