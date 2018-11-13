package com.kotall.rms.common.dao.sys;

import org.apache.ibatis.annotations.Mapper;
import com.kotall.rms.common.entity.sys.SysJobEntity;


/**
 * 定时任务
 *
 * @author aracwong
 * @date 2017年8月20日 下午11:19:55
 */
@Mapper
public interface SysJobMapper extends BaseMapper<SysJobEntity> {

}
