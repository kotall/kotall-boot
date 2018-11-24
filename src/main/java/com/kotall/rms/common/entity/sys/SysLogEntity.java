package com.kotall.rms.common.entity.sys;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.sql.Timestamp;


/**
 * 系统日志
 *
 * @author skyarac
 * @date 2018年01月10日 下午21:20:48
 * @version 1.0.0
 */
@Getter
@Setter
@ToString
public class SysLogEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 日志id
	 */
	private Integer id;
	
	/**
	 * 操作用户id
	 */
	private Integer userId;
	
	/**
	 * 操作用户
	 */
	private String username;
	
	/**
	 * 操作
	 */
	private String operation;
	
	/**
	 * 方法
	 */
	private String method;
	
	/**
	 * 参数
	 */
	private String params;
	
	/**
	 * 耗时
	 */
	private Long time;
	
	/**
	 * 操作ip地址
	 */
	private String ip;
	
	/**
	 * 创建时间
	 */
	private Timestamp createTime;

}
