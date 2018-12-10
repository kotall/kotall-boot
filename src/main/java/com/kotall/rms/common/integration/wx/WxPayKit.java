package com.kotall.rms.common.integration.wx;

import com.github.binarywang.wxpay.bean.request.WxPayUnifiedOrderRequest;
import com.kotall.rms.common.entity.litemall.LiteMallAppEntity;

/**
 * @author zpwang
 * @version 1.0.0
 */
public class WxPayKit {

    public static void buildWxPayConfig(WxPayUnifiedOrderRequest orderRequest, LiteMallAppEntity appConfig) {
        orderRequest.setNotifyUrl(appConfig.getNotifyUrl());
        orderRequest.setTradeType(appConfig.getTradeType());
        orderRequest.setAppid(appConfig.getAppId());
        orderRequest.setSubAppId(appConfig.getSubAppId());
        orderRequest.setMchId(appConfig.getMchId());
        orderRequest.setSubMchId(appConfig.getSubMchId());
        orderRequest.setSignType(appConfig.getSignType());
    }
}
