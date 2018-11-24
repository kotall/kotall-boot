package com.kotall.rms.common.entity.sys;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 角色与机构对应关系
 *
 * @author skyarac
 * @date 2018年01月10日 下午21:20:48
 * @version 1.0.0
 */
@Getter
@Setter
@ToString
public class SysRoleOrgEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 记录id
	 */
	private Integer id;

	/**
	 * 角色ID
	 */
	private Integer roleId;

	/**
	 * 机构ID
	 */
	private Integer orgId;

}
