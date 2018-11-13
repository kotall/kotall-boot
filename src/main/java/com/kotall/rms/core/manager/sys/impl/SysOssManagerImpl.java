package com.kotall.rms.core.manager.sys.impl;

import java.util.List;

import com.kotall.rms.core.manager.sys.SysOssManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Query;
import com.kotall.rms.common.dao.sys.SysOssMapper;
import com.kotall.rms.common.entity.sys.SysOssEntity;

/**
 * 文件上传
 *
 * @author kotall
 * @date 2018年11月12日 下午10:28:34
 * @since 1.0.0
 */
@Component("sysOssManager")
public class SysOssManagerImpl implements SysOssManager {

	@Autowired
	private SysOssMapper sysOssMapper;
	

	@Override
	public List<SysOssEntity> listSysOss(Page<SysOssEntity> page, Query search) {
		return sysOssMapper.listForPage(page, search);
	}

	@Override
	public int saveSysOss(SysOssEntity sysOss) {
		return sysOssMapper.save(sysOss);
	}

	@Override
	public SysOssEntity getSysOssById(Long id) {
		SysOssEntity sysOss = sysOssMapper.getObjectById(id);
		return sysOss;
	}

	@Override
	public int updateSysOss(SysOssEntity sysOss) {
		return sysOssMapper.update(sysOss);
	}

	@Override
	public int batchRemove(Long[] id) {
		int count = sysOssMapper.batchRemove(id);
		return count;
	}
	
}
