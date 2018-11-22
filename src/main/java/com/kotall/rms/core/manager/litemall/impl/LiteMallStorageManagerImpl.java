package com.kotall.rms.core.manager.litemall.impl;

import java.util.List;

import com.kotall.rms.common.dao.litemall.LiteMallStorageMapper;
import com.kotall.rms.common.entity.litemall.LiteMallStorageEntity;
import com.kotall.rms.common.entity.litemall.LitemallStorageExample;
import com.kotall.rms.core.manager.litemall.LiteMallStorageManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Query;

/**
 * 文件存储表
 *
 * @author kotall
 * @date 2018年11月21日 下午2:11:06
 * @since 1.0.0
 */
@Component("liteMallStorageManager")
public class LiteMallStorageManagerImpl implements LiteMallStorageManager {

	@Autowired
	private LiteMallStorageMapper liteMallStorageMapper;
	

	@Override
	public List<LiteMallStorageEntity> listLiteMallStorage(Page<LiteMallStorageEntity> page, Query search) {
		return liteMallStorageMapper.listForPage(page, search);
	}

	@Override
	public int saveLiteMallStorage(LiteMallStorageEntity liteMallStorage) {
		return liteMallStorageMapper.save(liteMallStorage);
	}

	@Override
	public LiteMallStorageEntity getLiteMallStorageById(Long id) {
		LiteMallStorageEntity liteMallStorage = liteMallStorageMapper.getObjectById(id);
		return liteMallStorage;
	}

	@Override
	public int updateLiteMallStorage(LiteMallStorageEntity liteMallStorage) {
		return liteMallStorageMapper.update(liteMallStorage);
	}

	@Override
	public int batchRemove(Long[] id) {
		int count = liteMallStorageMapper.batchRemove(id);
		return count;
	}

	@Override
	public LiteMallStorageEntity findByKey(LitemallStorageExample example) {
		return liteMallStorageMapper.findByKey(example);
	}

	@Override
	public void add(LiteMallStorageEntity storageInfo) {
		 liteMallStorageMapper.add(storageInfo);
	}

}
