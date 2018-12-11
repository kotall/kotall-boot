package com.kotall.rms.common.entity.litemall;

import com.alibaba.fastjson.annotation.JSONField;
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
	private String sid;
	
	/**
	 * 店铺ID
	 */
	private Integer storeId;
	
	/**
	 * 版本
	 */
	private String version;

	/**
	 * 微信交易类型
	 */
	private String tradeType;


	/**
	 * 微信小程序appId
	 */
	private String appId;

	/**
	 * 微信小程序子appId
	 */
	private String subAppId;


	/**
	 * 微信商户号
	 */
	private String mchId;

	/**
	 * 微信子商户号
	 */
	private String subMchId;

	/**
	 * 微信商户秘钥
	 */
	private String mchKey;

	/**
	 * 微信签名类型
	 */
	private String signType;

	/**
	 * 微信证书路径
	 */
	private String keyPath;

	/**
	 * 微信支付结果通知地址
	 */
	private String notifyUrl;

	/**
	 * 创建时间
	 */
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Date createdTime;
	
	/**
	 * 更新时间
	 */
	private Date updatedTime;
	

}
