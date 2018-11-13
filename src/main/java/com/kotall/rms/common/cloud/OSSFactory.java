
package com.kotall.rms.common.cloud;


import com.kotall.rms.common.utils.ConfigConstant;
import com.kotall.rms.common.utils.Constant;
import com.kotall.rms.common.utils.SpringContextUtils;
import com.kotall.rms.core.service.sys.SysConfigService;

/**
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
        CloudStorageConfig config = sysConfigService.getConfigObject(ConfigConstant.CLOUD_STORAGE_CONFIG_KEY, CloudStorageConfig.class);

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
