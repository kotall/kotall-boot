package com.kotall.rms.core.manager.litemall;

import java.util.List;

import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Query;
import com.kotall.rms.common.entity.litemall.LiteMallAddressEntity;

/**
 * 收货地址表
 *
 * @author kotall
 * @date 2018年11月13日 上午11:28:53
 * @since 1.0.0
 */
public interface LiteMallAddressManager {

	List<LiteMallAddressEntity> listLiteMallAddress(Page<LiteMallAddressEntity> page, Query search);
	
	int saveLiteMallAddress(LiteMallAddressEntity liteMallAddress);
	
	LiteMallAddressEntity getLiteMallAddressById(Long id);
	
	int updateLiteMallAddress(LiteMallAddressEntity liteMallAddress);
	
	int batchRemove(Long[] id);
	
}
