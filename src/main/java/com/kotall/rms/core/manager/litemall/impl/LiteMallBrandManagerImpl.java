package com.kotall.rms.core.manager.litemall.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Query;
import com.kotall.rms.common.dao.litemall.LiteMallBrandMapper;
import com.kotall.rms.common.entity.litemall.LiteMallBrandEntity;
import com.kotall.rms.core.manager.litemall.LiteMallBrandManager;

/**
 * 品牌商表
 *
 * @author kotall
 * @date 2018年11月13日 下午2:48:32
 * @since 1.0.0
 */
@Component("liteMallBrandManager")
public class LiteMallBrandManagerImpl implements LiteMallBrandManager {

	@Autowired
	private LiteMallBrandMapper liteMallBrandMapper;
	

	@Override
	public List<LiteMallBrandEntity> listLiteMallBrand(Page<LiteMallBrandEntity> page, Query search) {
		return liteMallBrandMapper.listForPage(page, search);
	}

	@Override
	public int saveLiteMallBrand(LiteMallBrandEntity liteMallBrand) {
		return liteMallBrandMapper.save(liteMallBrand);
	}

	@Override
	public LiteMallBrandEntity getLiteMallBrandById(Long id) {
		LiteMallBrandEntity liteMallBrand = liteMallBrandMapper.getObjectById(id);
		return liteMallBrand;
	}

	@Override
	public int updateLiteMallBrand(LiteMallBrandEntity liteMallBrand) {
		return liteMallBrandMapper.update(liteMallBrand);
	}

	@Override
	public int batchRemove(Long[] id) {
		int count = liteMallBrandMapper.batchRemove(id);
		return count;
	}
	
}
