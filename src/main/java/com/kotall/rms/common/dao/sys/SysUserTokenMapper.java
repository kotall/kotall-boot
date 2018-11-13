package com.kotall.rms.common.dao.sys;

import com.kotall.rms.common.entity.sys.SysUserTokenEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户token
 *
 * @author aracwong
 * @date 2017年9月3日 上午3:29:17
 */
@Mapper
public interface SysUserTokenMapper extends BaseMapper<SysUserTokenEntity> {

	SysUserTokenEntity getByToken(String token);
	
	SysUserTokenEntity getByUserId(Long userId);
	
}
