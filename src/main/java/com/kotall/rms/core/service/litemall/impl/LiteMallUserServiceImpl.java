package com.kotall.rms.core.service.litemall.impl;

import com.kotall.rms.common.entity.litemall.LiteMallUserEntity;
import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Query;
import com.kotall.rms.core.annotation.StoreFilter;
import com.kotall.rms.core.manager.litemall.LiteMallUserManager;
import com.kotall.rms.core.service.BaseServiceImpl;
import com.kotall.rms.core.service.litemall.LiteMallUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户表
 *
 * @author kotall
 * @date 2018年11月13日 上午10:18:32
 * @since 1.0.0
 */
@Service("liteMallUserService")
public class LiteMallUserServiceImpl extends BaseServiceImpl<LiteMallUserManager, LiteMallUserEntity> implements LiteMallUserService {

	@Autowired
	private LiteMallUserManager liteMallUserManager;

	@StoreFilter
	@Override
	public Page<LiteMallUserEntity> queryUserByPage(Map<String, Object> params) {
		return super.queryByPage(params);
	}

	@Override
	public List<LiteMallUserEntity> queryByUsername(Integer storeId, String username) {
		Map<String, Object> params = new HashMap<>();
		params.put("storeId", storeId);
		params.put("username", username);
		params.put("deleted", 0);

		return this.queryByList(params);
	}

	@Override
	public List<LiteMallUserEntity> queryByOpenId(Integer storeId, String openId) {
		Map<String, Object> params = new HashMap<>();
		params.put("storeId", storeId);
		params.put("weixinOpenid", openId);
		params.put("deleted", 0);

		return this.queryByList(params);
	}

	@Override
	public List<LiteMallUserEntity> queryByMobile(String mobile) {
		Map<String, Object> params = new HashMap<>();
		params.put("mobile", mobile);
		params.put("deleted", 0);

		return this.queryByList(params);
	}

	@Override
	public List<LiteMallUserEntity> queryByList(Map<String, Object> params) {
		Query query = new Query(params);
		return this.liteMallUserManager.queryByList(query);
	}
}
