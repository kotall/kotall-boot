package com.kotall.rms.core.service.sys;

import com.kotall.rms.core.RmsException;
import com.kotall.rms.common.entity.sys.SysAreaEntity;

import java.util.List;
import java.util.Map;

/**
 * 行政区域
 *
 * @author aracwong
 * @date 2017年8月18日 下午3:40:18
 */
public interface SysAreaService {

	List<SysAreaEntity> listAreaByParentCode(String areaCode);

	List<SysAreaEntity> listAreaByParentCode(Map<String, Object> params);
	
	int saveArea(SysAreaEntity area);

	SysAreaEntity getAreaById(Long areaId);
	
	int updateArea(SysAreaEntity area);
	
	int batchRemoveArea(Long[] id) throws RmsException;
	
}
