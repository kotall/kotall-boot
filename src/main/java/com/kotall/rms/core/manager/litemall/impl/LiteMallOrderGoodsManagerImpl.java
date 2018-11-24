package com.kotall.rms.core.manager.litemall.impl;

import com.kotall.rms.common.dao.litemall.LiteMallOrderGoodsMapper;
import com.kotall.rms.common.entity.litemall.LiteMallOrderGoodsEntity;
import com.kotall.rms.common.utils.Query;
import com.kotall.rms.core.manager.BaseManagerImpl;
import com.kotall.rms.core.manager.litemall.LiteMallOrderGoodsManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 订单商品表
 *
 * @author kotall
 * @date 2018年11月13日 下午4:45:21
 * @since 1.0.0
 */
@Component("liteMallOrderGoodsManager")
public class LiteMallOrderGoodsManagerImpl extends BaseManagerImpl<LiteMallOrderGoodsMapper, LiteMallOrderGoodsEntity> implements LiteMallOrderGoodsManager {

	@Autowired
	private LiteMallOrderGoodsMapper liteMallOrderGoodsMapper;
	
	@Override
	public Integer countTotal(Query query) {
		return this.liteMallOrderGoodsMapper.countTotal(query);
	}
}
