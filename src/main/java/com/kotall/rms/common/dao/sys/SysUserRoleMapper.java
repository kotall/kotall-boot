package com.kotall.rms.common.dao.sys;

import java.util.List;

import com.kotall.rms.common.dao.BaseMapper;
import com.kotall.rms.common.entity.sys.SysUserRoleEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户与角色关系
 *
 * @author aracwong
 * @date 2017年8月13日 上午1:01:55
 */
@Mapper
public interface SysUserRoleMapper extends BaseMapper<SysUserRoleEntity> {

	List<Integer> queryRoleIdList(Integer userId);
	
	int batchRemoveByUserId(Integer[] id);
	
	int batchRemoveByRoleId(Integer[] id);

}
