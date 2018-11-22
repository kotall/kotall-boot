package com.kotall.rms.common.dao.litemall;

import org.apache.ibatis.annotations.Mapper;

import com.kotall.rms.common.entity.litemall.LiteMallCategoryEntity;
import com.kotall.rms.common.dao.sys.BaseMapper;

import java.util.List;

/**
 * 类目表
 *
 * @author kotall
 * @date 2018年11月13日 下午4:12:36
 * @since 1.0.0
 */
@Mapper
public interface LiteMallCategoryMapper extends BaseMapper<LiteMallCategoryEntity> {

    List<LiteMallCategoryEntity> listByPid(Integer pid);

    List<LiteMallCategoryEntity> getSecondCategory();
}
