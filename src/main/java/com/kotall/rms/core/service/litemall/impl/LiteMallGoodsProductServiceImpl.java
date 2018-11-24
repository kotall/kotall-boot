package com.kotall.rms.core.service.litemall.impl;

import com.kotall.rms.common.entity.litemall.LiteMallGoodsProductEntity;
import com.kotall.rms.core.manager.litemall.LiteMallGoodsProductManager;
import com.kotall.rms.core.service.BaseServiceImpl;
import com.kotall.rms.core.service.litemall.LiteMallGoodsProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 商品货品表
 *
 * @author kotall
 * @date 2018年11月20日 下午12:58:29
 * @since 1.0.0
 */
@Service("liteMallGoodsProductService")
public class LiteMallGoodsProductServiceImpl extends BaseServiceImpl<LiteMallGoodsProductManager, LiteMallGoodsProductEntity> implements LiteMallGoodsProductService {

	@Autowired
	private LiteMallGoodsProductManager liteMallGoodsProductManager;

	@Override
	public List<LiteMallGoodsProductEntity> queryByGoodsId(Map<String, Object> params) {
		return this.queryByList(params);
	}

}
