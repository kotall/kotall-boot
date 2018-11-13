
package com.kotall.rms.common.utils;


/**
 * Redis 所有keys
 *
 * @author aracwong
 * @date 2017年8月11日 下午12:13:58
 * @since 1.0.0
 */
public class RedisKeys {

    public static String getSysConfigKey(String key){
        return "sys:config:" + key;
    }

    public static String getShiroSessionKey(String key){
        return "sessionid:" + key;
    }
}
