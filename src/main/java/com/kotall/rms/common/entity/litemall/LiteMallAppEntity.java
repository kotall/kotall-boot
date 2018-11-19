package com.kotall.rms.common.entity.litemall;

import java.io.Serializable;
import java.util.Date;



/**
 * app配置表
 *
 * @author kotall
 * @email kotall@admin.com
 * @date 2018年11月19日 上午10:17:16
 */
public class LiteMallAppEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 主键
	 */
	private Integer id;
	
	/**
	 * appID
	 */
	private String appId;
	
	/**
	 * 店铺ID
	 */
	private String storeId;
	
	/**
	 * 版本
	 */
	private String version;
	
	/**
	 * 创建时间
	 */
	private Date createdTime;
	
	/**
	 * 更新时间
	 */
	private Date updatedTime;
	

	public LiteMallAppEntity() {
		super();
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setAppId(String appId) {
		this.appId = appId;
	}
	
	public String getAppId() {
		return appId;
	}
	
	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}
	
	public String getStoreId() {
		return storeId;
	}
	
	public void setVersion(String version) {
		this.version = version;
	}
	
	public String getVersion() {
		return version;
	}
	
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	
	public Date getCreatedTime() {
		return createdTime;
	}
	
	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}
	
	public Date getUpdatedTime() {
		return updatedTime;
	}
	
}
