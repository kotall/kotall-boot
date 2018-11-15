package com.kotall.rms.core.manager.sys.impl;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.kotall.rms.common.utils.Query;
import com.kotall.rms.common.dao.sys.SysUserMapper;
import com.kotall.rms.common.entity.sys.SysUserEntity;
import com.kotall.rms.core.manager.sys.SysUserManager;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kotall.rms.core.enums.StatusType;
import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.dao.sys.SysMenuMapper;
import com.kotall.rms.common.dao.sys.SysRoleMapper;
import com.kotall.rms.common.dao.sys.SysUserRoleMapper;
import com.kotall.rms.common.dao.sys.SysUserTokenMapper;
import com.kotall.rms.common.entity.sys.SysUserTokenEntity;
import com.kotall.rms.web.auth.TokenGenerator;
import org.springframework.transaction.annotation.Transactional;

/**
 * 系统用户
 *
 * @author aracwong
 * @date 2017年8月11日 上午11:44:21
 */
@Component("sysUserManager")
public class SysUserManagerImpl implements SysUserManager {

    /**
     * token过期时间，12小时
     */
    private final static int TOKEN_EXPIRE = 1000 * 60 * 60 * 12;

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private SysMenuMapper sysMenuMapper;

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;

    @Autowired
    private SysUserTokenMapper sysUserTokenMapper;

    @Override
    public List<SysUserEntity> listUser(Page<SysUserEntity> page, Query search) {
        return sysUserMapper.listForPage(page, search);
    }

    @Override
    public SysUserEntity getByUserName(String username) {
        return sysUserMapper.getByUserName(username);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int saveUser(SysUserEntity user) {
        int count = sysUserMapper.save(user);
        Query query = new Query();
        query.put("userId", user.getUserId());
        query.put("roleIdList", user.getRoleIdList());
        sysUserRoleMapper.save(query);
        return count;
    }

    @Override
    public SysUserEntity getById(Long userId) {
        SysUserEntity user = sysUserMapper.getObjectById(userId);
        user.setRoleIdList(sysUserRoleMapper.queryRoleIdList(userId));
        return user;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateUser(SysUserEntity user) {
        int count = sysUserMapper.update(user);
        Long userId = user.getUserId();
        sysUserRoleMapper.remove(userId);
        Query query = new Query();
        query.put("userId", userId);
        query.put("roleIdList", user.getRoleIdList());
        sysUserRoleMapper.save(query);
        return count;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int batchRemove(Long[] id) {
        int count = sysUserMapper.batchRemove(id);
        sysUserRoleMapper.batchRemoveByUserId(id);
        return count;
    }

    @Override
    public Set<String> listUserPerms(Long userId) {
        List<String> perms;
        if (null == userId) {
            perms = sysMenuMapper.listAllPerms();
        } else {
            perms = sysMenuMapper.listUserPerms(userId);
        }
        Set<String> permsSet = new HashSet<>();
        for (String perm : perms) {
            if (StringUtils.isNotBlank(perm)) {
                permsSet.addAll(Arrays.asList(perm.trim().split(",")));
            }
        }
        return permsSet;
    }

    @Override
    public Set<String> listUserRoles(Long userId) {
        List<String> roles = sysRoleMapper.listUserRoles(userId);
        Set<String> rolesSet = new HashSet<>();
        for (String role : roles) {
            if (StringUtils.isNotBlank(role)) {
                rolesSet.addAll(Arrays.asList(role.trim().split(",")));
            }
        }
        return rolesSet;
    }

    @Override
    public int updatePwdByUser(Query query) {
        return sysUserMapper.updatePasswordByUser(query);
    }

    @Override
    public int updateUserEnable(Long[] id) {
        Query query = new Query();
        query.put("status", StatusType.ENABLE.getValue());
        query.put("id", id);
        int count = sysUserMapper.updateUserStatus(query);
        return count;
    }

    @Override
    public int updateUserDisable(Long[] id) {
        Query query = new Query();
        query.put("status", StatusType.DISABLE.getValue());
        query.put("id", id);
        int count = sysUserMapper.updateUserStatus(query);
        return count;
    }

    @Override
    public int updatePwd(SysUserEntity user) {
        return sysUserMapper.updatePassword(user);
    }

    @Override
    public SysUserEntity getUserById(Long userId) {//不包含角色信息
        return sysUserMapper.getObjectById(userId);
    }

    @Override
    public SysUserTokenEntity getByToken(String token) {
        return sysUserTokenMapper.getByToken(token);
    }

    @Override
    public SysUserTokenEntity saveUserToken(Long userId) {
        //生成token
        String token = TokenGenerator.generateValue();
        //当前时间
        Date now = new Date();
        Date gmtExpire = new Date(now.getTime() + TOKEN_EXPIRE);
        SysUserTokenEntity userToken = sysUserTokenMapper.getByUserId(userId);
        if (userToken == null) {
            userToken = new SysUserTokenEntity();
            userToken.setUserId(userId);
            userToken.setToken(token);
            userToken.setExpireTime(gmtExpire);
            userToken.setUpdateTime(now);
            sysUserTokenMapper.save(userToken);
        } else {
            userToken.setToken(token);
            userToken.setExpireTime(gmtExpire);
            userToken.setUpdateTime(now);
            sysUserTokenMapper.update(userToken);
        }
        return userToken;
    }

    @Override
    public int updateUserToken(Long userId) {
        String token = TokenGenerator.generateValue();
        SysUserTokenEntity userToken = new SysUserTokenEntity();
        userToken.setUserId(userId);
        userToken.setToken(token);
        return sysUserTokenMapper.update(userToken);
    }

}
