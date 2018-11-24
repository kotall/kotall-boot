package com.kotall.rms.common.dao.sys;

import java.util.List;

import com.kotall.rms.common.dao.BaseMapper;
import com.kotall.rms.common.entity.sys.SysRoleEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 系统角色
 *
 * @author aracwong
 * @date 2017年8月12日 上午12:35:51
 */
@Mapper
public interface SysRoleMapper extends BaseMapper<SysRoleEntity> {
	
	List<String> listUserRoles(Integer userId);
	
}
