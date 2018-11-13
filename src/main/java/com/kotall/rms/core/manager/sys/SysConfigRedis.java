
package com.kotall.rms.core.manager.sys;


import com.kotall.rms.common.entity.sys.SysConfigEntity;
import com.kotall.rms.common.utils.RedisKeys;
import com.kotall.rms.common.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 系统配置Redis
 *
 * @author kotall
 * @date 2018年11月12日 下午9:18:45
 * @since 1.0.0
 */
@Component
public class SysConfigRedis {

    @Autowired
    private RedisUtils redisUtils;

    public void saveOrUpdate(SysConfigEntity config) {
        if(config == null){
            return ;
        }
        String key = RedisKeys.getSysConfigKey(config.getParamKey());
        redisUtils.set(key, config);
    }

    public void delete(String configKey) {
        String key = RedisKeys.getSysConfigKey(configKey);
        redisUtils.delete(key);
    }

    public SysConfigEntity get(String configKey){
        String key = RedisKeys.getSysConfigKey(configKey);
        return redisUtils.get(key, SysConfigEntity.class);
    }
}
