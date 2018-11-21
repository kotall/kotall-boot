package com.kotall.rms.core.manager.litemall.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Query;
import com.kotall.rms.common.dao.litemall.LiteMallGoodsProductMapper;
import com.kotall.rms.common.entity.litemall.LiteMallGoodsProductEntity;
import com.kotall.rms.core.manager.litemall.LiteMallGoodsProductManager;

/**
 * 商品货品表
 *
 * @author kotall
 * @date 2018年11月20日 下午12:58:29
 * @since 1.0.0
 */
@Component("liteMallGoodsProductManager")
public class LiteMallGoodsProductManagerImpl implements LiteMallGoodsProductManager {

	@Autowired
	private LiteMallGoodsProductMapper liteMallGoodsProductMapper;
	

	@Override
	public List<LiteMallGoodsProductEntity> listLiteMallGoodsProduct(Page<LiteMallGoodsProductEntity> page, Query search) {
		return liteMallGoodsProductMapper.listForPage(page, search);
	}

	@Override
	public List<LiteMallGoodsProductEntity> queryGoodsProductList(Query query) {
		return this.liteMallGoodsProductMapper.list(query);
	}

	@Override
	public int saveLiteMallGoodsProduct(LiteMallGoodsProductEntity liteMallGoodsProduct) {
		return liteMallGoodsProductMapper.save(liteMallGoodsProduct);
	}

	@Override
	public LiteMallGoodsProductEntity getLiteMallGoodsProductById(Long id) {
		LiteMallGoodsProductEntity liteMallGoodsProduct = liteMallGoodsProductMapper.getObjectById(id);
		return liteMallGoodsProduct;
	}

	@Override
	public int updateLiteMallGoodsProduct(LiteMallGoodsProductEntity liteMallGoodsProduct) {
		return liteMallGoodsProductMapper.update(liteMallGoodsProduct);
	}

	@Override
	public int batchRemove(Long[] id) {
		int count = liteMallGoodsProductMapper.batchRemove(id);
		return count;
	}
	
}
