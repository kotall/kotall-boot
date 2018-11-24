package com.kotall.rms.core.service.sys.impl;

import com.kotall.rms.common.entity.sys.SysOssEntity;
import com.kotall.rms.core.manager.sys.SysOssManager;
import com.kotall.rms.core.service.BaseServiceImpl;
import com.kotall.rms.core.service.sys.SysOssService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 文件上传
 *
 * @author kotall
 * @date 2018年11月12日 下午10:28:34
 * @since 1.0.0
 */
@Service("sysOssService")
public class SysOssServiceImpl extends BaseServiceImpl<SysOssManager, SysOssEntity> implements SysOssService {

	@Autowired
	private SysOssManager sysOssManager;


}
