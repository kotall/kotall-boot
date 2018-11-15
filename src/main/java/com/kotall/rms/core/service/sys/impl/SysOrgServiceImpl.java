package com.kotall.rms.core.service.sys.impl;

import com.kotall.rms.common.entity.sys.SysUserEntity;
import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Query;
import com.kotall.rms.core.RmsException;
import com.kotall.rms.common.entity.sys.SysOrgEntity;
import com.kotall.rms.core.annotation.DataFilter;
import com.kotall.rms.core.manager.sys.SysOrgManager;
import com.kotall.rms.core.service.sys.SysOrgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 组织机构
 *
 * @author aracwong
 * @date 2017年8月17日 上午11:33:28
 */
@Service("sysOrgService")
public class SysOrgServiceImpl implements SysOrgService {

	@Autowired
	private SysOrgManager sysOrgManager;

	@DataFilter(subDept = true, user = false)
	@Override
	public List<SysOrgEntity> queryList(Map<String, Object> params) {
		Query form = new Query(params);
		List<SysOrgEntity> sysOrgList = sysOrgManager.listOrg(form);
		return sysOrgList;
	}

	@Override
	public int saveOrg(SysOrgEntity org) {
		int count = sysOrgManager.saveOrg(org);
		return count;
	}

	@Override
	public SysOrgEntity getOrg(Long orgId) {
		SysOrgEntity org = sysOrgManager.getOrg(orgId);
		return org;
	}

	@Override
	public int updateOrg(SysOrgEntity org) {
		int count = sysOrgManager.updateOrg(org);
		return count;
	}

	@Override
	public int batchRemoveOrg(Long[] id) {
		boolean children = sysOrgManager.hasChildren(id);
		if(children) {
			throw RmsException.HAS_CHILD_EXCEPTION;
		}
		int count = sysOrgManager.batchRemoveOrg(id);
		return count;
	}

	@Override
	public List<Long> queryOrgIdList(Long parentId) {
		return sysOrgManager.queryOrgIdList(parentId);
	}

	@Override
	public List<Long> getSubOrgIdList(Long deptId){
		// 部门及子部门ID列表
		List<Long> deptIdList = new ArrayList<>();

		// 获取子部门ID
		List<Long> subIdList = queryOrgIdList(deptId);
		getDeptTreeList(subIdList, deptIdList);

		return deptIdList;
	}

	/**
	 * 递归
	 */
	private void getDeptTreeList(List<Long> subIdList, List<Long> deptIdList){
		for(Long deptId : subIdList){
			List<Long> list = queryOrgIdList(deptId);
			if(list.size() > 0){
				getDeptTreeList(list, deptIdList);
			}
			deptIdList.add(deptId);
		}
	}

}
