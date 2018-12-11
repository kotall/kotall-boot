package com.kotall.rms.common.entity.litemall;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;



/**
 * 用户表
 *
 * @author kotall
 * @email kotall@admin.com
 * @date 2018年11月13日 上午10:18:32
 */
@Data
public class LiteMallUserEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	private Integer id;
	
	/**
	 * 用户名称
	 */
	private String username;
	
	/**
	 * 用户密码
	 */
	private String password;
	
	/**
	 * 性别：0 未知， 1男， 1 女
	 */
	private Integer gender;
	
	/**
	 * 生日
	 */
	private Date birthday;
	
	/**
	 * 最近一次登录时间
	 */
	private Date lastLoginTime;
	
	/**
	 * 最近一次登录IP地址
	 */
	private String lastLoginIp;
	
	/**
	 * 0 普通用户，1 VIP用户，2 高级VIP用户
	 */
	private Integer userLevel;
	
	/**
	 * 用户昵称或网络名称
	 */
	private String nickname;
	
	/**
	 * 用户手机号码
	 */
	private String mobile;
	
	/**
	 * 用户头像图片
	 */
	private String avatar;
	
	/**
	 * 微信登录openid
	 */
	private String weixinOpenid;
	
	/**
	 * 0 可用, 1 禁用, 2 注销
	 */
	private Integer status;
	
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
