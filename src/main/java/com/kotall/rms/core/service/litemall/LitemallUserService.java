package com.kotall.rms.core.service.litemall;

import java.util.Map;

import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Result;
import com.kotall.rms.common.entity.litemall.LitemallUserEntity;

/**
 * 用户表
 *
 * @author kotall
 * @date 2018年11月13日 上午9:47:19
 * @since 1.0.0
 */
public interface LitemallUserService {

	Page<LitemallUserEntity> listLitemallUser(Map<String, Object> params);

    int saveLitemallUser(LitemallUserEntity litemallUser);

    LitemallUserEntity getLitemallUserById(Long id);

    int updateLitemallUser(LitemallUserEntity litemallUser);

    int batchRemove(Long[] id);
	
}
