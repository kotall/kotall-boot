package com.kotall.rms.core.service.litemall;

import java.util.List;
import java.util.Map;

import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Result;
import com.kotall.rms.common.entity.litemall.LiteMallGrouponRulesEntity;

/**
 * 
 *
 * @author kotall
 * @date 2018年11月13日 下午6:25:19
 * @since 1.0.0
 */
public interface LiteMallGrouponRulesService {

	Page<LiteMallGrouponRulesEntity> listLiteMallGrouponRules(Map<String, Object> params);

    int saveLiteMallGrouponRules(LiteMallGrouponRulesEntity liteMallGrouponRules);

    LiteMallGrouponRulesEntity getLiteMallGrouponRulesById(Long id);

    int updateLiteMallGrouponRules(LiteMallGrouponRulesEntity liteMallGrouponRules);

    int batchRemove(Long[] id);

    /**
     * 获取首页团购活动列表
     * @param params
     * @return
     */
    List<Map<String,Object>> queryGroupOnList(Map<String, Object> params);
}
