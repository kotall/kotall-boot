package com.kotall.rms.core.service.litemall;

import com.kotall.rms.common.entity.litemall.LiteMallSearchHistoryEntity;
import com.kotall.rms.common.utils.Page;
import com.kotall.rms.core.service.BaseService;

import java.util.List;
import java.util.Map;

/**
 * 搜索历史表
 *
 * @author kotall
 * @date 2018年11月13日 下午2:19:50
 * @since 1.0.0
 */
public interface LiteMallSearchHistoryService extends BaseService<LiteMallSearchHistoryEntity>{

    Page<LiteMallSearchHistoryEntity> querySearchHistoryByPage(Map<String, Object> params);

    void deleteByUserId(Integer userId);

    List<LiteMallSearchHistoryEntity> queryByUserId(Integer userId);

}
