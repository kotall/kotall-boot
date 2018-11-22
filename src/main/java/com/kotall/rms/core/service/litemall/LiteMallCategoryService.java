package com.kotall.rms.core.service.litemall;

import com.kotall.rms.common.entity.litemall.LiteMallCategoryEntity;
import com.kotall.rms.common.utils.Page;

import java.util.List;
import java.util.Map;

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

    /**
     * 查询栏目
     * @param params
     * @return
     */
    List<LiteMallCategoryEntity> queryChannel(Map<String, Object> params);

    /**
     *
     * @param params
     * @return
     */
    List<LiteMallCategoryEntity> queryL1WithoutRecommend(Map<String, Object> params);

    /**
     * 查询子类目列表
     * @param id
     * @return
     */
    List<LiteMallCategoryEntity> queryByPid(Integer id);

    List<LiteMallCategoryEntity> getSecondCategory();
}
