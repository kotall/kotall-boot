package com.kotall.rms.core.manager.litemall.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Query;
import com.kotall.rms.common.dao.litemall.LiteMallKeywordMapper;
import com.kotall.rms.common.entity.litemall.LiteMallKeywordEntity;
import com.kotall.rms.core.manager.litemall.LiteMallKeywordManager;

/**
 * 关键字表
 *
 * @author kotall
 * @date 2018年11月13日 下午4:34:40
 * @since 1.0.0
 */
@Component("liteMallKeywordManager")
public class LiteMallKeywordManagerImpl implements LiteMallKeywordManager {

	@Autowired
	private LiteMallKeywordMapper liteMallKeywordMapper;
	

	@Override
	public List<LiteMallKeywordEntity> listLiteMallKeyword(Page<LiteMallKeywordEntity> page, Query search) {
		return liteMallKeywordMapper.listForPage(page, search);
	}

	@Override
	public int saveLiteMallKeyword(LiteMallKeywordEntity liteMallKeyword) {
		return liteMallKeywordMapper.save(liteMallKeyword);
	}

	@Override
	public LiteMallKeywordEntity getLiteMallKeywordById(Long id) {
		LiteMallKeywordEntity liteMallKeyword = liteMallKeywordMapper.getObjectById(id);
		return liteMallKeyword;
	}

	@Override
	public int updateLiteMallKeyword(LiteMallKeywordEntity liteMallKeyword) {
		return liteMallKeywordMapper.update(liteMallKeyword);
	}

	@Override
	public int batchRemove(Long[] id) {
		int count = liteMallKeywordMapper.batchRemove(id);
		return count;
	}
	
}
