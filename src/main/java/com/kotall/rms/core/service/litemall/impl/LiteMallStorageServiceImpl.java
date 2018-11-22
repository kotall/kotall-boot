package com.kotall.rms.core.service.litemall.impl;

import java.io.InputStream;
import java.util.Map;

import com.kotall.rms.common.entity.litemall.LiteMallStorageEntity;
import com.kotall.rms.common.entity.litemall.LitemallStorage;
import com.kotall.rms.common.entity.litemall.LitemallStorageExample;
import com.kotall.rms.core.manager.litemall.LiteMallStorageManager;
import com.kotall.rms.core.service.litemall.LiteMallStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kotall.rms.common.utils.Query;
import com.kotall.rms.common.utils.Page;


/**package com.kotall.rms.core.service.litemall.impl;

 import java.io.InputStream;
 import java.util.Map;

 import com.kotall.rms.common.entity.litemall.LiteMallStorageEntity;
 import com.kotall.rms.common.entity.litemall.LitemallStorage;
 import com.kotall.rms.common.entity.litemall.LitemallStorageExample;
 import com.kotall.rms.core.manager.litemall.LiteMallStorageManager;
 import com.kotall.rms.core.service.litemall.LiteMallStorageService;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Service;

 import com.kotall.rms.common.utils.Query;
 import com.kotall.rms.common.utils.Page;


 /**
 * 文件存储表
 *
 * @author kotall
 * @date 2018年11月21日 下午2:11:06
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
		LitemallStorageExample example = new LitemallStorageExample();
		example.or().andKeyEqualTo(key).andDeletedEqualTo(false);
		return liteMallStorageManager.findByKey(example);
	}

	@Override
	public void add(LiteMallStorageEntity storageInfo) {
		liteMallStorageManager.add(storageInfo);
	}

	@Override
	public String store(InputStream inputStream, long size, String contentType, String originalFilename) {
		return null;
	}

}
