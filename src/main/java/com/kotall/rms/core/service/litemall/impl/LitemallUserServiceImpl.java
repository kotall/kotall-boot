package com.kotall.rms.core.service.litemall.impl;

import com.kotall.rms.common.entity.litemall.LitemallUserEntity;
import com.kotall.rms.common.manager.litemall.LitemallUserManager;
import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Query;
import com.kotall.rms.core.service.litemall.LitemallUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 用户表
 *
 * @author kotall
 * @date 2018年11月13日 上午9:47:19
 * @since 1.0.0
 */
@Service("litemallUserService")
public class LitemallUserServiceImpl implements LitemallUserService {

	@Autowired
	private LitemallUserManager litemallUserManager;

	@Override
	public Page<LitemallUserEntity> listLitemallUser(Map<String, Object> params) {
		Query query = new Query(params);
		Page<LitemallUserEntity> page = new Page<>(query);
		litemallUserManager.listLitemallUser(page, query);
		return page;
	}

	@Override
	public int saveLitemallUser(LitemallUserEntity role) {
		int count = litemallUserManager.saveLitemallUser(role);
		return count;
	}

	@Override
	public LitemallUserEntity getLitemallUserById(Long id) {
		LitemallUserEntity litemallUser = litemallUserManager.getLitemallUserById(id);
		return litemallUser;
	}

	@Override
	public int updateLitemallUser(LitemallUserEntity litemallUser) {
		int count = litemallUserManager.updateLitemallUser(litemallUser);
		return count;
	}

	@Override
	public int batchRemove(Long[] id) {
		int count = litemallUserManager.batchRemove(id);
		return count;
	}

}
