package com.kotall.rms.core.service.sys.impl;

import com.kotall.rms.common.entity.sys.SysOssEntity;
import com.kotall.rms.common.manager.sys.SysOssManager;
import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Query;
import com.kotall.rms.core.service.sys.SysOssService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 文件上传
 *
 * @author kotall
 * @date 2018年11月12日 下午10:28:34
 * @since 1.0.0
 */
@Service("sysOssService")
public class SysOssServiceImpl implements SysOssService {

	@Autowired
	private SysOssManager sysOssManager;

	@Override
	public Page<SysOssEntity> listSysOss(Map<String, Object> params) {
		Query query = new Query(params);
		Page<SysOssEntity> page = new Page<>(query);
		sysOssManager.listSysOss(page, query);
		return page;
	}

	@Override
	public int saveSysOss(SysOssEntity role) {
		int count = sysOssManager.saveSysOss(role);
		return count;
	}

	@Override
	public SysOssEntity getSysOssById(Long id) {
		SysOssEntity sysOss = sysOssManager.getSysOssById(id);
		return sysOss;
	}

	@Override
	public int updateSysOss(SysOssEntity sysOss) {
		int count = sysOssManager.updateSysOss(sysOss);
		return count;
	}

	@Override
	public int batchRemove(Long[] id) {
		int count = sysOssManager.batchRemove(id);
		return count;
	}

}
