package com.kotall.rms.common.entity.sys;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/**
 * 数据表属性
 *
 * @author skyarac
 * @date 2018年01月10日 下午21:20:48
 * @version 1.0.0
 */
@Getter
@Setter
@ToString
public class SysGenTableEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 表名
	 */
	private String tableName;
	
	/**
	 * 表格备注
	 */
	private String tableComment;
	
	/**
	 * 主键
	 */
	private SysGenColumnEntity pk;
	
	/**
	 * 表格列
	 */
	private List<SysGenColumnEntity> columns;
	
	/**
	 * 类名，作为实例对象使用（sysUser）
	 */
	private String objName;
	
	/**
	 * 类名，作为类型使用（SysUser）
	 */
	private String className;
	
	/**
	 * 创建时间
	 */
	private Timestamp createTime;

}
