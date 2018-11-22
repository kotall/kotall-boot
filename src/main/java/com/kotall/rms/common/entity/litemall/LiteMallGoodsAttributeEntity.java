package com.kotall.rms.common.entity.litemall;

import java.io.Serializable;
import java.util.Date;



/**
 * 商品参数表
 *
 * @author kotall
 * @email kotall@admin.com
 * @date 2018年11月20日 下午7:51:23
 */
public class LiteMallGoodsAttributeEntity implements Serializable {
	
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
	 * 商品参数名称
	 */
	private String attribute;
	
	/**
	 * 商品参数值
	 */
	private String value;
	
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
	

	public LiteMallGoodsAttributeEntity() {
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
	
	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}
	
	public String getAttribute() {
		return attribute;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
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
