package com.kotall.rms.core.manager.litemall.impl;

import com.kotall.rms.common.dao.litemall.LiteMallKeywordMapper;
import com.kotall.rms.common.entity.litemall.LiteMallKeywordEntity;
import com.kotall.rms.core.manager.BaseManagerImpl;
import com.kotall.rms.core.manager.litemall.LiteMallKeywordManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 关键字表
 *
 * @author kotall
 * @date 2018年11月13日 下午4:34:40
 * @since 1.0.0
 */
@Component("liteMallKeywordManager")
public class LiteMallKeywordManagerImpl extends BaseManagerImpl<LiteMallKeywordMapper, LiteMallKeywordEntity> implements LiteMallKeywordManager {

	@Autowired
	private LiteMallKeywordMapper liteMallKeywordMapper;
}
