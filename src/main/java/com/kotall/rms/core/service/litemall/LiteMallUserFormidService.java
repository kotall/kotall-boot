package com.kotall.rms.core.service.litemall;

import com.kotall.rms.common.entity.litemall.LiteMallUserFormidEntity;
import com.kotall.rms.core.service.BaseService;

import java.util.Map;

/**
 * 
 *
 * @author kotall
 * @date 2018年11月20日 下午1:56:37
 * @since 1.0.0
 */
public interface LiteMallUserFormidService extends BaseService<LiteMallUserFormidEntity>{

    LiteMallUserFormidEntity queryByOpenId(Map<String, Object> params);

    boolean updateUserFormId(LiteMallUserFormidEntity userFormid);
}
