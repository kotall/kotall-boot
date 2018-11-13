package com.kotall.rms.core.service.litemall;

import java.util.Map;

import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Result;
import com.kotall.rms.common.entity.litemall.LiteMallCategoryEntity;

/**
 * 类目表
 *
 * @author kotall
 * @date 2018年11月13日 下午4:12:36
 * @since 1.0.0
 */
public interface LiteMallCategoryService {

	Page<LiteMallCategoryEntity> listLiteMallCategory(Map<String, Object> params);

    int saveLiteMallCategory(LiteMallCategoryEntity liteMallCategory);

    LiteMallCategoryEntity getLiteMallCategoryById(Long id);

    int updateLiteMallCategory(LiteMallCategoryEntity liteMallCategory);

    int batchRemove(Long[] id);
	
}
