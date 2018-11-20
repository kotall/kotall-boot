package com.kotall.rms.core.manager.litemall;

import java.util.List;

import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Query;
import com.kotall.rms.common.entity.litemall.LiteMallUserEntity;

/**
 * 用户表
 *
 * @author kotall
 * @date 2018年11月13日 上午10:18:32
 * @since 1.0.0
 */
public interface LiteMallUserManager {

	List<LiteMallUserEntity> listLiteMallUser(Page<LiteMallUserEntity> page, Query search);
	
	int saveLiteMallUser(LiteMallUserEntity liteMallUser);
	
	LiteMallUserEntity getLiteMallUserById(Long id);
	
	int updateLiteMallUser(LiteMallUserEntity liteMallUser);
	
	int batchRemove(Long[] id);

    List<LiteMallUserEntity> queryUserList(Query query);
}
