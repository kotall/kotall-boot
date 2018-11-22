package com.kotall.rms.core.service.litemall.impl;

import java.util.List;
import java.util.Map;

import com.kotall.rms.common.entity.litemall.LiteMallAdEntity;
import com.kotall.rms.core.annotation.StoreFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kotall.rms.common.utils.Query;
import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.entity.litemall.LiteMallBrandEntity;
import com.kotall.rms.core.manager.litemall.LiteMallBrandManager;
import com.kotall.rms.core.service.litemall.LiteMallBrandService;

/**
 * 品牌商表
 *
 * @author kotall
 * @date 2018年11月13日 下午2:48:32
 * @since 1.0.0
 */
@Service("liteMallBrandService")
public class LiteMallBrandServiceImpl implements LiteMallBrandService {

	@Autowired
	private LiteMallBrandManager liteMallBrandManager;

	@StoreFilter
	@Override
	public Page<LiteMallBrandEntity> listLiteMallBrand(Map<String, Object> params) {
		return this.queryBrandList(params);
	}

	@Override
	public Page<LiteMallBrandEntity> queryBrandList(Map<String, Object> params) {
		Query query = new Query(params);
		Page<LiteMallBrandEntity> page = new Page<>(query);
		liteMallBrandManager.listLiteMallBrand(page, query);
		return page;
	}

	@Override
	public int saveLiteMallBrand(LiteMallBrandEntity role) {
		int count = liteMallBrandManager.saveLiteMallBrand(role);
		return count;
	}

	@Override
	public LiteMallBrandEntity getLiteMallBrandById(Long id) {
		LiteMallBrandEntity liteMallBrand = liteMallBrandManager.getLiteMallBrandById(id);
		return liteMallBrand;
	}

	@Override
	public int updateLiteMallBrand(LiteMallBrandEntity liteMallBrand) {
		int count = liteMallBrandManager.updateLiteMallBrand(liteMallBrand);
		return count;
	}

	@Override
	public int batchRemove(Long[] id) {
		int count = liteMallBrandManager.batchRemove(id);
		return count;
	}

}
