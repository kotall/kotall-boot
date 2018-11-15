package com.kotall.rms.common.entity.litemall;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;



/**
 * 收藏表
 *
 * @author kotall
 * @email kotall@admin.com
 * @date 2018年11月13日 上午11:41:28
 */
@Data
public class LiteMallCollectEntity implements Serializable {
	
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
	 * 如果type=0，则是商品ID；如果type=1，则是专题ID
	 */
	private Integer valueId;
	
	/**
	 * 收藏类型，如果type=0，则是商品ID；如果type=1，则是专题ID
	 */
	private Integer type;
	
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
	private Long deleted;

}
