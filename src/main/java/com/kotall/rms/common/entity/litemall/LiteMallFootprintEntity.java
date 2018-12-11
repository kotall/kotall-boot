package com.kotall.rms.common.entity.litemall;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;



/**
 * 用户浏览足迹表
 *
 * @author kotall
 * @email kotall@admin.com
 * @date 2018年11月13日 下午2:10:19
 */
@Data
public class LiteMallFootprintEntity implements Serializable {
	
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
	 * 浏览商品ID
	 */
	private Integer goodsId;
	
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
	
}
