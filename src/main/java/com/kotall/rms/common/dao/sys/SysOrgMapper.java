package com.kotall.rms.common.dao.sys;

import com.kotall.rms.common.entity.sys.SysOrgEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 组织架构
 *
 * @author aracwong
 * @date 2017年8月17日 上午11:26:05
 * @since 1.0.0
 */
@Mapper
public interface SysOrgMapper extends BaseMapper<SysOrgEntity> {

	int countOrgChildren(Integer parentId);

	List<Integer> queryOrgIdList(Integer parentId);
}
