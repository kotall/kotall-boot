package com.kotall.rms.core.manager.sys.impl;

import com.kotall.rms.common.dao.sys.SysOssMapper;
import com.kotall.rms.common.entity.sys.SysOssEntity;
import com.kotall.rms.core.manager.BaseManagerImpl;
import com.kotall.rms.core.manager.sys.SysOssManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 文件上传
 *
 * @author kotall
 * @date 2018年11月12日 下午10:28:34
 * @since 1.0.0
 */
@Component("sysOssManager")
public class SysOssManagerImpl extends BaseManagerImpl<SysOssMapper,SysOssEntity> implements SysOssManager {

	@Autowired
	private SysOssMapper sysOssMapper;
	

}
