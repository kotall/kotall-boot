package com.kotall.rms.common.dao.sys;

import java.util.List;

import com.kotall.rms.common.dao.BaseMapper;
import com.kotall.rms.common.utils.Query;
import com.kotall.rms.common.entity.sys.SysAreaEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 行政区域
 *
 * @author aracwong
 * @date 2017年8月18日 下午3:36:04
 */
@Mapper
public interface SysAreaMapper extends BaseMapper<SysAreaEntity> {

	List<SysAreaEntity> listAreaByParentCode(Query query);
	
	int countAreaChildren(Integer areaId);

    SysAreaEntity getByAreaCode(Integer areaCode);
}
