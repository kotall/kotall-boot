package com.kotall.rms.common.entity.sys;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/**
 * 角色
 *
 * @author skyarac
 * @date 2018年01月10日 下午21:20:48
 * @version 1.0.0
 */
@Getter
@Setter
@ToString
public class SysRoleEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 角色id
	 */
	private Long roleId;
	
	/**
	 * 机构id
	 */
	private Long orgId;
	
	/**
	 * 机构名称
	 */
	private String orgName;

	/**
	 * 角色名称
	 */
	private String roleName;
	
	/**
	 * 角色标识
	 */
	private String roleSign;

	/**
	 * 备注
	 */
	private String remark;
	
	/**
	 * 创建者id
	 */
	private Long userIdCreate;
	
	private List<Long> menuIdList;
	
	private List<Long> orgIdList;
	
	/**
	 * 创建时间
	 */
	private Timestamp createTime;
	
	/**
	 * 修改时间
	 */
	private Timestamp updateTime;

}
