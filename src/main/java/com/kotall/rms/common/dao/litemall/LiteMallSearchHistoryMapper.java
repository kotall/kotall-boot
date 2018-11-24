package com.kotall.rms.common.dao.litemall;

import org.apache.ibatis.annotations.Mapper;

import com.kotall.rms.common.entity.litemall.LiteMallSearchHistoryEntity;
import com.kotall.rms.common.dao.BaseMapper;

/**
 * 搜索历史表
 *
 * @author kotall
 * @date 2018年11月13日 下午2:19:50
 * @since 1.0.0
 */
@Mapper
public interface LiteMallSearchHistoryMapper extends BaseMapper<LiteMallSearchHistoryEntity> {

    void deleteByUserId(Integer userId);
}
