package com.kotall.rms.common.entity.litemall;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;



/**
 * 购物车商品表
 *
 * @author kotall
 * @email kotall@admin.com
 * @date 2018年11月20日 下午12:39:39
 */
public class LiteMallCartEntity implements Serializable {
	
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
	 * 用户表的用户ID
	 */
	private Integer userId;
	
	/**
	 * 商品表的商品ID
	 */
	private Integer goodsId;
	
	/**
	 * 商品编号
	 */
	private String goodsSn;
	
	/**
	 * 商品名称
	 */
	private String goodsName;
	
	/**
	 * 商品货品表的货品ID
	 */
	private Integer productId;
	
	/**
	 * 商品货品的价格
	 */
	private BigDecimal price;
	
	/**
	 * 商品货品的数量
	 */
	private Integer number;
	
	/**
	 * 商品规格值列表，采用JSON数组格式
	 */
	private String specifications;
	
	/**
	 * 购物车中商品是否选择状态
	 */
	private Integer checked;
	
	/**
	 * 商品图片或者商品货品图片
	 */
	private String picUrl;
	
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
	

	public LiteMallCartEntity() {
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
	
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	public Integer getUserId() {
		return userId;
	}
	
	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}
	
	public Integer getGoodsId() {
		return goodsId;
	}
	
	public void setGoodsSn(String goodsSn) {
		this.goodsSn = goodsSn;
	}
	
	public String getGoodsSn() {
		return goodsSn;
	}
	
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	
	public String getGoodsName() {
		return goodsName;
	}
	
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	
	public Integer getProductId() {
		return productId;
	}
	
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	public BigDecimal getPrice() {
		return price;
	}
	
	public void setNumber(Integer number) {
		this.number = number;
	}
	
	public Integer getNumber() {
		return number;
	}
	
	public void setSpecifications(String specifications) {
		this.specifications = specifications;
	}
	
	public String getSpecifications() {
		return specifications;
	}
	
	public void setChecked(Integer checked) {
		this.checked = checked;
	}
	
	public Integer getChecked() {
		return checked;
	}
	
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	
	public String getPicUrl() {
		return picUrl;
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
