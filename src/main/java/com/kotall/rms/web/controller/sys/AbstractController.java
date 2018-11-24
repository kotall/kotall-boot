package com.kotall.rms.web.controller.sys;

import com.kotall.rms.common.entity.sys.SysUserEntity;

import com.kotall.rms.web.util.ShiroUtils;

/**
 * Controller公共组件
 *
 * @author aracwong
 * @date 2017年8月8日 下午2:43:23
 */
public abstract class AbstractController {

	/**
	 * 超级管理员ID
	 */
	public static final long SUPER_ADMIN = 1;

	protected SysUserEntity getUser() {
		return ShiroUtils.getUserEntity();
	}

	protected Integer getUserId() {
		return getUser().getUserId();
	}
	
}
