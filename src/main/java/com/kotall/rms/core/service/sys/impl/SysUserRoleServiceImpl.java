package com.kotall.rms.core.service.sys.impl;

import com.kotall.rms.common.dao.sys.SysUserRoleMapper;
import com.kotall.rms.core.service.sys.SysUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zpwang
 * @version 1.0.0
 */
@Service("sysUserRoleService")
public class SysUserRoleServiceImpl implements SysUserRoleService {

    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;

    @Override
    public List<Long> queryRoleIdList(Long userId) {
        return this.sysUserRoleMapper.queryRoleIdList(userId);
    }
}
