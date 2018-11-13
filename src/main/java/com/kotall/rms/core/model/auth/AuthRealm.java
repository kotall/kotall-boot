package com.kotall.rms.core.model.auth;

import com.kotall.rms.common.entity.sys.SysUserEntity;
import com.kotall.rms.common.manager.sys.SysUserManager;
import com.kotall.rms.web.auth.AuthToken;
import com.kotall.rms.web.util.ShiroUtils;
import com.kotall.rms.common.entity.sys.SysUserTokenEntity;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Set;


/**
 * 认证
 *
 * @author aracwong
 * @date 2017年9月3日 上午3:24:29
 * @since 1.0.0
 */
@Component
public class AuthRealm extends AuthorizingRealm {
	
	@Autowired
	private SysUserManager sysUserManager;

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof AuthToken;
    }

    /**
     * 授权(验证权限时调用)
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
    	Long userId = ShiroUtils.getUserId();
		// 用户角色
		Set<String> rolesSet = sysUserManager.listUserRoles(userId);
		// 用户权限
        Set<String> permsSet;
        System.out.println("================= " + userId);
        if (1L == userId) {
            permsSet = sysUserManager.listUserPerms(null);
        } else {
            permsSet = sysUserManager.listUserPerms(userId);
        }
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.setRoles(rolesSet);
		info.setStringPermissions(permsSet);
		return info;
    }

    /**
     * 认证(登录时调用)
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String accessToken = (String) token.getPrincipal();

        //根据accessToken，查询用户信息
        SysUserTokenEntity tokenEntity = sysUserManager.getByToken(accessToken);
        //token失效
        if(tokenEntity == null || tokenEntity.getExpireTime().getTime() < System.currentTimeMillis()){
            throw new IncorrectCredentialsException("token失效，请重新登录");
        }

        //查询用户信息
        SysUserEntity user = sysUserManager.getById(tokenEntity.getUserId());
        //账号锁定
        if(user.getStatus() == 0){
            throw new LockedAccountException("账号已被锁定,请联系管理员");
        }

        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, accessToken, getName());
        return info;
    }
}
