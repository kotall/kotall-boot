package com.kotall.rms.core.service.litemall;

import com.kotall.rms.common.entity.litemall.LiteMallTopicEntity;
import com.kotall.rms.common.utils.Page;
import com.kotall.rms.core.service.BaseService;

import java.util.List;
import java.util.Map;

/**
 * 专题表
 *
 * @author kotall
 * @date 2018年11月13日 下午6:17:39
 * @since 1.0.0
 */
public interface LiteMallTopicService extends BaseService<LiteMallTopicEntity> {

    Page<LiteMallTopicEntity> queryTopicByPage(Map<String, Object> params);

    /**
     * 查询相关主题
     *
     * @param topicId
     * @return
     */
    List<LiteMallTopicEntity> queryRelatedTopicList(Integer topicId);
}
