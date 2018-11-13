package com.kotall.rms.core.service.litemall;

import java.util.Map;

import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Result;
import com.kotall.rms.common.entity.litemall.LiteMallUserEntity;

/**
 * 用户表
 *
 * @author kotall
 * @date 2018年11月13日 上午10:18:32
 * @since 1.0.0
 */
public interface LiteMallUserService {

	Page<LiteMallUserEntity> listLiteMallUser(Map<String, Object> params);

    int saveLiteMallUser(LiteMallUserEntity liteMallUser);

    LiteMallUserEntity getLiteMallUserById(Long id);

    int updateLiteMallUser(LiteMallUserEntity liteMallUser);

    int batchRemove(Long[] id);
	
}
