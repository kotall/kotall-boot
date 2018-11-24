package com.kotall.rms.common.entity.sys;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;


/**
 * 组织架构
 *
 * @author skyarac
 * @date 2018年01月10日 下午21:20:48
 * @version 1.0.0
 */
@Getter
@Setter
@ToString
public class SysOrgEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 机构id
	 */
	private Integer orgId;
	
	/**
	 * 上级机构id，一级部门为0
	 */
	private Integer parentId;
	
	/**
	 * 上级机构名称
	 */
	private String parentName;
	
	/**
	 * 机构编码
	 */
	private String code;
	
	/**
	 * 机构名称
	 */
	private String name;
	
	/**
	 * 排序
	 */
	private Integer orderNum;
	
	/**
	 * 可用标识，1：可用，0：不可用
	 */
	private Integer status;
	
	/**
	 * 创建时间
	 */
	private Timestamp createTime;
	
	/**
	 * 修改时间
	 */
	private Timestamp updateTime;
	
	/**
	 * ztree属性
	 */
	private Boolean open;
	
	private List<?> list;

}
