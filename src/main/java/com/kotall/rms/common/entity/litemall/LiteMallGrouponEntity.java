package com.kotall.rms.common.entity.litemall;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 *
 * @author kotall
 * @email kotall@admin.com
 * @date 2018年11月13日 下午6:32:18
 */
@Data
public class LiteMallGrouponEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	private Integer id;
	
	/**
	 * 关联的订单ID
	 */
	private Integer orderId;
	
	/**
	 * 参与的团购ID，仅当user_type不是1
	 */
	private Integer grouponId;
	
	/**
	 * 团购规则ID，关联litemall_groupon_rules表ID字段
	 */
	private Integer rulesId;
	
	/**
	 * 用户ID
	 */
	private Integer userId;
	
	/**
	 * 创建者ID
	 */
	private Integer creatorUserId;
	
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
	 * 团购分享图片地址
	 */
	private String shareUrl;
	
	/**
	 * 是否已经支付
	 */
	private Integer payed;
	
	/**
	 * 逻辑删除
	 */
	private Boolean deleted;

	/**
	 * 店铺ID
	 */
	private Integer storeId;
	
}
