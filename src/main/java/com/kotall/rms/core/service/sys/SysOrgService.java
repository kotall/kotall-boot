package com.kotall.rms.core.service.sys;

import com.kotall.rms.common.entity.sys.SysOrgEntity;

import java.util.List;
import java.util.Map;

/**
 * 组织机构
 *
 * @author aracwong
 * @date 2017年8月17日 上午11:32:55
 */
public interface SysOrgService {

	List<SysOrgEntity> queryList(Map<String, Object> params);
	
	int saveOrg(SysOrgEntity org);

	SysOrgEntity getOrg(Long orgId);
	
	int updateOrg(SysOrgEntity org);
	
	int batchRemoveOrg(Long[] id);

	List<Long> queryOrgIdList(Long parentId);

	List<Long> getSubOrgIdList(Long orgId);
}
