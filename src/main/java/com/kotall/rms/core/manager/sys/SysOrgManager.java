package com.kotall.rms.core.manager.sys;

import java.util.List;

import com.kotall.rms.common.entity.sys.SysOrgEntity;

/**
 * 组织机构
 *
 * @author aracwong
 * @date 2017年8月17日 上午11:31:59
 * @since 1.0.0
 */
public interface SysOrgManager {

	List<SysOrgEntity> listOrg();
	
	int saveOrg(SysOrgEntity org);
	
	SysOrgEntity getOrg(Long orgId);
	
	int updateOrg(SysOrgEntity org);
	
	int batchRemoveOrg(Long[] id);
	
	boolean hasChildren(Long[] id);

	/**
	 * 根据 parentId 查询下级机构 ID
	 * @param parentId
	 * @return
	 */
    List<Long> queryOrgIdList(Long parentId);
}
