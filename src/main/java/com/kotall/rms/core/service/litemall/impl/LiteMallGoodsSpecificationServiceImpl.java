package com.kotall.rms.core.service.litemall.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kotall.rms.common.utils.Query;
import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.entity.litemall.LiteMallGoodsSpecificationEntity;
import com.kotall.rms.core.manager.litemall.LiteMallGoodsSpecificationManager;
import com.kotall.rms.core.service.litemall.LiteMallGoodsSpecificationService;

/**
 * 商品规格表
 *
 * @author kotall
 * @date 2018年11月20日 下午7:50:58
 * @since 1.0.0
 */
@Service("liteMallGoodsSpecificationService")
public class LiteMallGoodsSpecificationServiceImpl implements LiteMallGoodsSpecificationService {

	@Autowired
	private LiteMallGoodsSpecificationManager liteMallGoodsSpecificationManager;

	@Override
	public Page<LiteMallGoodsSpecificationEntity> listLiteMallGoodsSpecification(Map<String, Object> params) {
		Query query = new Query(params);
		Page<LiteMallGoodsSpecificationEntity> page = new Page<>(query);
		liteMallGoodsSpecificationManager.listLiteMallGoodsSpecification(page, query);
		return page;
	}

	@Override
	public List<LiteMallGoodsSpecificationEntity> querySpecificationList(Map<String, Object> params) {
		Query query = new Query(params);
		return this.liteMallGoodsSpecificationManager.querySpecificationList(query);
	}

	@Override
	public int saveLiteMallGoodsSpecification(LiteMallGoodsSpecificationEntity role) {
		int count = liteMallGoodsSpecificationManager.saveLiteMallGoodsSpecification(role);
		return count;
	}

	@Override
	public LiteMallGoodsSpecificationEntity getLiteMallGoodsSpecificationById(Long id) {
		LiteMallGoodsSpecificationEntity liteMallGoodsSpecification = liteMallGoodsSpecificationManager.getLiteMallGoodsSpecificationById(id);
		return liteMallGoodsSpecification;
	}

	@Override
	public int updateLiteMallGoodsSpecification(LiteMallGoodsSpecificationEntity liteMallGoodsSpecification) {
		int count = liteMallGoodsSpecificationManager.updateLiteMallGoodsSpecification(liteMallGoodsSpecification);
		return count;
	}

	@Override
	public int batchRemove(Long[] id) {
		int count = liteMallGoodsSpecificationManager.batchRemove(id);
		return count;
	}

}
