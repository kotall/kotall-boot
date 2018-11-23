package com.kotall.rms.common.entity.sys;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 定时任务
 *
 * @author skyarac
 * @date 2018年01月10日 下午21:20:48
 * @version 1.0.0
 */
@Getter
@Setter
@ToString
public class SysJobEntity implements Serializable {

	private static final long serialVersionUID = 1L;

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
	 * cron表达式
	 */
	private String cronExpression;
	
	/**
	 * 状态，0：暂停，1：正常
	 */
	private Integer status;
	
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

}
