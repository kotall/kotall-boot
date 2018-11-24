package com.kotall.rms.core.service.litemall;

import com.kotall.rms.common.entity.litemall.LiteMallUserEntity;
import com.kotall.rms.common.utils.Page;
import com.kotall.rms.core.service.BaseService;

import java.util.List;
import java.util.Map;

/**
 * 用户表
 *
 * @author kotall
 * @date 2018年11月13日 上午10:18:32
 * @since 1.0.0
 */
public interface LiteMallUserService extends BaseService<LiteMallUserEntity> {

    Page<LiteMallUserEntity> queryUserByPage(Map<String, Object> params);

    List<LiteMallUserEntity> queryByUsername(Integer storeId, String username);

    List<LiteMallUserEntity> queryByOpenId(Integer storeId, String openId);

    List<LiteMallUserEntity> queryByMobile(String mobile);
}
