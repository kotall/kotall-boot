package com.kotall.rms.api.vo;

import com.kotall.rms.common.entity.litemall.LiteMallGoodsSpecificationEntity;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author zpwang
 * @version 1.0.0
 */
@Data
public class GoodsSpecificationVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    private List<LiteMallGoodsSpecificationEntity> valueList;
}
