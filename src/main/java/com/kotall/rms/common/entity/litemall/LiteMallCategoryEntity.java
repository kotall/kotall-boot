package com.kotall.rms.common.entity.litemall;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;



/**
 * 类目表
 *
 * @author kotall
 * @email kotall@admin.com
 * @date 2018年11月13日 下午4:12:36
 */
@Data
public class LiteMallCategoryEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	private Integer id;
	
	/**
	 * 类目名称
	 */
	private String name;
	
	/**
	 * 类目关键字，以JSON数组格式
	 */
	private String keywords;
	
	/**
	 * 类目广告语介绍
	 */
	private String desc;
	
	/**
	 * 父类目ID
	 */
	private Integer pid;
	
	/**
	 * 类目图标
	 */
	private String iconUrl;
	
	/**
	 * 类目图片
	 */
	private String picUrl;
	
	/**
	 * 
	 */
	private String level;
	
	/**
	 * 排序
	 */
	private Integer sortOrder;
	
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

	/**
	 * 店铺ID
	 */
	private Long storeId;
}
