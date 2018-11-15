package com.kotall.rms.common.dao.sys;

import java.util.List;

import com.kotall.rms.common.utils.Query;
import com.kotall.rms.common.entity.sys.SysUserEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 系统用户dao
 *
 * @author aracwong
 * @date 2017年8月8日 下午3:26:05
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUserEntity> {

	SysUserEntity getByUserName(String username);
	
	List<Long> listAllMenuId(Long userId);
	
	int updatePasswordByUser(Query query);
	
	int updateUserStatus(Query query);
	
	int updatePassword(SysUserEntity user);
	
}
