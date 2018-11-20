package com.kotall.rms.core.manager.litemall;

import java.util.List;

import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Query;
import com.kotall.rms.common.entity.litemall.LiteMallUserFormidEntity;

/**
 * 
 *
 * @author kotall
 * @date 2018年11月20日 下午1:56:37
 * @since 1.0.0
 */
public interface LiteMallUserFormidManager {

	List<LiteMallUserFormidEntity> listLiteMallUserFormid(Page<LiteMallUserFormidEntity> page, Query search);
	
	int saveLiteMallUserFormid(LiteMallUserFormidEntity liteMallUserFormid);
	
	LiteMallUserFormidEntity getLiteMallUserFormidById(Long id);
	
	int updateLiteMallUserFormid(LiteMallUserFormidEntity liteMallUserFormid);
	
	int batchRemove(Long[] id);
	
}
