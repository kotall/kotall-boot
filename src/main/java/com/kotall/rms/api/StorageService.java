package com.kotall.rms.api;


import com.kotall.rms.common.integration.storage.Storage;
import com.kotall.rms.common.entity.litemall.LiteMallStorageEntity;
import com.kotall.rms.common.utils.CharUtil;
import com.kotall.rms.core.service.litemall.LiteMallStorageService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;

import java.io.InputStream;
import java.nio.file.Path;
import java.util.stream.Stream;

/**
 * 提供存储服务类，所有存储服务均由该类对外提供
 */
@Data
public class StorageService {
    private String active;
    private Storage storage;
    @Autowired
    private LiteMallStorageService liteMallStorageService;

    /**
     * 存储一个文件对象
     *
     * @param inputStream   文件输入流
     * @param contentLength 文件长度
     * @param contentType   文件类型
     * @param fileName      文件索引名
     */
    public String store(InputStream inputStream, long contentLength, String contentType, String fileName) {
        String key = generateKey(fileName);
        storage.store(inputStream, contentLength, contentType, key);

        String url = generateUrl(key);
        LiteMallStorageEntity storageInfo = new LiteMallStorageEntity();
        storageInfo.setName(fileName);
        storageInfo.setSize((int) contentLength);
        storageInfo.setType(contentType);
        storageInfo.setKey(key);
        storageInfo.setUrl(url);
        liteMallStorageService.saveLiteMallStorage(storageInfo);

        return url;
    }

    private String generateKey(String originalFilename) {
        int index = originalFilename.lastIndexOf('.');
        String suffix = originalFilename.substring(index);

        String key;
        LiteMallStorageEntity storageInfo;

        do {
            key = CharUtil.getRandomString(20) + suffix;
            storageInfo = liteMallStorageService.findByKey(key);
        }
        while (storageInfo != null);

        return key;
    }

    public Stream<Path> loadAll() {
        return storage.loadAll();
    }

    public Path load(String keyName) {
        return storage.load(keyName);
    }

    public Resource loadAsResource(String keyName) {
        return storage.loadAsResource(keyName);
    }

    public void delete(String keyName) {
        storage.delete(keyName);
    }

    private String generateUrl(String keyName) {
        return storage.generateUrl(keyName);
    }
}
