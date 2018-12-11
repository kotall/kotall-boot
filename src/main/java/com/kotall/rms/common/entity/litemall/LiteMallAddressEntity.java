package com.kotall.rms.common.entity.litemall;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;



/**
 * 收货地址表
 *
 * @author kotall
 * @email kotall@admin.com
 * @date 2018年11月13日 上午11:28:53
 */
@Data
public class LiteMallAddressEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	private Integer id;
	
	/**
	 * 收货人名称
	 */
	private String name;
	
	/**
	 * 用户表的用户ID
	 */
	private Integer userId;
	
	/**
	 * 行政区域表的省ID
	 */
	private Integer provinceId;
	
	/**
	 * 行政区域表的市ID
	 */
	private Integer cityId;
	
	/**
	 * 行政区域表的区县ID
	 */
	private Integer areaId;
	
	/**
	 * 具体收货地址
	 */
	private String address;
	
	/**
	 * 手机号码
	 */
	private String mobile;
	
	/**
	 * 是否默认地址
	 */
	private Boolean isDefault;
	
	/**
	 * 创建时间
	 */
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Date addTime;
	
	/**
	 * 更新时间
	 */
	private Date updateTime;
	
	/**
	 * 逻辑删除
	 */
	private Integer deleted;

	/**
	 * 店铺ID
	 */
	private Integer storeId;

	/**
	 * 店铺名称
	 */
	private String storeName;

}
