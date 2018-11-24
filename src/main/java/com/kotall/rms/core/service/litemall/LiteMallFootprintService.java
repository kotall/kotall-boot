package com.kotall.rms.core.service.litemall;

import com.kotall.rms.common.entity.litemall.LiteMallFootprintEntity;
import com.kotall.rms.common.utils.Page;
import com.kotall.rms.core.service.BaseService;

import java.util.Map;

/**
 * 用户浏览足迹表
 *
 * @author kotall
 * @date 2018年11月13日 下午2:10:19
 * @since 1.0.0
 */
public interface LiteMallFootprintService extends BaseService<LiteMallFootprintEntity> {

    Page<LiteMallFootprintEntity> queryFootprintByPage(Map<String, Object> params);

}
