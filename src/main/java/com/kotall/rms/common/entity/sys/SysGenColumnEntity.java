package com.kotall.rms.common.entity.sys;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 数据表列属性
 *
 * @author skyarac
 * @date 2018年01月10日 下午21:20:48
 * @version 1.0.0
 */
@Getter
@Setter
@ToString
public class SysGenColumnEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 列名
	 */
	private String columnName;
	
	/**
	 * 数据类型
	 */
	private String dataType;
	
	/**
	 * 列注释
	 */
	private String columnComment;
	
	/**
	 * 属性名，作为类属性名（userId）
	 */
	private String fieldName;
	
	/**
	 * 属性名，作为类方法名（UserId）
	 */
	private String methodName;
	
	/**
	 * 列数据类型对应java数据类型
	 */
	private String fieldType;
	
	/**
	 * 键类型标识
	 */
	private String columnKey;
	
	/**
	 * 自增标识 auto_increment
	 */
	private String extra;

}
