package com.kotall.rms.core.service.sys;

import java.util.List;

/**
 * @author zpwang
 * @version 1.0.0
 */
public interface SysRoleOrgService {

    /**
     * 根据role_id 查询机构列表
     * @param roleIds
     * @return
     */
    List<Integer> queryOrgIdListByRoleIds(Integer[] roleIds);
}
