package com.kotall.rms.core.manager.sys;

import com.kotall.rms.common.entity.sys.SysOrgEntity;
import com.kotall.rms.core.manager.BaseManager;

import java.util.List;

/**
 * 组织机构
 *
 * @author aracwong
 * @date 2017年8月17日 上午11:31:59
 * @since 1.0.0
 */
public interface SysOrgManager extends BaseManager<SysOrgEntity> {

	int batchRemoveOrg(Integer[] id);
	
	boolean hasChildren(Integer[] id);

	/**
	 * 根据 parentId 查询下级机构 ID
	 * @param parentId
	 * @return
	 */
    List<Integer> queryOrgIdList(Integer parentId);
}
