package com.kotall.rms.core.manager.litemall.impl;

import com.kotall.rms.common.dao.litemall.LiteMallBrandMapper;
import com.kotall.rms.common.entity.litemall.LiteMallBrandEntity;
import com.kotall.rms.core.manager.BaseManagerImpl;
import com.kotall.rms.core.manager.litemall.LiteMallBrandManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 品牌商表
 *
 * @author kotall
 * @date 2018年11月13日 下午2:48:32
 * @since 1.0.0
 */
@Component("liteMallBrandManager")
public class LiteMallBrandManagerImpl extends BaseManagerImpl<LiteMallBrandMapper, LiteMallBrandEntity> implements LiteMallBrandManager {

	@Autowired
	private LiteMallBrandMapper liteMallBrandMapper;
	

}
