package com.kotall.rms.core.service.sys;

import com.kotall.rms.common.entity.sys.SysOrgEntity;

import java.util.List;

/**
 * 组织机构
 *
 * @author aracwong
 * @date 2017年8月17日 上午11:32:55
 */
public interface SysOrgService {

	List<SysOrgEntity> listOrg();
	
	List<SysOrgEntity> listOrgTree();
	
	int saveOrg(SysOrgEntity org);

	SysOrgEntity getOrg(Long orgId);
	
	int updateOrg(SysOrgEntity org);
	
	int batchRemoveOrg(Long[] id);

	/**
	 * 查询下级机构列表
	 * @param orgId
	 * @return
     */
	List<SysOrgEntity> listUserOrg(Long orgId);
}
