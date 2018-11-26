package com.kotall.rms.api.vo;

import com.kotall.rms.common.entity.litemall.LiteMallAddressEntity;
import lombok.Data;
import lombok.ToString;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;

/**
 * @author zpwang
 * @version 1.0.0
 */
@Data
@ToString
public class AddressVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String version;

    private Integer userId;

    /**
     * ID
     */
    private Integer id;
    /**
     * 收货人姓名
     */
    private String name;
    /**
     * 收货人联系电话
     */
    private String mobile;

    /**
     * 是否默认地址
     */
    private Boolean isDefault;

    /**
     * 省份ID
     */
    private Integer provinceId;

    private String provinceName;

    /**
     * 县市ID
     */
    private Integer cityId;

    private String cityName;

    /**
     * 区ID
     */
    private Integer areaId;

    private String areaName;
    /**
     * 地址详情
     */
    private String address;

    private Integer storeId;

    public LiteMallAddressEntity convertToEntity() {
        LiteMallAddressEntity entity = new LiteMallAddressEntity();
        BeanUtils.copyProperties(this, entity);
        return entity;
    }
}
