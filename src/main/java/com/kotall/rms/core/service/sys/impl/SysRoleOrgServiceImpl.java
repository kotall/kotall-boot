package com.kotall.rms.core.service.sys.impl;

import com.kotall.rms.common.dao.sys.SysRoleOrgMapper;
import com.kotall.rms.core.service.sys.SysRoleOrgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zpwang
 * @version 1.0.0
 */
@Service("sysRoleOrgService")
public class SysRoleOrgServiceImpl implements SysRoleOrgService {

    @Autowired
    private SysRoleOrgMapper sysRoleOrgMapper;

    @Override
    public List<Integer> queryOrgIdListByRoleIds(Integer[] roleIds) {
        return this.sysRoleOrgMapper.queryOrgIdList(roleIds);
    }
}
