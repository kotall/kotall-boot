package com.kotall.rms.common.entity.litemall;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;



/**
 * 
 *
 * @author kotall
 * @email kotall@admin.com
 * @date 2018年11月13日 下午6:25:19
 */
public class LiteMallGrouponRulesEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	private Integer id;
	
	/**
	 * 商品表的商品ID
	 */
	private Integer goodsId;
	
	/**
	 * 商品名称
	 */
	private String goodsName;
	
	/**
	 * 商品图片或者商品货品图片
	 */
	private String picUrl;
	
	/**
	 * 优惠金额
	 */
	private BigDecimal discount;
	
	/**
	 * 达到优惠条件的人数
	 */
	private Integer discountMember;
	
	/**
	 * 创建时间
	 */
	private Date addTime;
	
	/**
	 * 更新时间
	 */
	private Date updateTime;
	
	/**
	 * 团购过期时间
	 */
	private Date expireTime;
	
	/**
	 * 逻辑删除
	 */
	private Integer deleted;
	

	public LiteMallGrouponRulesEntity() {
		super();
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return id;
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
	
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	
	public String getPicUrl() {
		return picUrl;
	}
	
	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}
	
	public BigDecimal getDiscount() {
		return discount;
	}
	
	public void setDiscountMember(Integer discountMember) {
		this.discountMember = discountMember;
	}
	
	public Integer getDiscountMember() {
		return discountMember;
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
	
	public void setExpireTime(Date expireTime) {
		this.expireTime = expireTime;
	}
	
	public Date getExpireTime() {
		return expireTime;
	}
	
	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}
	
	public Integer getDeleted() {
		return deleted;
	}
	
}
