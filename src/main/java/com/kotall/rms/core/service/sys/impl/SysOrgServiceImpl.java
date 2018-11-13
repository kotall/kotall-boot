package com.kotall.rms.core.service.sys.impl;

import com.kotall.rms.common.exception.RmsException;
import com.kotall.rms.common.entity.sys.SysOrgEntity;
import com.kotall.rms.common.manager.sys.SysOrgManager;
import com.kotall.rms.core.service.sys.SysOrgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
	
	@Override
	public List<SysOrgEntity> listOrg() {
		return sysOrgManager.listOrg();
	}

	@Override
	public List<SysOrgEntity> listOrgTree() {
		List<SysOrgEntity> orgList = sysOrgManager.listOrg();
		SysOrgEntity org = new SysOrgEntity();
		org.setOrgId(0L);
		org.setName("一级机构");
		org.setParentId(-1L);
		org.setOpen(true);
		orgList.add(org);
		return orgList;
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
		int count = sysOrgManager.bactchRemoveOrg(id);
		return count;
	}

	@Override
	public List<SysOrgEntity> listUserOrg(Long orgId) {
		List<SysOrgEntity> userOrgList = new ArrayList<>();
		List<SysOrgEntity> allOrgs = this.sysOrgManager.listOrg();
		SysOrgEntity rootOrg = this.sysOrgManager.getOrg(orgId);
		rootOrg.setParentId(0L);
		userOrgList.add(rootOrg);
		this.fillChilds(rootOrg, allOrgs, userOrgList);
		return userOrgList;
	}

	private void fillChilds(final SysOrgEntity rootOrg, final List<SysOrgEntity> allOrgs,
							final List<SysOrgEntity> userOrgList) {
		List<SysOrgEntity> subOrgList = new ArrayList<>();
		for (SysOrgEntity allOrg : allOrgs) {
			if (allOrg.getParentId().equals(rootOrg.getOrgId())) {
				subOrgList.add(allOrg);
			}
		}
		//rootOrg.setList(subOrgList);
		allOrgs.removeAll(subOrgList);

		if (subOrgList.size() > 0 && allOrgs.size() > 0) {
			userOrgList.addAll(subOrgList);
			for (SysOrgEntity sysOrgEntity : subOrgList) {
				fillChilds(sysOrgEntity, allOrgs, userOrgList);
			}
		}
	}
}
