package com.kotall.rms.core.service.litemall;

import com.kotall.rms.common.entity.litemall.LiteMallStorageEntity;
import com.kotall.rms.core.service.BaseService;

import java.io.InputStream;

/**
 * 文件存储表
 *
 * @author kotall
 * @date 2018年11月21日 下午2:11:06
 * @since 1.0.0
 */
public interface LiteMallStorageService extends BaseService<LiteMallStorageEntity> {

    LiteMallStorageEntity findByKey(String key);

    String store(InputStream inputStream, long size, String contentType, String originalFilename);
}
