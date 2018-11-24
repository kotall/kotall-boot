package com.kotall.rms.common.dao.sys;

import java.util.List;

import com.kotall.rms.common.entity.sys.SysRoleOrgEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 角色与机构的关系
 *
 * @author aracwong
 * @date 2017年8月17日 上午11:29:43
 */
@Mapper
public interface SysRoleOrgMapper extends BaseMapper<SysRoleOrgEntity> {

	List<Integer> listOrgId(Integer roleId);
	
	int batchRemoveByOrgId(Integer[] id);
	
	int batchRemoveByRoleId(Integer[] id);


    List<Integer> queryOrgIdList(Integer[] roleIds);
}
