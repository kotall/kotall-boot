package com.kotall.rms.core.service.litemall;

import com.kotall.rms.common.entity.litemall.LiteMallAdEntity;
import com.kotall.rms.core.service.BaseService;

import java.util.List;
import java.util.Map;

/**
 * 广告表
 *
 * @author kotall
 * @date 2018年11月13日 下午6:08:21
 * @since 1.0.0
 */
public interface LiteMallAdService extends BaseService<LiteMallAdEntity> {

    /**
     * 查询首页广告
     * @return
     */
    List<LiteMallAdEntity> queryIndex(Map<String, Object> params);
}
