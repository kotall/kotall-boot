package com.kotall.rms.common.entity.sys;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/**
 * 菜单
 *
 * @author skyarac
 * @date 2018年01月10日 下午21:20:48
 * @version 1.0.0
 */
@Getter
@Setter
@ToString
public class SysMenuEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;

	/**
	 * 菜单id
	 */
	private Long menuId;
	
	/**
	 * 父级id，一级菜单为0
	 */
	private Long parentId;

	/**
	 * 菜单编码
	 */
	private String code;
	
	/**
	 * 父级菜单名称
	 */
	private String parentName;
	
	/**
	 * 菜单名称
	 */
	private String name;
	
	/**
	 * 菜单url
	 */
	private String url;
	
	/**
	 * 授权标识(多个用逗号分隔，如：user:list,user:create)
	 */
	private String perms;
	
	/**
	 * 类型(0：目录   1：菜单   2：按钮)
	 */
	private Integer type;
	
	/**
	 * 菜单图标
	 */
	private String icon;
	
	/**
	 * 排序
	 */
	private Integer orderNum;
	
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
