package com.kotall.rms.common.entity.litemall;

import java.io.Serializable;
import java.util.Date;



/**
 * 用户表
 *
 * @author kotall
 * @email kotall@admin.com
 * @date 2018年11月13日 上午9:47:19
 */
public class LitemallUserEntity implements Serializable {
	
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
	private Date addTime;
	
	/**
	 * 更新时间
	 */
	private Date updateTime;
	
	/**
	 * 逻辑删除
	 */
	private Integer deleted;
	

	public LitemallUserEntity() {
		super();
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	
	public Integer getGender() {
		return gender;
	}
	
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	public Date getBirthday() {
		return birthday;
	}
	
	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	
	public Date getLastLoginTime() {
		return lastLoginTime;
	}
	
	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}
	
	public String getLastLoginIp() {
		return lastLoginIp;
	}
	
	public void setUserLevel(Integer userLevel) {
		this.userLevel = userLevel;
	}
	
	public Integer getUserLevel() {
		return userLevel;
	}
	
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public String getNickname() {
		return nickname;
	}
	
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	public String getMobile() {
		return mobile;
	}
	
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	
	public String getAvatar() {
		return avatar;
	}
	
	public void setWeixinOpenid(String weixinOpenid) {
		this.weixinOpenid = weixinOpenid;
	}
	
	public String getWeixinOpenid() {
		return weixinOpenid;
	}
	
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public Integer getStatus() {
		return status;
	}
	
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
	
	public Date getAddTime() {
		return addTime;
	}
	
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	public Date getUpdateTime() {
		return updateTime;
	}
	
	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}
	
	public Integer getDeleted() {
		return deleted;
	}
	
}
