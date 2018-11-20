package com.kotall.rms.common.entity.litemall;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;



/**
 * 商品货品表
 *
 * @author kotall
 * @email kotall@admin.com
 * @date 2018年11月20日 下午12:58:29
 */
public class LiteMallGoodsProductEntity implements Serializable {
	
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
	 * 商品表的商品ID
	 */
	private Integer goodsId;
	
	/**
	 * 商品规格值列表，采用JSON数组格式
	 */
	private String specifications;
	
	/**
	 * 商品货品价格
	 */
	private BigDecimal price;
	
	/**
	 * 商品货品数量
	 */
	private Integer number;
	
	/**
	 * 商品货品图片
	 */
	private String url;
	
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
	

	public LiteMallGoodsProductEntity() {
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
	
	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}
	
	public Integer getGoodsId() {
		return goodsId;
	}
	
	public void setSpecifications(String specifications) {
		this.specifications = specifications;
	}
	
	public String getSpecifications() {
		return specifications;
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
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getUrl() {
		return url;
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
