package com.kotall.rms.core.service.litemall;

import com.kotall.rms.common.entity.litemall.LiteMallGrouponRulesEntity;
import com.kotall.rms.common.utils.Page;
import com.kotall.rms.core.service.BaseService;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author kotall
 * @date 2018年11月13日 下午6:25:19
 * @since 1.0.0
 */
public interface LiteMallGrouponRulesService extends BaseService<LiteMallGrouponRulesEntity> {

    Page<LiteMallGrouponRulesEntity> queryGrouponRulesByPage(Map<String, Object> params);
    /**
     * 获取首页团购活动列表
     * @param params
     * @return
     */
    Page<Map<String,Object>> queryGroupOnList(Map<String, Object> params);

    List<LiteMallGrouponRulesEntity> queryByGoodsId(Map<String, Object> params);

    boolean isExpired(LiteMallGrouponRulesEntity rules);
}
