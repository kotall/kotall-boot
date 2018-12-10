package com.kotall.rms.core.service.litemall.impl;

import com.kotall.rms.common.entity.litemall.LiteMallGoodsAttributeEntity;
import com.kotall.rms.common.entity.litemall.LiteMallGoodsEntity;
import com.kotall.rms.common.entity.litemall.LiteMallGoodsProductEntity;
import com.kotall.rms.common.entity.litemall.LiteMallGoodsSpecificationEntity;
import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Query;
import com.kotall.rms.core.annotation.StoreFilter;
import com.kotall.rms.core.manager.litemall.LiteMallGoodsAttributeManager;
import com.kotall.rms.core.manager.litemall.LiteMallGoodsManager;
import com.kotall.rms.core.manager.litemall.LiteMallGoodsProductManager;
import com.kotall.rms.core.manager.litemall.LiteMallGoodsSpecificationManager;
import com.kotall.rms.core.service.BaseServiceImpl;
import com.kotall.rms.core.service.litemall.LiteMallGoodsAttributeService;
import com.kotall.rms.core.service.litemall.LiteMallGoodsProductService;
import com.kotall.rms.core.service.litemall.LiteMallGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * 商品基本信息表
 *
 * @author kotall
 * @date 2018年11月19日 下午3:03:30
 * @since 1.0.0
 */
@Service("liteMallGoodsService")
public class LiteMallGoodsServiceImpl extends BaseServiceImpl<LiteMallGoodsManager, LiteMallGoodsEntity> implements LiteMallGoodsService {

	@Autowired
	private LiteMallGoodsManager liteMallGoodsManager;
	@Autowired
	private LiteMallGoodsSpecificationManager liteMallGoodsSpecificationManager;
	@Autowired
	private LiteMallGoodsProductManager liteMallGoodsProductManager;
	@Autowired
	private LiteMallGoodsAttributeManager liteMallGoodsAttributeManager;

	@StoreFilter
	@Override
	public Page<LiteMallGoodsEntity> queryGoodsByPage(Map<String, Object> params) {
		return super.queryByPage(params);
	}

	@Override
	public List<LiteMallGoodsEntity> queryByNew(Map<String, Object> params) {
		params.put("isNew", 1);
		params.put("isOnSale", 1);
		params.put("deleted", 0);
		Query query = new Query(params);
		Page<LiteMallGoodsEntity> page = new Page<>(query);
		liteMallGoodsManager.queryByPage(page, query);
		return page.getRows();
	}

	@Override
	public List<LiteMallGoodsEntity> queryByHot(Map<String, Object> params) {
		params.put("isHot", 1);
		params.put("isOnSale", 1);
		params.put("deleted", 0);
		Query query = new Query(params);
		Page<LiteMallGoodsEntity> page = new Page<>(query);
		liteMallGoodsManager.queryByPage(page, query);
		return page.getRows();
	}

	@Override
	public List<LiteMallGoodsEntity> queryByCategory(Map<String, Object> params) {
		Query query = new Query(params);
		Page<LiteMallGoodsEntity> page = new Page<>(query);
		liteMallGoodsManager.queryByPage(page, query);
		return page.getRows();
	}

	@Override
	public Integer countOnSale(Map<String, Object> params) {
		Query query = new Query(params);
		return this.liteMallGoodsManager.countOnSale(query);
	}

	@Override
	public List<Integer> queryCategoryIds(Map<String, Object> params) {
		Query query = new Query(params);
		return this.liteMallGoodsManager.queryCategoryIds(query);
	}
	@Override
	@Transactional
	public boolean save(LiteMallGoodsEntity liteMallGoods) {
	   boolean count = liteMallGoodsManager.saveLiteMallGoods(liteMallGoods);
		addGoodsSpeciProAttr(liteMallGoods);
		return count;
	}

	@Override
	@Transactional
	public boolean update(LiteMallGoodsEntity liteMallGoods){
		boolean count = liteMallGoodsManager.update(liteMallGoods);
		liteMallGoodsManager.unionDelete(liteMallGoods);
		addGoodsSpeciProAttr(liteMallGoods);
		return true;
	}
	private void addGoodsSpeciProAttr(LiteMallGoodsEntity liteMallGoods) {
		List<LiteMallGoodsSpecificationEntity> liteMallGoodsSpecifications = liteMallGoods.getLiteMallGoodsSpecification();
		for(LiteMallGoodsSpecificationEntity bean : liteMallGoodsSpecifications){
			bean.setStoreId(liteMallGoods.getStoreId());
			bean.setGoodsId(liteMallGoods.getId());
		}
		List<LiteMallGoodsProductEntity>	liteMallGoodsProducts = liteMallGoods.getLiteMallGoodsProduct();
		for(LiteMallGoodsProductEntity bean : liteMallGoodsProducts){
			bean.setStoreId(liteMallGoods.getStoreId());
			bean.setGoodsId(liteMallGoods.getId());
		}
		List<LiteMallGoodsAttributeEntity>	liteMallGoodsAttributes = liteMallGoods.getLiteMallGoodsAttribute();
		for(LiteMallGoodsAttributeEntity bean : liteMallGoodsAttributes){
			bean.setStoreId(liteMallGoods.getStoreId());
			bean.setGoodsId(liteMallGoods.getId());
		}
		liteMallGoodsSpecificationManager.insertBatch(liteMallGoodsSpecifications);
		liteMallGoodsProductManager.insertBatch(liteMallGoodsProducts);
		liteMallGoodsAttributeManager.insertBatch(liteMallGoodsAttributes);
	}

}
