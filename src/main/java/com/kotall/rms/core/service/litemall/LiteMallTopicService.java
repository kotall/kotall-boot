package com.kotall.rms.core.service.litemall;

import java.util.List;
import java.util.Map;

import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Result;
import com.kotall.rms.common.entity.litemall.LiteMallTopicEntity;

/**
 * 专题表
 *
 * @author kotall
 * @date 2018年11月13日 下午6:17:39
 * @since 1.0.0
 */
public interface LiteMallTopicService {

	Page<LiteMallTopicEntity> listLiteMallTopic(Map<String, Object> params);

    Page<LiteMallTopicEntity> queryListByPage(Map<String, Object> params);

    int saveLiteMallTopic(LiteMallTopicEntity liteMallTopic);

    LiteMallTopicEntity getLiteMallTopicById(Long id);

    int updateLiteMallTopic(LiteMallTopicEntity liteMallTopic);

    int batchRemove(Long[] id);

    /**
     * 查询专题列表
     * @param params
     * @return
     */
    List<LiteMallTopicEntity> queryTopicList(Map<String, Object> params);

    /**
     * 查询相关主题
     * @param params
     * @return
     */
    List<LiteMallTopicEntity> queryRelatedList(Map<String, Object> params);
}
