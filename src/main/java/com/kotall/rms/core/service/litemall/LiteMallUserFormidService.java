package com.kotall.rms.core.service.litemall;

import java.util.List;
import java.util.Map;

import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Result;
import com.kotall.rms.common.entity.litemall.LiteMallUserFormidEntity;

/**
 * 
 *
 * @author kotall
 * @date 2018年11月20日 下午1:56:37
 * @since 1.0.0
 */
public interface LiteMallUserFormidService {

	Page<LiteMallUserFormidEntity> listLiteMallUserFormid(Map<String, Object> params);

    List<LiteMallUserFormidEntity> queryUserFormid(Map<String, Object> params);

    int saveLiteMallUserFormid(LiteMallUserFormidEntity liteMallUserFormid);

    LiteMallUserFormidEntity getLiteMallUserFormidById(Long id);

    int updateLiteMallUserFormid(LiteMallUserFormidEntity liteMallUserFormid);

    int batchRemove(Long[] id);

    LiteMallUserFormidEntity queryByOpenId(Map<String, Object> params);

    int updateUserFormId(LiteMallUserFormidEntity userFormid);
}
