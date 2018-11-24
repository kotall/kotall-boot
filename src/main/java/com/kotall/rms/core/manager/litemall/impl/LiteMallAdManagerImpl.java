package com.kotall.rms.core.manager.litemall.impl;

import com.kotall.rms.common.dao.litemall.LiteMallAdMapper;
import com.kotall.rms.common.entity.litemall.LiteMallAdEntity;
import com.kotall.rms.core.manager.BaseManagerImpl;
import com.kotall.rms.core.manager.litemall.LiteMallAdManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 广告表
 *
 * @author kotall
 * @date 2018年11月13日 下午6:08:21
 * @since 1.0.0
 */
@Component("liteMallAdManager")
public class LiteMallAdManagerImpl extends BaseManagerImpl<LiteMallAdMapper, LiteMallAdEntity> implements LiteMallAdManager {

	@Autowired
	private LiteMallAdMapper liteMallAdMapper;
	
}
