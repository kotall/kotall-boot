package com.kotall.rms.core.service.litemall;

import java.util.List;
import java.util.Map;

import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Result;
import com.kotall.rms.common.entity.litemall.LiteMallStorageEntity;

/**
 * 文件存储表
 *
 * @author kotall
 * @date 2018年11月21日 上午11:42:26
 * @since 1.0.0
 */
public interface LiteMallStorageService {

	Page<LiteMallStorageEntity> listLiteMallStorage(Map<String, Object> params);

    int saveLiteMallStorage(LiteMallStorageEntity liteMallStorage);

    LiteMallStorageEntity getLiteMallStorageById(Long id);

    int updateLiteMallStorage(LiteMallStorageEntity liteMallStorage);

    int batchRemove(Long[] id);

    LiteMallStorageEntity findByKey(String key);

    List<LiteMallStorageEntity> queryStorageList(Map<String, Object> params);
}
