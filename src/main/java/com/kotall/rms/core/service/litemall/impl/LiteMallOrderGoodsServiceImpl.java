package com.kotall.rms.core.service.litemall.impl;

import com.kotall.rms.common.entity.litemall.LiteMallOrderGoodsEntity;
import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Query;
import com.kotall.rms.core.annotation.StoreFilter;
import com.kotall.rms.core.manager.litemall.LiteMallOrderGoodsManager;
import com.kotall.rms.core.service.BaseServiceImpl;
import com.kotall.rms.core.service.litemall.LiteMallOrderGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 订单商品表
 *
 * @author kotall
 * @date 2018年11月13日 下午4:45:21
 * @since 1.0.0
 */
@Service("liteMallOrderGoodsService")
public class LiteMallOrderGoodsServiceImpl extends BaseServiceImpl<LiteMallOrderGoodsManager, LiteMallOrderGoodsEntity> implements LiteMallOrderGoodsService {

	@Autowired
	private LiteMallOrderGoodsManager liteMallOrderGoodsManager;

	@StoreFilter
	@Override
	public Page<LiteMallOrderGoodsEntity> queryOrderGoodsByPage(Map<String, Object> params) {
		return super.queryByPage(params);
	}


	@Override
	public List<LiteMallOrderGoodsEntity> queryByOrderId(Map<String, Object> params) {
		Query query = new Query(params);
		return this.liteMallOrderGoodsManager.queryByList(query);
	}

	@Override
	public Integer countCommentIds(Map<String, Object> params) {
		Query query = new Query(params);
		return liteMallOrderGoodsManager.countTotal(query);
	}
}
