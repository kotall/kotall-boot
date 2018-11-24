package com.kotall.rms.common.entity.sys;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * 系统用户Token
 *
 * @author skyarac
 * @date 2018年01月10日 下午21:20:48
 * @version 1.0.0
 */
@Getter
@Setter
@ToString
public class SysUserTokenEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 用户id
	 */
	private Integer userId;
	
	/**
	 * token
	 */
	private String token;
	
	/**
	 * 过期时间
	 */
	private Date expireTime;
	
	/**
	 * 更新时间
	 */
	private Date updateTime;

}
