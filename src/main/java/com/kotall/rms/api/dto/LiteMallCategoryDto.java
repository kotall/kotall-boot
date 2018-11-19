package com.kotall.rms.api.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zpwang
 * @version 1.0.0
 */
@Data
public class LiteMallCategoryDto implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     *
     */
    private Integer id;

    /**
     * 类目名称
     */
    private String name;

    /**
     * 类目图标
     */
    private String iconUrl;

    /**
     * 店铺ID
     */
    private Long storeId;
}
