package com.kotall.rms.common.entity.sys;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/**
 * 系统用户
 *
 * @author skyarac
 * @date 2018年01月10日 下午21:20:48
 * @version 1.0.0
 */
@Getter
@Setter
@ToString
public class SysUserEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;

	/**
	 * 用户id
	 */
	private Integer userId;
	
	/**
	 * 机构id
	 */
	private Integer orgId;
	
	/**
	 * 机构名称
	 */
	private String orgName;
	
	/**
	 * 用户名
	 */
	private String username;
	
	/**
	 * 密码
	 */
	private String password;
	
	/**
	 * 邮箱
	 */
	private String email;
	
	/**
	 * 手机号
	 */
	private String mobile;
	
	/**
	 * 状态(0：禁用   1：正常)
	 */
	private Integer status;
	
	/**
	 * 创建用户id
	 */
	private Integer userIdCreate;
	
	/**
	 * 备注
	 */
	private String remark;
	
	
	/**
	 * 创建时间
	 */
	private Timestamp createTime;
	
	/**
	 * 修改时间
	 */
	private Timestamp updateTime;
	
	/**
	 * 角色id列表
	 */
	private List<Integer> roleIdList;

}
