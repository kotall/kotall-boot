package com.kotall.rms.core.manager.litemall;

import com.kotall.rms.common.entity.litemall.LiteMallGrouponEntity;
import com.kotall.rms.common.utils.Query;
import com.kotall.rms.core.manager.BaseManager;

/**
 * 
 *
 * @author kotall
 * @date 2018年11月13日 下午6:32:18
 * @since 1.0.0
 */
public interface LiteMallGrouponManager extends BaseManager<LiteMallGrouponEntity> {

    int countGroupOn(Query query);
}
