package com.kotall.rms.common.entity.sys;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 行政区域
 *
 * @author skyarac
 * @date 2018年01月10日 下午21:20:48
 * @version 1.0.0
 */
@Getter
@Setter
@ToString
public class SysAreaEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 区域id
	 */
	private Long areaId;
	
	/**
	 * 区域代码
	 */
	private String areaCode;
	
	/**
	 * 父级代码，省级为0
	 */
	private String parentCode;
	
	/**
	 * 父级名称
	 */
	private String parentName;
	
	/**
	 * 区域名称
	 */
	private String name;
	
	/**
	 * 层级，1：省级，2：地市，3：区县
	 */
	private Integer layer;
	
	/**
	 * 排序
	 */
	private Integer orderNum;
	
	/**
	 * 状态，1：显示，0：隐藏
	 */
	private Integer status;
	
	/**
	 * 备注
	 */
	private String remark;
	
	/**
	 * 创建时间
	 */
	private Timestamp createTime;
	
	/**
	 * 修改时间
	 */
	private Timestamp updateTime;
	
	/**
	 * ztree属性
	 */
	private Boolean open;
	
	private Boolean isParent;
	
	private Integer size;
	
	private List<?> list;

	public void checkParent() {
		if(this.size > 0) {
			this.isParent = true;
		} else {
			this.isParent = false;
		}
	}
	
	public void checkParentName() {
		if(this.parentCode.equals("0")) {
			this.parentName = "省级区域";
		}
	}
	
}
