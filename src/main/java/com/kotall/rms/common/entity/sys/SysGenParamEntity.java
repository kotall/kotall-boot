package com.kotall.rms.common.entity.sys;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 代码生成器请求参数
 *
 * @author skyarac
 * @date 2018年01月10日 下午21:20:48
 * @version 1.0.0
 */
@Getter
@Setter
@ToString
public class SysGenParamEntity {

	private String[] tables;
	
	/**
	 * 系统模块，用户管理 shiro
	 */
	private String module;
	
	/**
	 * 功能编码，用户管理 user
	 */
	private String functionCode;
	
	/**
	 * 后台请求地址，用户管理 sys/user
	 */
	private String requestMapping;
	
	/**
	 * 页面路径，用户管理 base/user
	 */
	private String viewPath;
	
	/**
	 * 生成类型，1：生成包结构，2：只生成源代码
	 */
	private String type;

}
