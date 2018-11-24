package com.kotall.rms.common.entity.litemall;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;



/**
 * 搜索历史表
 *
 * @author kotall
 * @email kotall@admin.com
 * @date 2018年11月13日 下午2:19:50
 */
@Data
public class LiteMallSearchHistoryEntity implements Serializable {
	
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
	 * 搜索关键字
	 */
	private String keyword;
	
	/**
	 * 搜索来源，如pc、wx、app
	 */
	private String from;
	
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
	private Integer storeId;
}
