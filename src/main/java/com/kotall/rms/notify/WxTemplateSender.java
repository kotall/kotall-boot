package com.kotall.rms.notify;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaTemplateData;
import cn.binarywang.wx.miniapp.bean.WxMaTemplateMessage;
import com.kotall.rms.common.entity.litemall.LiteMallUserFormidEntity;
import com.kotall.rms.core.service.litemall.LiteMallUserFormidService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 微信模版消息通知
 */
@Slf4j
public class WxTemplateSender {

    @Autowired
    private WxMaService wxMaService;

    @Autowired
    private LiteMallUserFormidService formIdService;

    /**
     * 发送微信消息(模板消息),不带跳转
     *
     * @param touser    用户 OpenID
     * @param templatId 模板消息ID
     * @param parms     详细内容
     */
    public void sendWechatMsg(String touser, String templatId, String[] parms) {
        sendMsg(touser, templatId, parms, "", "", "");
    }

    /**
     * 发送微信消息(模板消息),带跳转
     *
     * @param touser    用户 OpenID
     * @param templatId 模板消息ID
     * @param parms     详细内容
     * @param page      跳转页面
     */
    public void sendWechatMsg(String touser, String templatId, String[] parms, String page) {
        sendMsg(touser, templatId, parms, page, "", "");
    }

    private void sendMsg(String touser, String templatId, String[] parms, String page, String color, String emphasisKeyword) {
        Map<String, Object> params = new HashMap<>();
        params.put("openid", touser);
        LiteMallUserFormidEntity userFormid = formIdService.queryByOpenId(params);
        if (userFormid == null)
            return;

        WxMaTemplateMessage msg = new WxMaTemplateMessage();
        msg.setTemplateId(templatId);
        msg.setToUser(touser);
        msg.setFormId(userFormid.getFormid());
        msg.setPage(page);
        msg.setColor(color);
        msg.setEmphasisKeyword(emphasisKeyword);
        msg.setData(createMsgData(parms));

        try {
            wxMaService.getMsgService().sendTemplateMsg(msg);
            if(formIdService.updateUserFormId(userFormid) == 0){
                log.warn("更新数据已失效");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private List<WxMaTemplateData> createMsgData(String[] parms) {
        List<WxMaTemplateData> dataList = new ArrayList<>();
        for (int i = 1; i <= parms.length; i++) {
            dataList.add(new WxMaTemplateData("keyword" + i, parms[i - 1]));
        }

        return dataList;
    }
}
