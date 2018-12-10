package com.kotall.rms.core.service.litemall.impl;

import com.kotall.rms.common.entity.litemall.LiteMallGoodsAttributeEntity;
import com.kotall.rms.core.manager.litemall.LiteMallGoodsAttributeManager;
import com.kotall.rms.core.service.BaseServiceImpl;
import com.kotall.rms.core.service.litemall.LiteMallGoodsAttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 商品参数表
 *
 * @author kotall
 * @date 2018年11月20日 下午7:51:23
 * @since 1.0.0
 */
@Service("liteMallGoodsAttributeService")
public class LiteMallGoodsAttributeServiceImpl extends BaseServiceImpl<LiteMallGoodsAttributeManager,LiteMallGoodsAttributeEntity > implements LiteMallGoodsAttributeService {

	@Autowired
	private LiteMallGoodsAttributeManager liteMallGoodsAttributeManager;


	@Override
	public List<LiteMallGoodsAttributeEntity> queryByGoodsId(Map<String, Object> params) {
		return super.queryByList(params);
	}

	@Override
	public List<LiteMallGoodsAttributeEntity> getByGoodsId(String goodsId) {
		return liteMallGoodsAttributeManager.getByGoodsId(goodsId);
	}
}
