package com.kotall.rms.core.manager.litemall.impl;

import com.kotall.rms.common.dao.litemall.LiteMallGoodsMapper;
import com.kotall.rms.common.entity.litemall.LiteMallGoodsEntity;
import com.kotall.rms.common.utils.Query;
import com.kotall.rms.core.manager.BaseManagerImpl;
import com.kotall.rms.core.manager.litemall.LiteMallGoodsManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 商品基本信息表
 *
 * @author kotall
 * @date 2018年11月19日 下午3:03:30
 * @since 1.0.0
 */
@Component("liteMallGoodsManager")
public class LiteMallGoodsManagerImpl extends BaseManagerImpl<LiteMallGoodsMapper,LiteMallGoodsEntity> implements LiteMallGoodsManager {

	@Autowired
	private LiteMallGoodsMapper liteMallGoodsMapper;
	
	@Override
	public Integer countOnSale(Query query) {
		return this.liteMallGoodsMapper.countTotal(query);
	}

	@Override
	public List<Integer> queryCategoryIds(Query query) {
		return this.liteMallGoodsMapper.queryCategoryIds(query);
	}

	@Override
	public boolean saveLiteMallGoods(LiteMallGoodsEntity liteMallGoodsEntity) {
		return this.liteMallGoodsMapper.add(liteMallGoodsEntity);
	}
}
