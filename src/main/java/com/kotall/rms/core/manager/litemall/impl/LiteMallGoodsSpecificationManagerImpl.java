package com.kotall.rms.core.manager.litemall.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Query;
import com.kotall.rms.common.dao.litemall.LiteMallGoodsSpecificationMapper;
import com.kotall.rms.common.entity.litemall.LiteMallGoodsSpecificationEntity;
import com.kotall.rms.core.manager.litemall.LiteMallGoodsSpecificationManager;

/**
 * 商品规格表
 *
 * @author kotall
 * @date 2018年11月20日 下午7:50:58
 * @since 1.0.0
 */
@Component("liteMallGoodsSpecificationManager")
public class LiteMallGoodsSpecificationManagerImpl implements LiteMallGoodsSpecificationManager {

	@Autowired
	private LiteMallGoodsSpecificationMapper liteMallGoodsSpecificationMapper;
	

	@Override
	public List<LiteMallGoodsSpecificationEntity> listLiteMallGoodsSpecification(Page<LiteMallGoodsSpecificationEntity> page, Query search) {
		return liteMallGoodsSpecificationMapper.listForPage(page, search);
	}

	@Override
	public List<LiteMallGoodsSpecificationEntity> querySpecificationList(Query query) {
		return this.liteMallGoodsSpecificationMapper.list(query);
	}

	@Override
	public int saveLiteMallGoodsSpecification(LiteMallGoodsSpecificationEntity liteMallGoodsSpecification) {
		return liteMallGoodsSpecificationMapper.save(liteMallGoodsSpecification);
	}

	@Override
	public LiteMallGoodsSpecificationEntity getLiteMallGoodsSpecificationById(Long id) {
		LiteMallGoodsSpecificationEntity liteMallGoodsSpecification = liteMallGoodsSpecificationMapper.getObjectById(id);
		return liteMallGoodsSpecification;
	}

	@Override
	public int updateLiteMallGoodsSpecification(LiteMallGoodsSpecificationEntity liteMallGoodsSpecification) {
		return liteMallGoodsSpecificationMapper.update(liteMallGoodsSpecification);
	}

	@Override
	public int batchRemove(Long[] id) {
		int count = liteMallGoodsSpecificationMapper.batchRemove(id);
		return count;
	}
	
}
