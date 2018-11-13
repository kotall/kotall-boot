package com.kotall.rms.common.entity.litemall;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;



/**
 * 专题表
 *
 * @author kotall
 * @email kotall@admin.com
 * @date 2018年11月13日 下午6:17:39
 */
public class LiteMallTopicEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	private Integer id;
	
	/**
	 * 专题标题
	 */
	private String title;
	
	/**
	 * 专题子标题
	 */
	private String subtitle;
	
	/**
	 * 专题内容，富文本格式
	 */
	private String content;
	
	/**
	 * 专题相关商品最低价
	 */
	private BigDecimal price;
	
	/**
	 * 专题阅读量
	 */
	private String readCount;
	
	/**
	 * 专题图片
	 */
	private String picUrl;
	
	/**
	 * 排序
	 */
	private Integer sortOrder;
	
	/**
	 * 专题相关商品，采用JSON数组格式
	 */
	private String goods;
	
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
	

	public LiteMallTopicEntity() {
		super();
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}
	
	public String getSubtitle() {
		return subtitle;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	public BigDecimal getPrice() {
		return price;
	}
	
	public void setReadCount(String readCount) {
		this.readCount = readCount;
	}
	
	public String getReadCount() {
		return readCount;
	}
	
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	
	public String getPicUrl() {
		return picUrl;
	}
	
	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
	}
	
	public Integer getSortOrder() {
		return sortOrder;
	}
	
	public void setGoods(String goods) {
		this.goods = goods;
	}
	
	public String getGoods() {
		return goods;
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
