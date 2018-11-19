package com.kotall.rms.common.entity.litemall;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;



/**
 * 商品基本信息表
 *
 * @author kotall
 * @email kotall@admin.com
 * @date 2018年11月19日 下午3:03:30
 */
public class LiteMallGoodsEntity implements Serializable {
	
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
	 * 商品编号
	 */
	private String goodsSn;
	
	/**
	 * 商品名称
	 */
	private String name;
	
	/**
	 * 商品所属类目ID
	 */
	private Integer categoryId;
	
	/**
	 * 
	 */
	private Integer brandId;
	
	/**
	 * 商品宣传图片列表，采用JSON数组格式
	 */
	private String gallery;
	
	/**
	 * 商品关键字，采用逗号间隔
	 */
	private String keywords;
	
	/**
	 * 商品简介
	 */
	private String brief;
	
	/**
	 * 是否上架
	 */
	private Integer isOnSale;
	
	/**
	 * 
	 */
	private Integer sortOrder;
	
	/**
	 * 商品页面商品图片
	 */
	private String picUrl;
	
	/**
	 * 商品分享朋友圈图片
	 */
	private String shareUrl;
	
	/**
	 * 是否新品首发，如果设置则可以在新品首发页面展示
	 */
	private Integer isNew;
	
	/**
	 * 是否人气推荐，如果设置则可以在人气推荐页面展示
	 */
	private Integer isHot;
	
	/**
	 * 商品单位，例如件、盒
	 */
	private String unit;
	
	/**
	 * 专柜价格
	 */
	private BigDecimal counterPrice;
	
	/**
	 * 零售价格
	 */
	private BigDecimal retailPrice;
	
	/**
	 * 商品详细介绍，是富文本格式
	 */
	private String detail;
	
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
	

	public LiteMallGoodsEntity() {
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
	
	public void setGoodsSn(String goodsSn) {
		this.goodsSn = goodsSn;
	}
	
	public String getGoodsSn() {
		return goodsSn;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	
	public Integer getCategoryId() {
		return categoryId;
	}
	
	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}
	
	public Integer getBrandId() {
		return brandId;
	}
	
	public void setGallery(String gallery) {
		this.gallery = gallery;
	}
	
	public String getGallery() {
		return gallery;
	}
	
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	
	public String getKeywords() {
		return keywords;
	}
	
	public void setBrief(String brief) {
		this.brief = brief;
	}
	
	public String getBrief() {
		return brief;
	}
	
	public void setIsOnSale(Integer isOnSale) {
		this.isOnSale = isOnSale;
	}
	
	public Integer getIsOnSale() {
		return isOnSale;
	}
	
	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
	}
	
	public Integer getSortOrder() {
		return sortOrder;
	}
	
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	
	public String getPicUrl() {
		return picUrl;
	}
	
	public void setShareUrl(String shareUrl) {
		this.shareUrl = shareUrl;
	}
	
	public String getShareUrl() {
		return shareUrl;
	}
	
	public void setIsNew(Integer isNew) {
		this.isNew = isNew;
	}
	
	public Integer getIsNew() {
		return isNew;
	}
	
	public void setIsHot(Integer isHot) {
		this.isHot = isHot;
	}
	
	public Integer getIsHot() {
		return isHot;
	}
	
	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	public String getUnit() {
		return unit;
	}
	
	public void setCounterPrice(BigDecimal counterPrice) {
		this.counterPrice = counterPrice;
	}
	
	public BigDecimal getCounterPrice() {
		return counterPrice;
	}
	
	public void setRetailPrice(BigDecimal retailPrice) {
		this.retailPrice = retailPrice;
	}
	
	public BigDecimal getRetailPrice() {
		return retailPrice;
	}
	
	public void setDetail(String detail) {
		this.detail = detail;
	}
	
	public String getDetail() {
		return detail;
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
