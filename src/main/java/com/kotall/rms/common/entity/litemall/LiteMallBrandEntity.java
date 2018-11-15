package com.kotall.rms.common.entity.litemall;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;



/**
 * 品牌商表
 *
 * @author kotall
 * @email kotall@admin.com
 * @date 2018年11月13日 下午2:48:32
 */
@Data
public class LiteMallBrandEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	private Integer id;
	
	/**
	 * 品牌商名称
	 */
	private String name;
	
	/**
	 * 品牌商简介
	 */
	private String desc;
	
	/**
	 * 品牌商页的品牌商图片
	 */
	private String picUrl;
	
	/**
	 * 
	 */
	private Integer sortOrder;
	
	/**
	 * 品牌商的商品低价，仅用于页面展示
	 */
	private BigDecimal floorPrice;
	
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
