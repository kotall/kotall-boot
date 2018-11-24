package com.kotall.rms.core.manager.litemall.impl;

import com.kotall.rms.common.dao.litemall.LiteMallUserMapper;
import com.kotall.rms.common.entity.litemall.LiteMallUserEntity;
import com.kotall.rms.core.manager.BaseManagerImpl;
import com.kotall.rms.core.manager.litemall.LiteMallUserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 用户表
 *
 * @author kotall
 * @date 2018年11月13日 上午10:18:32
 * @since 1.0.0
 */
@Component("liteMallUserManager")
public class LiteMallUserManagerImpl extends BaseManagerImpl<LiteMallUserMapper, LiteMallUserEntity>implements LiteMallUserManager {

	@Autowired
	private LiteMallUserMapper liteMallUserMapper;

}
