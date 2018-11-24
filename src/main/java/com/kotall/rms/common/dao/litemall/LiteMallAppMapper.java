package com.kotall.rms.common.dao.litemall;

import org.apache.ibatis.annotations.Mapper;

import com.kotall.rms.common.entity.litemall.LiteMallAppEntity;
import com.kotall.rms.common.dao.BaseMapper;

/**
 * app配置表
 *
 * @author kotall
 * @date 2018年11月19日 上午10:17:16
 * @since 1.0.0
 */
@Mapper
public interface LiteMallAppMapper extends BaseMapper<LiteMallAppEntity> {

    LiteMallAppEntity getObjectByAppId(String appId);

}
