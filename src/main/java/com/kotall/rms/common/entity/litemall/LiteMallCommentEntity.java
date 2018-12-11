package com.kotall.rms.common.entity.litemall;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;



/**
 * 评论表
 *
 * @author kotall
 * @email kotall@admin.com
 * @date 2018年11月13日 下午4:55:35
 */
@Data
public class LiteMallCommentEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	private Integer id;
	
	/**
	 * 如果type=0，则是商品评论；如果是type=1，则是专题评论。
	 */
	private Integer valueId;
	
	/**
	 * 评论类型，如果type=0，则是商品评论；如果是type=1，则是专题评论；如果type=3，则是订单商品评论。
	 */
	private Integer type;
	
	/**
	 * 评论内容
	 */
	private String content;
	
	/**
	 * 用户表的用户ID
	 */
	private Integer userId;
	
	/**
	 * 是否含有图片
	 */
	private Integer hasPicture;
	
	/**
	 * 图片地址列表，采用JSON数组格式
	 */
	private String picUrls;
	
	/**
	 * 评分， 1-5
	 */
	private Integer star;
	
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
