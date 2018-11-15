package com.kotall.rms.common.entity.litemall;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;



/**
 * 专题表
 *
 * @author kotall
 * @email kotall@admin.com
 * @date 2018年11月13日 下午6:17:39
 */
@Data
public class LiteMallTopicEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	private Integer id;
	
	/**
	 * 专题标题
	 */
	private String title;
	
	/**
	 * 专题子标题
	 */
	private String subtitle;
	
	/**
	 * 专题内容，富文本格式
	 */
	private String content;
	
	/**
	 * 专题相关商品最低价
	 */
	private BigDecimal price;
	
	/**
	 * 专题阅读量
	 */
	private String readCount;
	
	/**
	 * 专题图片
	 */
	private String picUrl;
	
	/**
	 * 排序
	 */
	private Integer sortOrder;
	
	/**
	 * 专题相关商品，采用JSON数组格式
	 */
	private String goods;
	
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
