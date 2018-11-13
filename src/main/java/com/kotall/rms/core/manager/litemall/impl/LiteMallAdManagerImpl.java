package com.kotall.rms.core.manager.litemall.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Query;
import com.kotall.rms.common.dao.litemall.LiteMallAdMapper;
import com.kotall.rms.common.entity.litemall.LiteMallAdEntity;
import com.kotall.rms.core.manager.litemall.LiteMallAdManager;

/**
 * 广告表
 *
 * @author kotall
 * @date 2018年11月13日 下午6:08:21
 * @since 1.0.0
 */
@Component("liteMallAdManager")
public class LiteMallAdManagerImpl implements LiteMallAdManager {

	@Autowired
	private LiteMallAdMapper liteMallAdMapper;
	

	@Override
	public List<LiteMallAdEntity> listLiteMallAd(Page<LiteMallAdEntity> page, Query search) {
		return liteMallAdMapper.listForPage(page, search);
	}

	@Override
	public int saveLiteMallAd(LiteMallAdEntity liteMallAd) {
		return liteMallAdMapper.save(liteMallAd);
	}

	@Override
	public LiteMallAdEntity getLiteMallAdById(Long id) {
		LiteMallAdEntity liteMallAd = liteMallAdMapper.getObjectById(id);
		return liteMallAd;
	}

	@Override
	public int updateLiteMallAd(LiteMallAdEntity liteMallAd) {
		return liteMallAdMapper.update(liteMallAd);
	}

	@Override
	public int batchRemove(Long[] id) {
		int count = liteMallAdMapper.batchRemove(id);
		return count;
	}
	
}
