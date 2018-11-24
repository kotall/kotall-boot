package com.kotall.rms.core.manager.litemall;

import java.util.List;

import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Query;
import com.kotall.rms.common.entity.litemall.LiteMallAddressEntity;
import com.kotall.rms.core.manager.BaseManager;

/**
 * 收货地址表
 *
 * @author kotall
 * @date 2018年11月13日 上午11:28:53
 * @since 1.0.0
 */
public interface LiteMallAddressManager extends BaseManager<LiteMallAddressEntity> {

//	List<LiteMallAddressEntity> queryByPage(Page<LiteMallAddressEntity> page, Query search);
//
//	List<LiteMallAddressEntity> queryByList(Query query);
//
//	int insert(LiteMallAddressEntity liteMallAddress);
//
//	LiteMallAddressEntity getById(Integer id);
//
//	int update(LiteMallAddressEntity liteMallAddress);
//
//	int deleteByIds(Integer[] id);

    List<LiteMallAddressEntity> queryByUserId(Integer userId);

	void resetDefault(LiteMallAddressEntity address, Query query);

}
