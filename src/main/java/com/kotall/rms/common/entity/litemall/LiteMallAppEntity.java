package com.kotall.rms.common.entity.litemall;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;



/**
 * app配置表
 *
 * @author kotall
 * @email kotall@admin.com
 * @date 2018年11月19日 上午10:17:16
 */
@Data
public class LiteMallAppEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 主键
	 */
	private Integer id;
	
	/**
	 * appID
	 */
	private String appId;
	
	/**
	 * 店铺ID
	 */
	private Integer storeId;
	
	/**
	 * 版本
	 */
	private String version;
	
	/**
	 * 创建时间
	 */
	private Date createdTime;
	
	/**
	 * 更新时间
	 */
	private Date updatedTime;
	

}
