package com.kotall.rms.common.entity.litemall;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;



/**
 * 意见反馈表
 *
 * @author kotall
 * @email kotall@admin.com
 * @date 2018年11月13日 下午2:33:08
 */
@Data
public class LiteMallFeedbackEntity implements Serializable {
	
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
	 * 用户名称
	 */
	private String username;
	
	/**
	 * 手机号
	 */
	private String mobile;
	
	/**
	 * 反馈类型
	 */
	private String feedType;
	
	/**
	 * 反馈内容
	 */
	private String content;
	
	/**
	 * 状态
	 */
	private Integer status;
	
	/**
	 * 是否含有图片
	 */
	private Integer hasPicture;
	
	/**
	 * 图片地址列表，采用JSON数组格式
	 */
	private String picUrls;
	
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
