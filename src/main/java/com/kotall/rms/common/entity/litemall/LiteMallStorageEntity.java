package com.kotall.rms.common.entity.litemall;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;



/**
 * 文件存储表
 *
 * @author kotall
 * @email kotall@admin.com
 * @date 2018年11月21日 上午11:42:26
 */
@Data
public class LiteMallStorageEntity implements Serializable {
	
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
	 * 文件的唯一索引
	 */
	private String key;
	
	/**
	 * 文件名
	 */
	private String name;
	
	/**
	 * 文件类型
	 */
	private String type;
	
	/**
	 * 文件大小
	 */
	private Integer size;
	
	/**
	 * 文件访问链接
	 */
	private String url;
	
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
