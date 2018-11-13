package com.kotall.rms.common.entity.sys;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/**
 * 通用字典
 *
 * @author skyarac
 * @date 2018年01月10日 下午21:20:48
 * @version 1.0.0
 */
@Getter
@Setter
@ToString
public class SysDictEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 字典id
	 */
	private Long dictId;
	
	/**
	 * 类型id
	 */
	private Long typeId;
	
	/**
	 * 类型名称
	 */
	private String typeName;
	
	/**
	 * 字典码
	 */
	private String name;
	
	/**
	 * 字典值
	 */
	private String value;
	
	/**
	 * 状态(1:显示, 0:隐藏)
	 */
	private Integer status;
	
	/**
	 * 类型(1:参数, 0:目录)
	 */
	private Integer type;
	
	/**
	 * 排序
	 */
	private Integer orderNum;
	
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
	 * ztree属性
	 */
	private Boolean open;
	
	private List<?> list;

}
