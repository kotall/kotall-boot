package com.kotall.rms.common.entity.litemall;

import lombok.Data;

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
@Data
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
	private Boolean checked;
	
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
	
}
