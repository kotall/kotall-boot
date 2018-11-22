package com.kotall.rms.core.manager.litemall;

import java.util.List;

import com.kotall.rms.common.entity.litemall.LiteMallAdEntity;
import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Query;
import com.kotall.rms.common.entity.litemall.LiteMallCategoryEntity;

/**
 * 类目表
 *
 * @author kotall
 * @date 2018年11月13日 下午4:12:36
 * @since 1.0.0
 */
public interface LiteMallCategoryManager {

	List<LiteMallCategoryEntity> listLiteMallCategory(Page<LiteMallCategoryEntity> page, Query search);
	
	int saveLiteMallCategory(LiteMallCategoryEntity liteMallCategory);
	
	LiteMallCategoryEntity getLiteMallCategoryById(Long id);
	
	int updateLiteMallCategory(LiteMallCategoryEntity liteMallCategory);
	
	int batchRemove(Long[] id);

    List<LiteMallCategoryEntity> queryCategoryList(Query query);

    List<LiteMallCategoryEntity> queryByPid(Integer pid);

    List<LiteMallCategoryEntity> getSecondCategory();
}
