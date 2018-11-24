package com.kotall.rms.core.service.litemall.impl;

import com.kotall.rms.common.entity.litemall.LiteMallBrandEntity;
import com.kotall.rms.common.utils.Page;
import com.kotall.rms.core.annotation.StoreFilter;
import com.kotall.rms.core.manager.litemall.LiteMallBrandManager;
import com.kotall.rms.core.service.BaseServiceImpl;
import com.kotall.rms.core.service.litemall.LiteMallBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 品牌商表
 *
 * @author kotall
 * @date 2018年11月13日 下午2:48:32
 * @since 1.0.0
 */
@Service("liteMallBrandService")
public class LiteMallBrandServiceImpl extends BaseServiceImpl<LiteMallBrandManager, LiteMallBrandEntity> implements LiteMallBrandService {

	@Autowired
	private LiteMallBrandManager liteMallBrandManager;

	@StoreFilter
	@Override
	public Page<LiteMallBrandEntity> queryBrandList(Map<String, Object> params) {
		return super.queryByPage(params);
	}

}
