package com.kotall.rms.core.manager.litemall;

import java.util.List;

import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Query;
import com.kotall.rms.common.entity.litemall.LiteMallStorageEntity;

/**
 * 文件存储表
 *
 * @author kotall
 * @date 2018年11月21日 上午11:42:26
 * @since 1.0.0
 */
public interface LiteMallStorageManager {

	List<LiteMallStorageEntity> listLiteMallStorage(Page<LiteMallStorageEntity> page, Query search);
	
	int saveLiteMallStorage(LiteMallStorageEntity liteMallStorage);
	
	LiteMallStorageEntity getLiteMallStorageById(Long id);
	
	int updateLiteMallStorage(LiteMallStorageEntity liteMallStorage);
	
	int batchRemove(Long[] id);

    List<LiteMallStorageEntity> queryStorageList(Query query);
}
