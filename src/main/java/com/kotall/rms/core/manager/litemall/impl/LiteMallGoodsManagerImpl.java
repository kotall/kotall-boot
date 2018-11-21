package com.kotall.rms.core.manager.litemall.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Query;
import com.kotall.rms.common.dao.litemall.LiteMallGoodsMapper;
import com.kotall.rms.common.entity.litemall.LiteMallGoodsEntity;
import com.kotall.rms.core.manager.litemall.LiteMallGoodsManager;

/**
 * 商品基本信息表
 *
 * @author kotall
 * @date 2018年11月19日 下午3:03:30
 * @since 1.0.0
 */
@Component("liteMallGoodsManager")
public class LiteMallGoodsManagerImpl implements LiteMallGoodsManager {

	@Autowired
	private LiteMallGoodsMapper liteMallGoodsMapper;
	

	@Override
	public List<LiteMallGoodsEntity> listLiteMallGoods(Page<LiteMallGoodsEntity> page, Query search) {
		return liteMallGoodsMapper.listForPage(page, search);
	}

	@Override
	public int saveLiteMallGoods(LiteMallGoodsEntity liteMallGoods) {
		return liteMallGoodsMapper.save(liteMallGoods);
	}

	@Override
	public LiteMallGoodsEntity getLiteMallGoodsById(Long id) {
		LiteMallGoodsEntity liteMallGoods = liteMallGoodsMapper.getObjectById(id);
		return liteMallGoods;
	}

	@Override
	public int updateLiteMallGoods(LiteMallGoodsEntity liteMallGoods) {
		return liteMallGoodsMapper.update(liteMallGoods);
	}

	@Override
	public int batchRemove(Long[] id) {
		int count = liteMallGoodsMapper.batchRemove(id);
		return count;
	}

	@Override
	public Integer countOnSale(Query query) {
		return this.liteMallGoodsMapper.countTotal(query);
	}

	@Override
	public List<Integer> queryCategoryIds(Query query) {
		return this.liteMallGoodsMapper.queryCategoryIds(query);
	}
}
