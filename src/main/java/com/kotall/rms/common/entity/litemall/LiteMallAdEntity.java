package com.kotall.rms.common.entity.litemall;

import java.io.Serializable;
import java.util.Date;



/**
 * 广告表
 *
 * @author kotall
 * @email kotall@admin.com
 * @date 2018年11月13日 下午6:08:21
 */
public class LiteMallAdEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	private Integer id;
	
	/**
	 * 广告标题
	 */
	private String name;
	
	/**
	 * 所广告的商品页面或者活动页面链接地址
	 */
	private String link;
	
	/**
	 * 广告宣传图片
	 */
	private String url;
	
	/**
	 * 广告位置：1则是首页
	 */
	private Integer position;
	
	/**
	 * 活动内容
	 */
	private String content;
	
	/**
	 * 广告开始时间
	 */
	private Date startTime;
	
	/**
	 * 广告结束时间
	 */
	private Date endTime;
	
	/**
	 * 是否启动
	 */
	private Integer enabled;
	
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
	

	public LiteMallAdEntity() {
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
	
	public void setLink(String link) {
		this.link = link;
	}
	
	public String getLink() {
		return link;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setPosition(Integer position) {
		this.position = position;
	}
	
	public Integer getPosition() {
		return position;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	
	public Date getStartTime() {
		return startTime;
	}
	
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
	public Date getEndTime() {
		return endTime;
	}
	
	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
	}
	
	public Integer getEnabled() {
		return enabled;
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
