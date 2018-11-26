package com.kotall.rms.core.service.sys;

import com.kotall.rms.common.entity.sys.SysRoleEntity;
import com.kotall.rms.common.utils.Page;
import com.kotall.rms.core.service.BaseService;

import java.util.List;
import java.util.Map;

/**
 * 系统角色
 *
 * @author aracwong
 * @date 2017年8月12日 上午12:40:42
 */
public interface SysRoleService extends BaseService<SysRoleEntity> {

	Page<SysRoleEntity> queryRoleByPage(Map<String, Object> params);

	SysRoleEntity getRoleById(Integer id);

	List<SysRoleEntity> queryAll();

	int batchRemove(Integer[] id);

	int updateRoleOptAuthorization(SysRoleEntity role);

	int updateRoleDataAuthorization(SysRoleEntity role);

}
