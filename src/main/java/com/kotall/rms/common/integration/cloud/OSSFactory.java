
package com.kotall.rms.common.integration.cloud;


import com.google.gson.Gson;
import com.kotall.rms.core.config.CloudStorageConfig;
import com.kotall.rms.core.constants.Constant;
import org.apache.commons.lang.StringUtils;

/**
 * 云存储工厂类
 * @author zpwang
 * @version 1.0.0
 */
public final class OSSFactory {

    public static StorageService build(String jsonStorageConfig){
        CloudStorageConfig config;
        if(StringUtils.isNotBlank(jsonStorageConfig)){
            config = new Gson().fromJson(jsonStorageConfig, CloudStorageConfig.class);
        } else {
            config = new CloudStorageConfig();
        }
        if(config.getType() == Constant.CloudService.QINIU.getValue()){
            return new QiniuStorageService(config);
        }else if(config.getType() == Constant.CloudService.ALIYUN.getValue()){
            return new AliyunStorageService(config);
        }

        return null;
    }

}
