package com.kotall.rms.notify;

import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/*
 * 腾讯云短信服务
 */
public class TencentSmsSender implements SmsSender {
    private final Log logger = LogFactory.getLog(TencentSmsSender.class);

    private SmsSingleSender sender;

    public SmsSingleSender getSender() {
        return sender;
    }

    public void setSender(SmsSingleSender sender) {
        this.sender = sender;
    }

    @Override
    public SmsResult send(String phone, String content) {
        try {
            SmsSingleSenderResult result = sender.send(0, "86", phone, content, "", "");
            logger.debug(result);

            SmsResult smsResult = new SmsResult();
            smsResult.setSuccessful(true);
            smsResult.setResult(result);
            return smsResult;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public SmsResult sendWithTemplate(String phone, int templateId, String[] params) {
        try {
            SmsSingleSenderResult result = sender.sendWithParam("86", phone, templateId, params, "", "", "");
            logger.debug(result);

            SmsResult smsResult = new SmsResult();
            smsResult.setSuccessful(true);
            smsResult.setResult(result);
            return smsResult;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
