package com.kotall.rms.core.service.litemall.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kotall.rms.common.utils.Query;
import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.entity.litemall.LiteMallGoodsProductEntity;
import com.kotall.rms.core.manager.litemall.LiteMallGoodsProductManager;
import com.kotall.rms.core.service.litemall.LiteMallGoodsProductService;

/**
 * 商品货品表
 *
 * @author kotall
 * @date 2018年11月20日 下午12:58:29
 * @since 1.0.0
 */
@Service("liteMallGoodsProductService")
public class LiteMallGoodsProductServiceImpl implements LiteMallGoodsProductService {

	@Autowired
	private LiteMallGoodsProductManager liteMallGoodsProductManager;

	@Override
	public Page<LiteMallGoodsProductEntity> listLiteMallGoodsProduct(Map<String, Object> params) {
		Query query = new Query(params);
		Page<LiteMallGoodsProductEntity> page = new Page<>(query);
		liteMallGoodsProductManager.listLiteMallGoodsProduct(page, query);
		return page;
	}

	@Override
	public int saveLiteMallGoodsProduct(LiteMallGoodsProductEntity role) {
		int count = liteMallGoodsProductManager.saveLiteMallGoodsProduct(role);
		return count;
	}

	@Override
	public LiteMallGoodsProductEntity getLiteMallGoodsProductById(Long id) {
		LiteMallGoodsProductEntity liteMallGoodsProduct = liteMallGoodsProductManager.getLiteMallGoodsProductById(id);
		return liteMallGoodsProduct;
	}

	@Override
	public int updateLiteMallGoodsProduct(LiteMallGoodsProductEntity liteMallGoodsProduct) {
		int count = liteMallGoodsProductManager.updateLiteMallGoodsProduct(liteMallGoodsProduct);
		return count;
	}

	@Override
	public int batchRemove(Long[] id) {
		int count = liteMallGoodsProductManager.batchRemove(id);
		return count;
	}

}
