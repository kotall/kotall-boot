package com.kotall.rms.common.entity.litemall;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;



/**
 * 店铺表 
 *
 * @author kotall
 * @email kotall@admin.com
 * @date 2018年11月14日 下午6:05:16
 */
@Data
public class LiteMallStoreEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 店铺ID
	 */
	private Integer id;
	
	/**
	 * 店铺名称
	 */
	private String name;
	
	/**
	 * 店铺状态 0:关闭1:运营中 2:暂停营业
	 */
	private String status;
	
	/**
	 * 店铺类型
	 */
	private Integer type;
	
	/**
	 * 主营业务
	 */
	private String mainBuz;
	
	/**
	 * 店铺招牌
	 */
	private String brand;
	
	/**
	 * 店铺地址
	 */
	private String address;
	
	/**
	 * 店铺位置X
	 */
	private String locationX;
	
	/**
	 * 店铺位置Y
	 */
	private String locationY;
	
	/**
	 * 店主ID
	 */
	private Long userId;

	/**
	 * 店主用户名称
	 */
	private String userName;
	
	/**
	 * 联系人
	 */
	private String contactMan;
	
	/**
	 * 联系电话 18321669370
	 */
	private String contactPhone;
	
	/**
	 * 创建时间
	 */
	private Date createTime;
	
	/**
	 * 更新时间
	 */
	private Date updateTime;

}
