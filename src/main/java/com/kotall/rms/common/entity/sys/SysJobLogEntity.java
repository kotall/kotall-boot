package com.kotall.rms.common.entity.sys;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 定时任务日志
 *
 * @author skyarac
 * @date 2018年01月10日 下午21:20:48
 * @version 1.0.0
 */
@Getter
@Setter
@ToString
public class SysJobLogEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 记录id
	 */
	private Integer logId;
	
	/**
	 * 任务id
	 */
	private Integer jobId;
	
	/**
	 * spring bean 名称
	 */
	private String beanName;
	
	/**
	 * 方法名
	 */
	private String methodName;
	
	/**
	 * 参数
	 */
	private String params;
	
	/**
	 * 状态，0：失败，1：成功
	 */
	private Integer status;
	
	/**
	 * 错误信息
	 */
	private String error;
	
	/**
	 * 耗时（ms）
	 */
	private Integer times;
	
	/**
	 * 创建时间
	 */
	private Timestamp createTime;

}
