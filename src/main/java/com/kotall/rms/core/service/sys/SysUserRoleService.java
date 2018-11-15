package com.kotall.rms.core.service.sys;

import java.util.List;

/**
 * @author zpwang
 * @version 1.0.0
 */
public interface SysUserRoleService {

    List<Long> queryRoleIdList(Long userId);
}
