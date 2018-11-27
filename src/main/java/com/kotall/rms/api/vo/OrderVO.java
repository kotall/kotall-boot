package com.kotall.rms.api.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author zpwang
 * @version 1.0.0
 */
@Data
public class OrderVO {

    /**
     * 订单ID
     */
    private Integer id;

    /**
     * 订单比那好
     */
    private String orderSn;

    /**
     * 实付费用
     */
    private BigDecimal actualPrice;

    /**
     * 订单描述
     */
    private String orderStatusText;

    /**
     * 订单操作选项
     */
    private String handleOption;

    /**
     * 是否团购订单
     */
    private boolean isGroupin;

    /**
     * 订单详情
     */
    private List<OrderDetailVO> goodsList;

}

@Data
class OrderDetailVO{

    private Integer id;
    private String goodsName;

    private Integer number;

    private String picUrl;
}
