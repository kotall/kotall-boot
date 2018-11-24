package com.kotall.rms.core.service.litemall.impl;

import com.kotall.rms.common.entity.litemall.LiteMallFootprintEntity;
import com.kotall.rms.common.utils.Page;
import com.kotall.rms.core.annotation.StoreFilter;
import com.kotall.rms.core.manager.litemall.LiteMallFootprintManager;
import com.kotall.rms.core.service.BaseServiceImpl;
import com.kotall.rms.core.service.litemall.LiteMallFootprintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 用户浏览足迹表
 *
 * @author kotall
 * @date 2018年11月13日 下午2:10:19
 * @since 1.0.0
 */
@Service("liteMallFootprintService")
public class LiteMallFootprintServiceImpl extends BaseServiceImpl<LiteMallFootprintManager, LiteMallFootprintEntity> implements LiteMallFootprintService {

	@Autowired
	private LiteMallFootprintManager liteMallFootprintManager;

	@StoreFilter
	@Override
	public Page<LiteMallFootprintEntity> queryFootprintByPage(Map<String, Object> params) {
		return super.queryByPage(params);
	}
}
