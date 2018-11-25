package com.kotall.rms.core.service.sys;

import com.kotall.rms.common.entity.sys.SysOrgEntity;
import com.kotall.rms.core.service.BaseService;

import java.util.List;
import java.util.Map;

/**
 * 组织机构
 *
 * @author aracwong
 * @date 2017年8月17日 上午11:32:55
 */
public interface SysOrgService extends BaseService<SysOrgEntity> {

	List<SysOrgEntity> queryDeptByList(Map<String, Object> params);

	int batchRemoveOrg(Integer[] id);

	List<Integer> queryOrgIdList(Integer parentId);

	List<Integer> getSubOrgIdList(Integer orgId);

	/**
	 * 根据机构列表， 分析出根机构ID
	 * @param deptList
	 * @return
	 */
	Integer getRootDeptId(List<SysOrgEntity> deptList);

}
