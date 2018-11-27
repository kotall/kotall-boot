package com.kotall.rms.api.vo;

import com.kotall.rms.common.entity.litemall.LiteMallCartEntity;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author zpwang
 * @version 1.0.0
 */
@Data
public class CartVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private BigDecimal goodsCount;
    private BigDecimal goodsAmount;
    private BigDecimal checkedGoodsCount;
    private BigDecimal checkedGoodsAmount;

    private List<LiteMallCartEntity> cartList;

}
