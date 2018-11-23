package com.kotall.rms.core.service.sys.impl;

import com.kotall.rms.common.entity.sys.SysAreaEntity;
import com.kotall.rms.common.utils.Query;
import com.kotall.rms.core.RmsException;
import com.kotall.rms.core.manager.sys.SysAreaManager;
import com.kotall.rms.core.service.BaseServiceImpl;
import com.kotall.rms.core.service.sys.SysAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 行政区域
 *
 * @author aracwong
 * @date 2017年8月18日 下午3:40:57
 */
@Service("sysAreaService")
public class SysAreaServiceImpl extends BaseServiceImpl<SysAreaManager, SysAreaEntity> implements SysAreaService {

	@Autowired
	private SysAreaManager sysAreaManager;
	
	@Override
	public List<SysAreaEntity> listAreaByParentCode(String areaCode) {
		Query query = new Query();
		query.put("parentCode", areaCode);
		List<SysAreaEntity> areas = sysAreaManager.queryByList(query);
		for(SysAreaEntity area : areas) {
			area.checkParent();
		}
		return areas;
	}

	@Override
	public boolean removeByIds(Integer[] ids) throws RmsException {
		boolean children = sysAreaManager.hasChildren(ids);
		if(children) {
			throw RmsException.HAS_CHILD_EXCEPTION;
		}
		return sysAreaManager.deleteByIds(ids);
	}

}
