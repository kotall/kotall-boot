package com.kotall.rms.common.entity.litemall;

import lombok.Data;

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
@Data
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
	private Boolean deleted;

	/**
	 * 店铺ID
	 */
	private Integer storeId;
}
