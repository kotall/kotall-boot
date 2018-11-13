package com.kotall.rms.common.manager.sys;

import java.util.List;

import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Query;
import com.kotall.rms.common.entity.sys.SysOssEntity;

/**
 * 文件上传
 *
 * @author kotall
 * @date 2018年11月12日 下午10:28:34
 * @since 1.0.0
 */
public interface SysOssManager {

	List<SysOssEntity> listSysOss(Page<SysOssEntity> page, Query search);
	
	int saveSysOss(SysOssEntity sysOss);
	
	SysOssEntity getSysOssById(Long id);
	
	int updateSysOss(SysOssEntity sysOss);
	
	int batchRemove(Long[] id);
	
}
