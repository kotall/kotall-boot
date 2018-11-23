package com.kotall.rms.core.manager.sys;

import com.kotall.rms.common.entity.sys.SysConfigEntity;
import com.kotall.rms.common.utils.Query;
import com.kotall.rms.core.manager.BaseManager;

import java.util.List;

/**
 * 系统配置信息表
 *
 * @author kotall
 * @date 2018年11月12日 下午9:18:45
 * @since 1.0.0
 */
public interface SysConfigManager extends BaseManager<SysConfigEntity> {

	SysConfigEntity queryByKey(String key);

    List<SysConfigEntity> queryAll(Query query);
}
