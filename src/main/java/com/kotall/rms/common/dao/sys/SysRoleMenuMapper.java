package com.kotall.rms.common.dao.sys;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kotall.rms.common.entity.sys.SysRoleMenuEntity;

/**
 * 系统角色与菜单关系
 *
 * @author aracwong
 * @date 2017年8月13日 下午8:32:26
 */
@Mapper
public interface SysRoleMenuMapper extends BaseMapper<SysRoleMenuEntity> {

	int batchRemoveByMenuId(Integer[] id);
	
	int batchRemoveByRoleId(Integer[] id);
	
	List<Integer> listMenuId(Integer id);
	
}
