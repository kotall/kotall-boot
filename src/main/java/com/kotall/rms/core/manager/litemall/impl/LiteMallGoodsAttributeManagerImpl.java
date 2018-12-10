package com.kotall.rms.core.manager.litemall.impl;

import com.kotall.rms.common.dao.litemall.LiteMallGoodsAttributeMapper;
import com.kotall.rms.common.entity.litemall.LiteMallGoodsAttributeEntity;
import com.kotall.rms.core.manager.BaseManagerImpl;
import com.kotall.rms.core.manager.litemall.LiteMallGoodsAttributeManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 商品参数表
 *
 * @author kotall
 * @date 2018年11月20日 下午7:51:23
 * @since 1.0.0
 */
@Component("liteMallGoodsAttributeManager")
public class LiteMallGoodsAttributeManagerImpl extends BaseManagerImpl<LiteMallGoodsAttributeMapper, LiteMallGoodsAttributeEntity> implements LiteMallGoodsAttributeManager {

	@Autowired
	private LiteMallGoodsAttributeMapper liteMallGoodsAttributeMapper;

	@Override
	public void insertBatch(List<LiteMallGoodsAttributeEntity> liteMallGoodsAttributes) {
		liteMallGoodsAttributeMapper.insertBatch(liteMallGoodsAttributes);
	}
}
