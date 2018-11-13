package com.kotall.rms.core.manager.litemall.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Query;
import com.kotall.rms.common.dao.litemall.LiteMallOrderGoodsMapper;
import com.kotall.rms.common.entity.litemall.LiteMallOrderGoodsEntity;
import com.kotall.rms.core.manager.litemall.LiteMallOrderGoodsManager;

/**
 * 订单商品表
 *
 * @author kotall
 * @date 2018年11月13日 下午4:45:21
 * @since 1.0.0
 */
@Component("liteMallOrderGoodsManager")
public class LiteMallOrderGoodsManagerImpl implements LiteMallOrderGoodsManager {

	@Autowired
	private LiteMallOrderGoodsMapper liteMallOrderGoodsMapper;
	

	@Override
	public List<LiteMallOrderGoodsEntity> listLiteMallOrderGoods(Page<LiteMallOrderGoodsEntity> page, Query search) {
		return liteMallOrderGoodsMapper.listForPage(page, search);
	}

	@Override
	public int saveLiteMallOrderGoods(LiteMallOrderGoodsEntity liteMallOrderGoods) {
		return liteMallOrderGoodsMapper.save(liteMallOrderGoods);
	}

	@Override
	public LiteMallOrderGoodsEntity getLiteMallOrderGoodsById(Long id) {
		LiteMallOrderGoodsEntity liteMallOrderGoods = liteMallOrderGoodsMapper.getObjectById(id);
		return liteMallOrderGoods;
	}

	@Override
	public int updateLiteMallOrderGoods(LiteMallOrderGoodsEntity liteMallOrderGoods) {
		return liteMallOrderGoodsMapper.update(liteMallOrderGoods);
	}

	@Override
	public int batchRemove(Long[] id) {
		int count = liteMallOrderGoodsMapper.batchRemove(id);
		return count;
	}
	
}
