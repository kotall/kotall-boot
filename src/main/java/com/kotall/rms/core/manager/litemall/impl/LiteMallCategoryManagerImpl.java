package com.kotall.rms.core.manager.litemall.impl;

import com.kotall.rms.common.dao.litemall.LiteMallCategoryMapper;
import com.kotall.rms.common.entity.litemall.LiteMallCategoryEntity;
import com.kotall.rms.core.manager.BaseManagerImpl;
import com.kotall.rms.core.manager.litemall.LiteMallCategoryManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * 类目表
 *
 * @author kotall
 * @date 2018年11月13日 下午4:12:36
 * @since 1.0.0
 */
@Component("liteMallCategoryManager")
public class LiteMallCategoryManagerImpl extends BaseManagerImpl<LiteMallCategoryMapper, LiteMallCategoryEntity> implements LiteMallCategoryManager {

	@Autowired
	private LiteMallCategoryMapper liteMallCategoryMapper;
	
	@Override
	public List<LiteMallCategoryEntity> queryByPid(Integer pid) {
		return this.liteMallCategoryMapper.listByPid(pid);
	}

	@Override
	public List<LiteMallCategoryEntity> getSecondCategory() {
		return liteMallCategoryMapper.getSecondCategory();
	}

	@Override
	public List<LiteMallCategoryEntity> getParentCategory(Map<String, Object> params) {
		return liteMallCategoryMapper.getParentCategory(params);
	}
}
