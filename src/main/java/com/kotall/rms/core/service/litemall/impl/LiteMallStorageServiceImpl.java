package com.kotall.rms.core.service.litemall.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kotall.rms.common.utils.Query;
import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.entity.litemall.LiteMallStorageEntity;
import com.kotall.rms.core.manager.litemall.LiteMallStorageManager;
import com.kotall.rms.core.service.litemall.LiteMallStorageService;

/**
 * 文件存储表
 *
 * @author kotall
 * @date 2018年11月21日 上午11:42:26
 * @since 1.0.0
 */
@Service("liteMallStorageService")
public class LiteMallStorageServiceImpl implements LiteMallStorageService {

	@Autowired
	private LiteMallStorageManager liteMallStorageManager;

	@Override
	public Page<LiteMallStorageEntity> listLiteMallStorage(Map<String, Object> params) {
		Query query = new Query(params);
		Page<LiteMallStorageEntity> page = new Page<>(query);
		liteMallStorageManager.listLiteMallStorage(page, query);
		return page;
	}

	@Override
	public List<LiteMallStorageEntity> queryStorageList(Map<String, Object> params) {
        Query query = new Query(params);
		return this.liteMallStorageManager.queryStorageList(query);
	}

	@Override
	public int saveLiteMallStorage(LiteMallStorageEntity role) {
		int count = liteMallStorageManager.saveLiteMallStorage(role);
		return count;
	}

	@Override
	public LiteMallStorageEntity getLiteMallStorageById(Long id) {
		LiteMallStorageEntity liteMallStorage = liteMallStorageManager.getLiteMallStorageById(id);
		return liteMallStorage;
	}

	@Override
	public int updateLiteMallStorage(LiteMallStorageEntity liteMallStorage) {
		int count = liteMallStorageManager.updateLiteMallStorage(liteMallStorage);
		return count;
	}

	@Override
	public int batchRemove(Long[] id) {
		int count = liteMallStorageManager.batchRemove(id);
		return count;
	}

	@Override
	public LiteMallStorageEntity findByKey(String key) {
		Map<String, Object> params = new HashMap<>();
		params.put("key", key);
		List<LiteMallStorageEntity> list = this.queryStorageList(params);
		return CollectionUtils.isEmpty(list) ? null : list.get(0);
	}
}
