package com.kotall.rms.core.manager.litemall;

import com.kotall.rms.common.entity.litemall.LiteMallKeywordEntity;
import com.kotall.rms.common.utils.Query;
import com.kotall.rms.core.manager.BaseManager;

import java.util.List;

/**
 * 关键字表
 *
 * @author kotall
 * @date 2018年11月13日 下午4:34:40
 * @since 1.0.0
 */
public interface LiteMallKeywordManager extends BaseManager<LiteMallKeywordEntity> {

    List<LiteMallKeywordEntity> queryByList(Query query);
}
