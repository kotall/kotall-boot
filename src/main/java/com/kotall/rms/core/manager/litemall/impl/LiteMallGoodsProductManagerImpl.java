package com.kotall.rms.core.manager.litemall.impl;

import com.kotall.rms.common.dao.litemall.LiteMallGoodsProductMapper;
import com.kotall.rms.common.entity.litemall.LiteMallGoodsProductEntity;
import com.kotall.rms.core.manager.BaseManagerImpl;
import com.kotall.rms.core.manager.litemall.LiteMallGoodsProductManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 商品货品表
 *
 * @author kotall
 * @date 2018年11月20日 下午12:58:29
 * @since 1.0.0
 */
@Component("liteMallGoodsProductManager")
public class LiteMallGoodsProductManagerImpl extends BaseManagerImpl<LiteMallGoodsProductMapper, LiteMallGoodsProductEntity> implements LiteMallGoodsProductManager {

	@Autowired
	private LiteMallGoodsProductMapper liteMallGoodsProductMapper;

	@Override
	public void insertBatch(List<LiteMallGoodsProductEntity> liteMallGoodsProducts) {
		liteMallGoodsProductMapper.insertBatch(liteMallGoodsProducts);
	}
}
