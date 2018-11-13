package com.kotall.rms.common.entity.sys;

import java.io.Serializable;

/**
 * 系统配置信息表
 *
 * @author kotall
 * @date 2018年11月12日 下午9:18:45
 */
public class SysConfigEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	private Long id;
	
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
	

	public SysConfigEntity() {
		super();
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setParamKey(String paramKey) {
		this.paramKey = paramKey;
	}
	
	public String getParamKey() {
		return paramKey;
	}
	
	public void setParamValue(String paramValue) {
		this.paramValue = paramValue;
	}
	
	public String getParamValue() {
		return paramValue;
	}
	
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public Integer getStatus() {
		return status;
	}
	
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public String getRemark() {
		return remark;
	}
	
}
