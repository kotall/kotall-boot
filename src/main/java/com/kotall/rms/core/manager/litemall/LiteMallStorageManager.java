package com.kotall.rms.core.manager.litemall;


import com.kotall.rms.common.entity.litemall.LiteMallStorageEntity;
import com.kotall.rms.common.entity.litemall.LitemallStorageExample;
import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Query;

import java.util.List;

/**
 * 文件存储表
 *
 * @author kotall
 * @date 2018年11月21日 下午2:11:06
 * @since 1.0.0
 */
public interface LiteMallStorageManager {

	List<LiteMallStorageEntity> listLiteMallStorage(Page<LiteMallStorageEntity> page, Query search);

	int saveLiteMallStorage(LiteMallStorageEntity liteMallStorage);

	LiteMallStorageEntity getLiteMallStorageById(Long id);

	int updateLiteMallStorage(LiteMallStorageEntity liteMallStorage);

	int batchRemove(Long[] id);

	LiteMallStorageEntity findByKey(LitemallStorageExample example);

	void add(LiteMallStorageEntity storageInfo);
}
