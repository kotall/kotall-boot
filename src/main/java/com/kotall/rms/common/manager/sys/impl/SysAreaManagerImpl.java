package com.kotall.rms.common.manager.sys.impl;

import java.util.List;

import com.kotall.rms.common.utils.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kotall.rms.common.dao.sys.SysAreaMapper;
import com.kotall.rms.common.entity.sys.SysAreaEntity;
import com.kotall.rms.common.manager.sys.SysAreaManager;

/**
 * 行政区域
 *
 * @author aracwong
 * @date 2017年8月18日 下午3:39:35
 */
@Component("sysAreaManager")
public class SysAreaManagerImpl implements SysAreaManager {

	@Autowired
	private SysAreaMapper sysAreaMapper;
	
	@Override
	public List<SysAreaEntity> listAreaByParentCode(Query query) {
		return sysAreaMapper.listAreaByParentCode(query);
	}

	@Override
	public int saveArea(SysAreaEntity area) {
		return sysAreaMapper.save(area);
	}

	@Override
	public SysAreaEntity getAreaById(Long areaId) {
		return sysAreaMapper.getObjectById(areaId);
	}

	@Override
	public int updateArea(SysAreaEntity area) {
		return sysAreaMapper.update(area);
	}

	@Override
	public int batchRemoveArea(Long[] id) {
		return sysAreaMapper.batchRemove(id);
	}
	
	@Override
	public boolean hasChildren(Long[] id) {
		for(Long typeId : id) {
			int count = sysAreaMapper.countAreaChildren(typeId);
			if(count > 0) {
				return true;
			}
		}
		return false;
	}
	
}
