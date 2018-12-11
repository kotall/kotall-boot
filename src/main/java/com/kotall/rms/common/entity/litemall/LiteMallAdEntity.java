package com.kotall.rms.common.entity.litemall;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;



/**
 * 广告表
 *
 * @author kotall
 * @email kotall@admin.com
 * @date 2018年11月13日 下午6:08:21
 */
@Data
public class LiteMallAdEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	private Integer id;
	
	/**
	 * 广告标题
	 */
	private String name;
	
	/**
	 * 所广告的商品页面或者活动页面链接地址
	 */
	private String link;
	
	/**
	 * 广告宣传图片
	 */
	private String url;
	
	/**
	 * 广告位置：1则是首页
	 */
	private Integer position;
	
	/**
	 * 活动内容
	 */
	private String content;
	
	/**
	 * 广告开始时间
	 */
	private Date startTime;
	
	/**
	 * 广告结束时间
	 */
	private Date endTime;
	
	/**
	 * 是否启动
	 */
	private Integer enabled;
	
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
