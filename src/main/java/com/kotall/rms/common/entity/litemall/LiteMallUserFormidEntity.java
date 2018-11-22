package com.kotall.rms.common.entity.litemall;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 *
 * @author kotall
 * @email kotall@admin.com
 * @date 2018年11月20日 下午1:56:37
 */
@Data
public class LiteMallUserFormidEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	private Integer id;
	
	/**
	 * 店铺ID
	 */
	private Long storeId;
	
	/**
	 * 缓存的FormId
	 */
	private String formid;
	
	/**
	 * 是FormId还是prepayId
	 */
	private Integer isprepay;
	
	/**
	 * 可用次数，fromId为1，prepay为3，用1次减1
	 */
	private Integer useamount;
	
	/**
	 * 过期时间，腾讯规定为7天
	 */
	private Date expireTime;
	
	/**
	 * 微信登录openid
	 */
	private String openid;
	
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
