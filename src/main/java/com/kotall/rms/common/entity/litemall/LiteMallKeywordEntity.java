package com.kotall.rms.common.entity.litemall;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;



/**
 * 关键字表
 *
 * @author kotall
 * @email kotall@admin.com
 * @date 2018年11月13日 下午4:34:40
 */
@Data
public class LiteMallKeywordEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	private Integer id;
	
	/**
	 * 关键字
	 */
	private String keyword;
	
	/**
	 * 关键字的跳转链接
	 */
	private String url;
	
	/**
	 * 是否是热门关键字
	 */
	private Integer isHot;
	
	/**
	 * 是否是默认关键字
	 */
	private Integer isDefault;
	
	/**
	 * 排序
	 */
	private Integer sortOrder;
	
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
	private Long storeId;
}
