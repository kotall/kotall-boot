package com.kotall.rms.common.entity.litemall;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 *
 * @author kotall
 * @email kotall@admin.com
 * @date 2018年11月13日 下午6:32:18
 */
public class LiteMallGrouponEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	private Integer id;
	
	/**
	 * 关联的订单ID
	 */
	private Integer orderId;
	
	/**
	 * 参与的团购ID，仅当user_type不是1
	 */
	private Integer grouponId;
	
	/**
	 * 团购规则ID，关联litemall_groupon_rules表ID字段
	 */
	private Integer rulesId;
	
	/**
	 * 用户ID
	 */
	private Integer userId;
	
	/**
	 * 创建者ID
	 */
	private Integer creatorUserId;
	
	/**
	 * 创建时间
	 */
	private Date addTime;
	
	/**
	 * 更新时间
	 */
	private Date updateTime;
	
	/**
	 * 团购分享图片地址
	 */
	private String shareUrl;
	
	/**
	 * 是否已经支付
	 */
	private Integer payed;
	
	/**
	 * 逻辑删除
	 */
	private Integer deleted;
	

	public LiteMallGrouponEntity() {
		super();
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	
	public Integer getOrderId() {
		return orderId;
	}
	
	public void setGrouponId(Integer grouponId) {
		this.grouponId = grouponId;
	}
	
	public Integer getGrouponId() {
		return grouponId;
	}
	
	public void setRulesId(Integer rulesId) {
		this.rulesId = rulesId;
	}
	
	public Integer getRulesId() {
		return rulesId;
	}
	
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	public Integer getUserId() {
		return userId;
	}
	
	public void setCreatorUserId(Integer creatorUserId) {
		this.creatorUserId = creatorUserId;
	}
	
	public Integer getCreatorUserId() {
		return creatorUserId;
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
	
	public void setShareUrl(String shareUrl) {
		this.shareUrl = shareUrl;
	}
	
	public String getShareUrl() {
		return shareUrl;
	}
	
	public void setPayed(Integer payed) {
		this.payed = payed;
	}
	
	public Integer getPayed() {
		return payed;
	}
	
	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}
	
	public Integer getDeleted() {
		return deleted;
	}
	
}
