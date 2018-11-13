package com.kotall.rms.common.entity.litemall;

import java.io.Serializable;
import java.util.Date;



/**
 * 意见反馈表
 *
 * @author kotall
 * @email kotall@admin.com
 * @date 2018年11月13日 下午2:33:08
 */
public class LiteMallFeedbackEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	private Integer id;
	
	/**
	 * 用户表的用户ID
	 */
	private Integer userId;
	
	/**
	 * 用户名称
	 */
	private String username;
	
	/**
	 * 手机号
	 */
	private String mobile;
	
	/**
	 * 反馈类型
	 */
	private String feedType;
	
	/**
	 * 反馈内容
	 */
	private String content;
	
	/**
	 * 状态
	 */
	private Integer status;
	
	/**
	 * 是否含有图片
	 */
	private Integer hasPicture;
	
	/**
	 * 图片地址列表，采用JSON数组格式
	 */
	private String picUrls;
	
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
	

	public LiteMallFeedbackEntity() {
		super();
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	public Integer getUserId() {
		return userId;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	public String getMobile() {
		return mobile;
	}
	
	public void setFeedType(String feedType) {
		this.feedType = feedType;
	}
	
	public String getFeedType() {
		return feedType;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public Integer getStatus() {
		return status;
	}
	
	public void setHasPicture(Integer hasPicture) {
		this.hasPicture = hasPicture;
	}
	
	public Integer getHasPicture() {
		return hasPicture;
	}
	
	public void setPicUrls(String picUrls) {
		this.picUrls = picUrls;
	}
	
	public String getPicUrls() {
		return picUrls;
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
