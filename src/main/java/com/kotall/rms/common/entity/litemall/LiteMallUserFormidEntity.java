package com.kotall.rms.common.entity.litemall;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 *
 * @author kotall
 * @email kotall@admin.com
 * @date 2018年11月20日 下午1:56:37
 */
public class LiteMallUserFormidEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	private Integer id;
	
	/**
	 * 店铺ID
	 */
	private Integer storeId;
	
	/**
	 * 缓存的FormId
	 */
	private String formid;
	
	/**
	 * 是FormId还是prepayId
	 */
	private Integer isprepay;
	
	/**
	 * 可用次数，fromId为1，prepay为3，用1次减1
	 */
	private Integer useamount;
	
	/**
	 * 过期时间，腾讯规定为7天
	 */
	private Date expireTime;
	
	/**
	 * 微信登录openid
	 */
	private String openid;
	
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
	

	public LiteMallUserFormidEntity() {
		super();
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}
	
	public Integer getStoreId() {
		return storeId;
	}
	
	public void setFormid(String formid) {
		this.formid = formid;
	}
	
	public String getFormid() {
		return formid;
	}
	
	public void setIsprepay(Integer isprepay) {
		this.isprepay = isprepay;
	}
	
	public Integer getIsprepay() {
		return isprepay;
	}
	
	public void setUseamount(Integer useamount) {
		this.useamount = useamount;
	}
	
	public Integer getUseamount() {
		return useamount;
	}
	
	public void setExpireTime(Date expireTime) {
		this.expireTime = expireTime;
	}
	
	public Date getExpireTime() {
		return expireTime;
	}
	
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	
	public String getOpenid() {
		return openid;
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
