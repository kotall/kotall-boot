package com.kotall.rms.core.service.litemall;

import java.util.Map;

import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Result;
import com.kotall.rms.common.entity.litemall.LiteMallKeywordEntity;

/**
 * 关键字表
 *
 * @author kotall
 * @date 2018年11月13日 下午4:34:40
 * @since 1.0.0
 */
public interface LiteMallKeywordService {

	Page<LiteMallKeywordEntity> listLiteMallKeyword(Map<String, Object> params);

    int saveLiteMallKeyword(LiteMallKeywordEntity liteMallKeyword);

    LiteMallKeywordEntity getLiteMallKeywordById(Long id);

    int updateLiteMallKeyword(LiteMallKeywordEntity liteMallKeyword);

    int batchRemove(Long[] id);
	
}
