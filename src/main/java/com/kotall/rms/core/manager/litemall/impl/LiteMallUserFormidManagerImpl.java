package com.kotall.rms.core.manager.litemall.impl;

import com.kotall.rms.common.dao.litemall.LiteMallUserFormidMapper;
import com.kotall.rms.common.entity.litemall.LiteMallUserFormidEntity;
import com.kotall.rms.core.manager.BaseManagerImpl;
import com.kotall.rms.core.manager.litemall.LiteMallUserFormidManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 
 *
 * @author kotall
 * @date 2018年11月20日 下午1:56:37
 * @since 1.0.0
 */
@Component("liteMallUserFormidManager")
public class LiteMallUserFormidManagerImpl extends BaseManagerImpl<LiteMallUserFormidMapper, LiteMallUserFormidEntity> implements LiteMallUserFormidManager {

	@Autowired
	private LiteMallUserFormidMapper liteMallUserFormidMapper;

}
