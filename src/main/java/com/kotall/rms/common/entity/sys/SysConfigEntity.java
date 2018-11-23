package com.kotall.rms.common.entity.sys;

import lombok.Data;

import java.io.Serializable;

/**
 * 系统配置信息表
 *
 * @author kotall
 * @date 2018年11月12日 下午9:18:45
 */
@Data
public class SysConfigEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	private Integer id;
	
	/**
	 * key
	 */
	private String paramKey;
	
	/**
	 * value
	 */
	private String paramValue;
	
	/**
	 * 状态   0：隐藏   1：显示
	 */
	private Integer status;
	
	/**
	 * 备注
	 */
	private String remark;
	
}
