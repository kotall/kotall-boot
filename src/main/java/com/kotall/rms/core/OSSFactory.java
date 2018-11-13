
package com.kotall.rms.core;


import com.google.gson.Gson;
import com.kotall.rms.common.integration.cloud.AliyunCloudStorageService;
import com.kotall.rms.common.integration.cloud.CloudStorageService;
import com.kotall.rms.common.integration.cloud.QcloudCloudStorageService;
import com.kotall.rms.common.integration.cloud.QiniuCloudStorageService;
import com.kotall.rms.core.constants.ConfigConstant;
import com.kotall.rms.core.constants.Constant;
import com.kotall.rms.common.utils.SpringContextUtils;
import com.kotall.rms.core.service.sys.SysConfigService;
import org.apache.commons.lang.StringUtils;

/**
 * 云存储工厂类
 * @author zpwang
 * @version 1.0.0
 */
public final class OSSFactory {

    private static SysConfigService sysConfigService;

    static {
        OSSFactory.sysConfigService = (SysConfigService) SpringContextUtils.getBean("sysConfigService");
    }

    public static CloudStorageService build(){
        // 获取云存储配置信息
        String value = sysConfigService.getValue(ConfigConstant.CLOUD_STORAGE_CONFIG_KEY);

        CloudStorageConfig config;
        if(StringUtils.isNotBlank(value)){
            config = new Gson().fromJson(value, CloudStorageConfig.class);
        } else {
            config = new CloudStorageConfig();
        }
        if(config.getType() == Constant.CloudService.QINIU.getValue()){
            return new QiniuCloudStorageService(config);
        }else if(config.getType() == Constant.CloudService.ALIYUN.getValue()){
            return new AliyunCloudStorageService(config);
        }else if(config.getType() == Constant.CloudService.QCLOUD.getValue()){
            return new QcloudCloudStorageService(config);
        }

        return null;
    }

}
