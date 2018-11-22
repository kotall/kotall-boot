package com.kotall.rms.core.service.litemall;

import java.io.InputStream;
import java.util.Map;

import com.kotall.rms.common.entity.litemall.LiteMallStorageEntity;
import com.kotall.rms.common.entity.litemall.LitemallStorage;
import com.kotall.rms.common.utils.Page;

/**
 * 文件存储表
 *
 * @author kotall
 * @date 2018年11月21日 下午2:11:06
 * @since 1.0.0
 */
public interface LiteMallStorageService {

	Page<LiteMallStorageEntity> listLiteMallStorage(Map<String, Object> params);

    int saveLiteMallStorage(LiteMallStorageEntity liteMallStorage);

    LiteMallStorageEntity getLiteMallStorageById(Long id);

    int updateLiteMallStorage(LiteMallStorageEntity liteMallStorage);

    int batchRemove(Long[] id);

    LiteMallStorageEntity findByKey(String key);

    void add(LiteMallStorageEntity storageInfo);

    String store(InputStream inputStream, long size, String contentType, String originalFilename);
}
