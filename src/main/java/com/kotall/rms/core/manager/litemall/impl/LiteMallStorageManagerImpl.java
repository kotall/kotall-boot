package com.kotall.rms.core.manager.litemall.impl;

import com.kotall.rms.common.dao.litemall.LiteMallStorageMapper;
import com.kotall.rms.common.entity.litemall.LiteMallStorageEntity;
import com.kotall.rms.common.entity.litemall.LitemallStorageExample;
import com.kotall.rms.core.manager.BaseManagerImpl;
import com.kotall.rms.core.manager.litemall.LiteMallStorageManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 文件存储表
 *
 * @author kotall
 * @date 2018年11月21日 下午2:11:06
 * @since 1.0.0
 */
@Component("liteMallStorageManager")
public class LiteMallStorageManagerImpl extends BaseManagerImpl<LiteMallStorageMapper, LiteMallStorageEntity> implements LiteMallStorageManager {

	@Autowired
	private LiteMallStorageMapper liteMallStorageMapper;

	@Override
	public LiteMallStorageEntity findByKey(LitemallStorageExample example) {
		return liteMallStorageMapper.findByKey(example);
	}

}
