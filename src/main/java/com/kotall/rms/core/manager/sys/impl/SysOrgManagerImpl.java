package com.kotall.rms.core.manager.sys.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kotall.rms.common.dao.sys.SysOrgMapper;
import com.kotall.rms.common.dao.sys.SysRoleOrgMapper;
import com.kotall.rms.common.entity.sys.SysOrgEntity;
import com.kotall.rms.core.manager.sys.SysOrgManager;
import org.springframework.transaction.annotation.Transactional;

/**
 * 组织架构
 *
 * @author aracwong
 * @date 2017年8月17日 上午11:32:15
 */
@Component("sysOrgManager")
public class SysOrgManagerImpl implements SysOrgManager {

	@Autowired
	private SysOrgMapper sysOrgMapper;
	
	@Autowired
	private SysRoleOrgMapper sysRoleOrgMapper;
	
	@Override
	public List<SysOrgEntity> listOrg() {
		return sysOrgMapper.list();
	}

	@Override
	public int saveOrg(SysOrgEntity org) {
		return sysOrgMapper.save(org);
	}

	@Override
	public SysOrgEntity getOrg(Long orgId) {
		return sysOrgMapper.getObjectById(orgId);
	}

	@Override
	public int updateOrg(SysOrgEntity org) {
		return sysOrgMapper.update(org);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public int batchRemoveOrg(Long[] id) {
		int count = sysOrgMapper.batchRemove(id);
		sysRoleOrgMapper.batchRemoveByOrgId(id);
		return count;
	}

	@Override
	public boolean hasChildren(Long[] id) {
		for(Long parentId : id) {
			int count = sysOrgMapper.countOrgChildren(parentId);
			if(count > 0) {
				return true;
			}
		}
		return false;
	}

	@Override
	public List<Long> queryOrgIdList(Long parentId) {
		return this.sysOrgMapper.queryOrgIdList(parentId);
	}
}
