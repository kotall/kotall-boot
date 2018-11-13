package com.kotall.rms.core.service.sys.impl;

import com.kotall.rms.common.utils.Query;
import com.kotall.rms.core.RmsException;
import com.kotall.rms.common.entity.sys.SysAreaEntity;
import com.kotall.rms.common.manager.sys.SysAreaManager;
import com.kotall.rms.core.service.sys.SysAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 行政区域
 *
 * @author aracwong
 * @date 2017年8月18日 下午3:40:57
 */
@Service("sysAreaService")
public class SysAreaServiceImpl implements SysAreaService {

	@Autowired
	private SysAreaManager sysAreaManager;
	
	@Override
	public List<SysAreaEntity> listAreaByParentCode(String areaCode) {
		Query query = new Query();
		query.put("parentCode", areaCode);
		List<SysAreaEntity> areas = sysAreaManager.listAreaByParentCode(query);
		for(SysAreaEntity area : areas) {
			area.checkParent();
		}
		return areas;
	}

	@Override
	public int saveArea(SysAreaEntity area) {
		int count = sysAreaManager.saveArea(area);
		return count;
	}

	@Override
	public SysAreaEntity getAreaById(Long areaId) {
		SysAreaEntity area = sysAreaManager.getAreaById(areaId);
		area.checkParentName();
		return area;
	}

	@Override
	public int updateArea(SysAreaEntity area) {
		int count = sysAreaManager.updateArea(area);
		return count;
	}

	@Override
	public int batchRemoveArea(Long[] id) throws RmsException {
		boolean children = sysAreaManager.hasChildren(id);
		if(children) {
			throw RmsException.HAS_CHILD_EXCEPTION;
		}
		int count = sysAreaManager.batchRemoveArea(id);
		return count;
	}

	@Override
	public List<SysAreaEntity> listAreaByParentCode(Map<String, Object> params) {
		Query query = new Query(params);
		List<SysAreaEntity> areas = sysAreaManager.listAreaByParentCode(query);
		return areas;
	}

}
