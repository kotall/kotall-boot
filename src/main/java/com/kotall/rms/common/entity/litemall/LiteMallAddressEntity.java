package com.kotall.rms.common.entity.litemall;

import java.io.Serializable;
import java.util.Date;



/**
 * 收货地址表
 *
 * @author kotall
 * @email kotall@admin.com
 * @date 2018年11月13日 上午11:28:53
 */
public class LiteMallAddressEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	private Integer id;
	
	/**
	 * 收货人名称
	 */
	private String name;
	
	/**
	 * 用户表的用户ID
	 */
	private Integer userId;
	
	/**
	 * 行政区域表的省ID
	 */
	private Integer provinceId;
	
	/**
	 * 行政区域表的市ID
	 */
	private Integer cityId;
	
	/**
	 * 行政区域表的区县ID
	 */
	private Integer areaId;
	
	/**
	 * 具体收货地址
	 */
	private String address;
	
	/**
	 * 手机号码
	 */
	private String mobile;
	
	/**
	 * 是否默认地址
	 */
	private Integer isDefault;
	
	/**
	 * 创建时间
	 */
	private Date addTime;
	
	/**
	 * 更新时间
	 */
	private Date updateTime;
	
	/**
	 * 逻辑删除
	 */
	private Integer deleted;
	

	public LiteMallAddressEntity() {
		super();
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	public Integer getUserId() {
		return userId;
	}
	
	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}
	
	public Integer getProvinceId() {
		return provinceId;
	}
	
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	
	public Integer getCityId() {
		return cityId;
	}
	
	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}
	
	public Integer getAreaId() {
		return areaId;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	public String getMobile() {
		return mobile;
	}
	
	public void setIsDefault(Integer isDefault) {
		this.isDefault = isDefault;
	}
	
	public Integer getIsDefault() {
		return isDefault;
	}
	
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
	
	public Date getAddTime() {
		return addTime;
	}
	
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	public Date getUpdateTime() {
		return updateTime;
	}
	
	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}
	
	public Integer getDeleted() {
		return deleted;
	}
	
}
