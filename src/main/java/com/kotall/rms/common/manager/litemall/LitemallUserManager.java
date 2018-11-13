package com.kotall.rms.common.manager.litemall;

import java.util.List;

import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Query;
import com.kotall.rms.common.entity.litemall.LitemallUserEntity;

/**
 * 用户表
 *
 * @author kotall
 * @date 2018年11月13日 上午9:47:19
 * @since 1.0.0
 */
public interface LitemallUserManager {

	List<LitemallUserEntity> listLitemallUser(Page<LitemallUserEntity> page, Query search);
	
	int saveLitemallUser(LitemallUserEntity litemallUser);
	
	LitemallUserEntity getLitemallUserById(Long id);
	
	int updateLitemallUser(LitemallUserEntity litemallUser);
	
	int batchRemove(Long[] id);
	
}
