package com.kotall.rms.common.entity.litemall;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;



/**
 * 订单表
 *
 * @author kotall
 * @email kotall@admin.com
 * @date 2018年11月13日 下午4:22:38
 */
public class LiteMallOrderEntity implements Serializable {
	
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
	 * 订单编号
	 */
	private String orderSn;
	
	/**
	 * 订单状态
	 */
	private Integer orderStatus;
	
	/**
	 * 收货人名称
	 */
	private String consignee;
	
	/**
	 * 收货人手机号
	 */
	private String mobile;
	
	/**
	 * 收货具体地址
	 */
	private String address;
	
	/**
	 * 用户订单留言
	 */
	private String message;
	
	/**
	 * 商品总费用
	 */
	private BigDecimal goodsPrice;
	
	/**
	 * 配送费用
	 */
	private BigDecimal freightPrice;
	
	/**
	 * 优惠券减免
	 */
	private BigDecimal couponPrice;
	
	/**
	 * 用户积分减免
	 */
	private BigDecimal integralPrice;
	
	/**
	 * 团购优惠价减免
	 */
	private BigDecimal grouponPrice;
	
	/**
	 * 订单费用， = goods_price + freight_price - coupon_price
	 */
	private BigDecimal orderPrice;
	
	/**
	 * 实付费用， = order_price - integral_price
	 */
	private BigDecimal actualPrice;
	
	/**
	 * 微信付款编号
	 */
	private String payId;
	
	/**
	 * 微信付款时间
	 */
	private Date payTime;
	
	/**
	 * 发货编号
	 */
	private String shipSn;
	
	/**
	 * 发货快递公司
	 */
	private String shipChannel;
	
	/**
	 * 发货开始时间
	 */
	private Date shipTime;
	
	/**
	 * 用户确认收货时间
	 */
	private Date confirmTime;
	
	/**
	 * 待评价订单商品数量
	 */
	private Integer comments;
	
	/**
	 * 订单关闭时间
	 */
	private Date endTime;
	
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
	

	public LiteMallOrderEntity() {
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
	
	public void setOrderSn(String orderSn) {
		this.orderSn = orderSn;
	}
	
	public String getOrderSn() {
		return orderSn;
	}
	
	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}
	
	public Integer getOrderStatus() {
		return orderStatus;
	}
	
	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}
	
	public String getConsignee() {
		return consignee;
	}
	
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	public String getMobile() {
		return mobile;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setGoodsPrice(BigDecimal goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	
	public BigDecimal getGoodsPrice() {
		return goodsPrice;
	}
	
	public void setFreightPrice(BigDecimal freightPrice) {
		this.freightPrice = freightPrice;
	}
	
	public BigDecimal getFreightPrice() {
		return freightPrice;
	}
	
	public void setCouponPrice(BigDecimal couponPrice) {
		this.couponPrice = couponPrice;
	}
	
	public BigDecimal getCouponPrice() {
		return couponPrice;
	}
	
	public void setIntegralPrice(BigDecimal integralPrice) {
		this.integralPrice = integralPrice;
	}
	
	public BigDecimal getIntegralPrice() {
		return integralPrice;
	}
	
	public void setGrouponPrice(BigDecimal grouponPrice) {
		this.grouponPrice = grouponPrice;
	}
	
	public BigDecimal getGrouponPrice() {
		return grouponPrice;
	}
	
	public void setOrderPrice(BigDecimal orderPrice) {
		this.orderPrice = orderPrice;
	}
	
	public BigDecimal getOrderPrice() {
		return orderPrice;
	}
	
	public void setActualPrice(BigDecimal actualPrice) {
		this.actualPrice = actualPrice;
	}
	
	public BigDecimal getActualPrice() {
		return actualPrice;
	}
	
	public void setPayId(String payId) {
		this.payId = payId;
	}
	
	public String getPayId() {
		return payId;
	}
	
	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}
	
	public Date getPayTime() {
		return payTime;
	}
	
	public void setShipSn(String shipSn) {
		this.shipSn = shipSn;
	}
	
	public String getShipSn() {
		return shipSn;
	}
	
	public void setShipChannel(String shipChannel) {
		this.shipChannel = shipChannel;
	}
	
	public String getShipChannel() {
		return shipChannel;
	}
	
	public void setShipTime(Date shipTime) {
		this.shipTime = shipTime;
	}
	
	public Date getShipTime() {
		return shipTime;
	}
	
	public void setConfirmTime(Date confirmTime) {
		this.confirmTime = confirmTime;
	}
	
	public Date getConfirmTime() {
		return confirmTime;
	}
	
	public void setComments(Integer comments) {
		this.comments = comments;
	}
	
	public Integer getComments() {
		return comments;
	}
	
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
	public Date getEndTime() {
		return endTime;
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
