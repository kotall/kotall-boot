package com.kotall.rms.core.service.litemall.impl;

import com.kotall.rms.common.entity.litemall.LiteMallAdEntity;
import com.kotall.rms.common.utils.Query;
import com.kotall.rms.core.manager.litemall.LiteMallAdManager;
import com.kotall.rms.core.service.BaseServiceImpl;
import com.kotall.rms.core.service.litemall.LiteMallAdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 广告表
 *
 * @author kotall
 * @date 2018年11月13日 下午6:08:21
 * @since 1.0.0
 */
@Service("liteMallAdService")
public class LiteMallAdServiceImpl extends BaseServiceImpl<LiteMallAdManager, LiteMallAdEntity> implements LiteMallAdService {

	@Autowired
	private LiteMallAdManager liteMallAdManager;

	@Override
	public List<LiteMallAdEntity> queryIndex(Map<String, Object> params) {
		params.put("position", 1);
		params.put("deleted", false);
		params.put("enabled", true);
		Query query = new Query(params);
		return this.liteMallAdManager.queryByList(query);
	}
}
