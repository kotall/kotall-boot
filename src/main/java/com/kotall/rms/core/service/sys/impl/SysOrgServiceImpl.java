package com.kotall.rms.core.service.sys.impl;

import com.kotall.rms.common.entity.sys.SysOrgEntity;
import com.kotall.rms.common.utils.Query;
import com.kotall.rms.core.RmsException;
import com.kotall.rms.core.annotation.DeptFilter;
import com.kotall.rms.core.manager.sys.SysOrgManager;
import com.kotall.rms.core.service.BaseServiceImpl;
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
public class SysOrgServiceImpl extends BaseServiceImpl<SysOrgManager, SysOrgEntity> implements SysOrgService {

	@Autowired
	private SysOrgManager sysOrgManager;

	@DeptFilter(subDept = true, user = false)
	@Override
	public List<SysOrgEntity> queryDeptByList(Map<String, Object> params) {
		return super.queryByList(params);
	}

	@Override
	public int batchRemoveOrg(Integer[] id) {
		boolean children = sysOrgManager.hasChildren(id);
		if(children) {
			throw RmsException.HAS_CHILD_EXCEPTION;
		}
		int count = sysOrgManager.batchRemoveOrg(id);
		return count;
	}

	@Override
	public List<Integer> queryOrgIdList(Integer parentId) {
		return sysOrgManager.queryOrgIdList(parentId);
	}

	@Override
	public List<Integer> getSubOrgIdList(Integer deptId){
		// 部门及子部门ID列表
		List<Integer> deptIdList = new ArrayList<>();

		// 获取子部门ID
		List<Integer> subIdList = queryOrgIdList(deptId);
		getDeptTreeList(subIdList, deptIdList);

		return deptIdList;
	}

	/**
	 * 递归
	 */
	private void getDeptTreeList(List<Integer> subIdList, List<Integer> deptIdList){
		for(Integer deptId : subIdList){
			List<Integer> list = queryOrgIdList(deptId);
			if(list.size() > 0){
				getDeptTreeList(list, deptIdList);
			}
			deptIdList.add(deptId);
		}
	}

	@Override
	public Integer getRootDeptId(List<SysOrgEntity> deptList) {
		Integer deptId;
		Integer parentId = null;
		for(SysOrgEntity sysDeptEntity : deptList){
			if(parentId == null){
				parentId = sysDeptEntity.getParentId();
				continue;
			}

			if(parentId > sysDeptEntity.getParentId()){
				parentId = sysDeptEntity.getParentId();
			}
		}
		deptId = parentId;
		return deptId;
	}
}
