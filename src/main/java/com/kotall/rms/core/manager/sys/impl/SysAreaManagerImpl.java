package com.kotall.rms.core.manager.sys.impl;

import com.kotall.rms.common.dao.sys.SysAreaMapper;
import com.kotall.rms.common.entity.sys.SysAreaEntity;
import com.kotall.rms.core.manager.BaseManagerImpl;
import com.kotall.rms.core.manager.sys.SysAreaManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 行政区域
 *
 * @author aracwong
 * @date 2017年8月18日 下午3:39:35
 */
@Component("sysAreaManager")
public class SysAreaManagerImpl extends BaseManagerImpl<SysAreaMapper,SysAreaEntity> implements SysAreaManager {

	@Autowired
	private SysAreaMapper sysAreaMapper;
	
	@Override
	public boolean hasChildren(Integer[] id) {
		for(Integer typeId : id) {
			int count = sysAreaMapper.countAreaChildren(typeId);
			if(count > 0) {
				return true;
			}
		}
		return false;
	}

	@Override
	public SysAreaEntity getByAreaCode(Integer areaCode) {
		return sysAreaMapper.getByAreaCode(areaCode);
	}
}
