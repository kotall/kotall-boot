package com.kotall.rms.core.manager.litemall;

import com.kotall.rms.common.entity.litemall.LiteMallSearchHistoryEntity;
import com.kotall.rms.core.manager.BaseManager;

/**
 * 搜索历史表
 *
 * @author kotall
 * @date 2018年11月13日 下午2:19:50
 * @since 1.0.0
 */
public interface LiteMallSearchHistoryManager extends BaseManager<LiteMallSearchHistoryEntity> {

    void deleteByUserId(Integer userId);

}
