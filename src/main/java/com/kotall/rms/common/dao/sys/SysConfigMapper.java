package com.kotall.rms.common.dao.sys;

import com.kotall.rms.common.entity.sys.SysConfigEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 系统配置信息表
 *
 * @author kotall
 * @date 2018年11月12日 下午9:18:45
 * @since 1.0.0
 */
@Mapper
public interface SysConfigMapper extends BaseMapper<SysConfigEntity> {

    SysConfigEntity queryByKey(String key);
}
