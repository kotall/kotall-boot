package com.kotall.rms.core.service.litemall;

import java.util.List;
import java.util.Map;

import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.entity.litemall.LiteMallKeywordEntity;
import com.kotall.rms.core.service.BaseService;

/**
 * 关键字表
 *
 * @author kotall
 * @date 2018年11月13日 下午4:34:40
 * @since 1.0.0
 */
public interface LiteMallKeywordService extends BaseService<LiteMallKeywordEntity> {

	Page<LiteMallKeywordEntity> queryKeywordByPage(Map<String, Object> params);


    LiteMallKeywordEntity queryDefault(Integer storeId);

    List<LiteMallKeywordEntity> queryHots(Integer storeId);
}
