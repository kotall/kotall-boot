package com.kotall.rms.core.service.sys;

import com.kotall.rms.core.RmsException;
import com.kotall.rms.common.entity.sys.SysAreaEntity;
import com.kotall.rms.core.service.BaseService;

import java.util.List;
import java.util.Map;

/**
 * 行政区域
 *
 * @author aracwong
 * @date 2017年8月18日 下午3:40:18
 */
public interface SysAreaService extends BaseService<SysAreaEntity> {

	List<SysAreaEntity> listAreaByParentCode(String areaCode);

	boolean removeByIds(Integer[] ids) throws RmsException;

}
