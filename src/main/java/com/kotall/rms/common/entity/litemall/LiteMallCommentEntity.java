package com.kotall.rms.common.entity.litemall;

import java.io.Serializable;
import java.util.Date;



/**
 * 评论表
 *
 * @author kotall
 * @email kotall@admin.com
 * @date 2018年11月13日 下午4:55:35
 */
public class LiteMallCommentEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	private Integer id;
	
	/**
	 * 如果type=0，则是商品评论；如果是type=1，则是专题评论。
	 */
	private Integer valueId;
	
	/**
	 * 评论类型，如果type=0，则是商品评论；如果是type=1，则是专题评论；如果type=3，则是订单商品评论。
	 */
	private Integer type;
	
	/**
	 * 评论内容
	 */
	private String content;
	
	/**
	 * 用户表的用户ID
	 */
	private Integer userId;
	
	/**
	 * 是否含有图片
	 */
	private Integer hasPicture;
	
	/**
	 * 图片地址列表，采用JSON数组格式
	 */
	private String picUrls;
	
	/**
	 * 评分， 1-5
	 */
	private Integer star;
	
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
	

	public LiteMallCommentEntity() {
		super();
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setValueId(Integer valueId) {
		this.valueId = valueId;
	}
	
	public Integer getValueId() {
		return valueId;
	}
	
	public void setType(Integer type) {
		this.type = type;
	}
	
	public Integer getType() {
		return type;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	public Integer getUserId() {
		return userId;
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
	
	public void setStar(Integer star) {
		this.star = star;
	}
	
	public Integer getStar() {
		return star;
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
