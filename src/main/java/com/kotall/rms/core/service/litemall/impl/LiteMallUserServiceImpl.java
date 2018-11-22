package com.kotall.rms.core.service.litemall.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kotall.rms.core.annotation.StoreFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kotall.rms.common.utils.Query;
import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.entity.litemall.LiteMallUserEntity;
import com.kotall.rms.core.manager.litemall.LiteMallUserManager;
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

	@StoreFilter
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

	@Override
	public List<LiteMallUserEntity> queryByUsername(Long storeId, String username) {
		Map<String, Object> params = new HashMap<>();
		params.put("storeId", storeId);
		params.put("username", username);
		params.put("deleted", 0);

		return this.queryUserList(params);
	}

	@Override
	public List<LiteMallUserEntity> queryByOpenId(Long storeId, String openId) {
		Map<String, Object> params = new HashMap<>();
		params.put("storeId", storeId);
		params.put("weixinOpenid", openId);
		params.put("deleted", 0);

		return this.queryUserList(params);
	}

	@Override
	public List<LiteMallUserEntity> queryByMobile(String mobile) {
		Map<String, Object> params = new HashMap<>();
		params.put("mobile", mobile);
		params.put("deleted", 0);

		return this.queryUserList(params);
	}

	@Override
	public List<LiteMallUserEntity> queryUserList(Map<String, Object> params) {
		Query query = new Query(params);
		return this.liteMallUserManager.queryUserList(query);
	}
}
