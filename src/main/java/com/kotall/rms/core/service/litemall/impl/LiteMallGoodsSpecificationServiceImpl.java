package com.kotall.rms.core.service.litemall.impl;

import com.kotall.rms.common.entity.litemall.LiteMallGoodsSpecificationEntity;
import com.kotall.rms.core.manager.litemall.LiteMallGoodsSpecificationManager;
import com.kotall.rms.core.service.BaseServiceImpl;
import com.kotall.rms.core.service.litemall.LiteMallGoodsSpecificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 商品规格表
 *
 * @author kotall
 * @date 2018年11月20日 下午7:50:58
 * @since 1.0.0
 */
@Service("liteMallGoodsSpecificationService")
public class LiteMallGoodsSpecificationServiceImpl extends BaseServiceImpl<LiteMallGoodsSpecificationManager, LiteMallGoodsSpecificationEntity> implements LiteMallGoodsSpecificationService {

	@Autowired
	private LiteMallGoodsSpecificationManager liteMallGoodsSpecificationManager;

}
