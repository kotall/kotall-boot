package com.kotall.rms.core.service.litemall;

import com.kotall.rms.common.entity.litemall.LiteMallBrandEntity;
import com.kotall.rms.common.utils.Page;
import com.kotall.rms.core.service.BaseService;

import java.util.Map;

/**
 * 品牌商表
 *
 * @author kotall
 * @date 2018年11月13日 下午2:48:32
 * @since 1.0.0
 */
public interface LiteMallBrandService extends BaseService<LiteMallBrandEntity> {

    /**
     * 获取品牌列表
     * @param params
     * @return
     */
    Page<LiteMallBrandEntity> queryBrandList(Map<String, Object> params);
}
