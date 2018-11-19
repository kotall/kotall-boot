package com.kotall.rms.core.manager.sys;

import java.util.List;

import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Query;
import com.kotall.rms.common.entity.sys.SysConfigEntity;

/**
 * 系统配置信息表
 *
 * @author kotall
 * @date 2018年11月12日 下午9:18:45
 * @since 1.0.0
 */
public interface SysConfigManager {

	List<SysConfigEntity> listSysConfig(Page<SysConfigEntity> page, Query search);
	
	int saveSysConfig(SysConfigEntity sysConfig);
	
	SysConfigEntity getSysConfigById(Long id);
	
	int updateSysConfig(SysConfigEntity sysConfig);
	
	int batchRemove(Long[] id);

	SysConfigEntity queryByKey(String key);

    List<SysConfigEntity> queryAll(Query query);
}
