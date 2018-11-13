
package com.kotall.rms.common.entity.sys;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;


@Getter
@Setter
@ToString
public class SysOssEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	/**
	 * URL地址
	 */
	private String url;

	/**
	 * 创建时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createDate;

}
