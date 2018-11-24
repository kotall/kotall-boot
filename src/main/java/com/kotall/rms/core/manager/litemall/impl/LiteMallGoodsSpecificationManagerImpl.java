package com.kotall.rms.core.manager.litemall.impl;

import com.kotall.rms.common.dao.litemall.LiteMallGoodsSpecificationMapper;
import com.kotall.rms.common.entity.litemall.LiteMallGoodsSpecificationEntity;
import com.kotall.rms.core.manager.BaseManagerImpl;
import com.kotall.rms.core.manager.litemall.LiteMallGoodsSpecificationManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 商品规格表
 *
 * @author kotall
 * @date 2018年11月20日 下午7:50:58
 * @since 1.0.0
 */
@Component("liteMallGoodsSpecificationManager")
public class LiteMallGoodsSpecificationManagerImpl extends BaseManagerImpl<LiteMallGoodsSpecificationMapper, LiteMallGoodsSpecificationEntity> implements LiteMallGoodsSpecificationManager {

	@Autowired
	private LiteMallGoodsSpecificationMapper liteMallGoodsSpecificationMapper;
	
}
