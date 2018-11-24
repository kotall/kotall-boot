package com.kotall.rms.core.manager.sys.impl;

import com.kotall.rms.common.dao.sys.SysOrgMapper;
import com.kotall.rms.common.dao.sys.SysRoleOrgMapper;
import com.kotall.rms.common.entity.sys.SysOrgEntity;
import com.kotall.rms.core.manager.BaseManagerImpl;
import com.kotall.rms.core.manager.sys.SysOrgManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 组织架构
 *
 * @author aracwong
 * @date 2017年8月17日 上午11:32:15
 */
@Component("sysOrgManager")
public class SysOrgManagerImpl extends BaseManagerImpl<SysOrgMapper, SysOrgEntity> implements SysOrgManager {

	@Autowired
	private SysOrgMapper sysOrgMapper;
	
	@Autowired
	private SysRoleOrgMapper sysRoleOrgMapper;

	@Override
	@Transactional(rollbackFor = Exception.class)
	public int batchRemoveOrg(Integer[] id) {
		int count = sysOrgMapper.batchDelete(id);
		sysRoleOrgMapper.batchRemoveByOrgId(id);
		return count;
	}

	@Override
	public boolean hasChildren(Integer[] id) {
		for(Integer parentId : id) {
			int count = sysOrgMapper.countOrgChildren(parentId);
			if(count > 0) {
				return true;
			}
		}
		return false;
	}

	@Override
	public List<Integer> queryOrgIdList(Integer parentId) {
		return this.sysOrgMapper.queryOrgIdList(parentId);
	}
}
