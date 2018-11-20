package com.kotall.rms.core.manager.sys;

import java.util.List;

import com.kotall.rms.common.utils.Query;
import com.kotall.rms.common.entity.sys.SysAreaEntity;

/**
 * 行政区域
 *
 * @author aracwong
 * @date 2017年8月18日 下午3:39:00
 */
public interface SysAreaManager {

	List<SysAreaEntity> listAreaByParentCode(Query query);
	
	int saveArea(SysAreaEntity area);
	
	SysAreaEntity getAreaById(Long areaId);
	
	int updateArea(SysAreaEntity area);
	
	int batchRemoveArea(Long[] id);
	
	boolean hasChildren(Long[] id);

}
