package com.kotall.rms.core.manager.litemall.impl;

import com.kotall.rms.common.dao.litemall.LiteMallFootprintMapper;
import com.kotall.rms.common.entity.litemall.LiteMallFootprintEntity;
import com.kotall.rms.core.manager.BaseManagerImpl;
import com.kotall.rms.core.manager.litemall.LiteMallFootprintManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 用户浏览足迹表
 *
 * @author kotall
 * @date 2018年11月13日 下午2:10:19
 * @since 1.0.0
 */
@Component("liteMallFootprintManager")
public class LiteMallFootprintManagerImpl extends BaseManagerImpl<LiteMallFootprintMapper, LiteMallFootprintEntity> implements LiteMallFootprintManager {

	@Autowired
	private LiteMallFootprintMapper liteMallFootprintMapper;

}
