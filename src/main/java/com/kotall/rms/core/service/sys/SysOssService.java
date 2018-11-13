package com.kotall.rms.core.service.sys;

import java.util.Map;

import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Result;
import com.kotall.rms.common.entity.sys.SysOssEntity;

/**
 * 文件上传
 *
 * @author kotall
 * @date 2018年11月12日 下午10:28:34
 * @since 1.0.0
 */
public interface SysOssService {

	Page<SysOssEntity> listSysOss(Map<String, Object> params);

    int saveSysOss(SysOssEntity sysOss);

    SysOssEntity getSysOssById(Long id);

    int updateSysOss(SysOssEntity sysOss);

    int batchRemove(Long[] id);
	
}
