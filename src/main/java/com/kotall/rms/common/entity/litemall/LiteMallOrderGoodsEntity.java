package com.kotall.rms.common.entity.litemall;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;



/**
 * 订单商品表
 *
 * @author kotall
 * @email kotall@admin.com
 * @date 2018年11月13日 下午4:45:21
 */
public class LiteMallOrderGoodsEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	private Integer id;
	
	/**
	 * 订单表的订单ID
	 */
	private Integer orderId;
	
	/**
	 * 商品表的商品ID
	 */
	private Integer goodsId;
	
	/**
	 * 商品名称
	 */
	private String goodsName;
	
	/**
	 * 商品编号
	 */
	private String goodsSn;
	
	/**
	 * 商品货品表的货品ID
	 */
	private Integer productId;
	
	/**
	 * 商品货品的购买数量
	 */
	private Integer number;
	
	/**
	 * 商品货品的售价
	 */
	private BigDecimal price;
	
	/**
	 * 商品货品的规格列表
	 */
	private String specifications;
	
	/**
	 * 商品货品图片或者商品图片
	 */
	private String picUrl;
	
	/**
	 * 订单商品评论，如果是-1，则超期不能评价；如果是0，则可以评价；如果其他值，则是comment表里面的评论ID。
	 */
	private Integer comment;
	
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
	

	public LiteMallOrderGoodsEntity() {
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
	
	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}
	
	public Integer getGoodsId() {
		return goodsId;
	}
	
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	
	public String getGoodsName() {
		return goodsName;
	}
	
	public void setGoodsSn(String goodsSn) {
		this.goodsSn = goodsSn;
	}
	
	public String getGoodsSn() {
		return goodsSn;
	}
	
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	
	public Integer getProductId() {
		return productId;
	}
	
	public void setNumber(Integer number) {
		this.number = number;
	}
	
	public Integer getNumber() {
		return number;
	}
	
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	public BigDecimal getPrice() {
		return price;
	}
	
	public void setSpecifications(String specifications) {
		this.specifications = specifications;
	}
	
	public String getSpecifications() {
		return specifications;
	}
	
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	
	public String getPicUrl() {
		return picUrl;
	}
	
	public void setComment(Integer comment) {
		this.comment = comment;
	}
	
	public Integer getComment() {
		return comment;
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
