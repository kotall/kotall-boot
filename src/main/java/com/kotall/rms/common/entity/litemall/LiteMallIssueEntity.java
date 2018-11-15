package com.kotall.rms.common.entity.litemall;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;



/**
 * 常见问题表
 *
 * @author kotall
 * @email kotall@admin.com
 * @date 2018年11月13日 下午4:29:37
 */
@Data
public class LiteMallIssueEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	private Integer id;
	
	/**
	 * 问题标题
	 */
	private String question;
	
	/**
	 * 问题答案
	 */
	private String answer;
	
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
	private Long storeId;
	
}
