package com.kotall.rms.core.manager.litemall;

import com.kotall.rms.common.entity.litemall.LiteMallCategoryEntity;
import com.kotall.rms.core.manager.BaseManager;

import java.util.List;
import java.util.Map;

/**
 * 类目表
 *
 * @author kotall
 * @date 2018年11月13日 下午4:12:36
 * @since 1.0.0
 */
public interface LiteMallCategoryManager extends BaseManager<LiteMallCategoryEntity> {

    List<LiteMallCategoryEntity> queryByPid(Integer pid);

    List<LiteMallCategoryEntity> getSecondCategory();

    List<LiteMallCategoryEntity> getParentCategory(Map<String, Object> params);
}
