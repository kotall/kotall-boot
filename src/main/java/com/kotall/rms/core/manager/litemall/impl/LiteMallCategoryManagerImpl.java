package com.kotall.rms.core.manager.litemall.impl;

import java.util.List;

import com.kotall.rms.common.entity.litemall.LiteMallAdEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Query;
import com.kotall.rms.common.dao.litemall.LiteMallCategoryMapper;
import com.kotall.rms.common.entity.litemall.LiteMallCategoryEntity;
import com.kotall.rms.core.manager.litemall.LiteMallCategoryManager;

/**
 * 类目表
 *
 * @author kotall
 * @date 2018年11月13日 下午4:12:36
 * @since 1.0.0
 */
@Component("liteMallCategoryManager")
public class LiteMallCategoryManagerImpl implements LiteMallCategoryManager {

	@Autowired
	private LiteMallCategoryMapper liteMallCategoryMapper;
	

	@Override
	public List<LiteMallCategoryEntity> listLiteMallCategory(Page<LiteMallCategoryEntity> page, Query search) {
		return liteMallCategoryMapper.listForPage(page, search);
	}

	@Override
	public int saveLiteMallCategory(LiteMallCategoryEntity liteMallCategory) {
		return liteMallCategoryMapper.save(liteMallCategory);
	}

	@Override
	public LiteMallCategoryEntity getLiteMallCategoryById(Long id) {
		LiteMallCategoryEntity liteMallCategory = liteMallCategoryMapper.getObjectById(id);
		return liteMallCategory;
	}

	@Override
	public int updateLiteMallCategory(LiteMallCategoryEntity liteMallCategory) {
		return liteMallCategoryMapper.update(liteMallCategory);
	}

	@Override
	public int batchRemove(Long[] id) {
		int count = liteMallCategoryMapper.batchRemove(id);
		return count;
	}

	@Override
	public List<LiteMallCategoryEntity> queryChannel(Query query) {
		return this.liteMallCategoryMapper.list(query);
	}

	@Override
	public List<LiteMallCategoryEntity> queryByPid(Integer pid) {
		return this.liteMallCategoryMapper.listByPid(pid);
	}

	@Override
	public List<LiteMallCategoryEntity> getSecondCategory() {
		return liteMallCategoryMapper.getSecondCategory();
	}
}
