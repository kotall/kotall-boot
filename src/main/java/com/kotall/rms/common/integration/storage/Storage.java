package com.kotall.rms.common.integration.storage;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.util.stream.Stream;

/**
 * 对象存储接口
 */
public abstract class Storage {

    /**
     * 存储一个文件对象
     * @param inputStream 文件输入流
     * @param contentLength 文件长度
     * @param contentType 文件类型
     * @param keyName   文件名
     */
    public abstract void store(InputStream inputStream, long contentLength, String contentType, String keyName);

    public abstract Stream<Path> loadAll();

    public abstract Path load(String keyName);

    public Resource loadAsResource(String keyName) {
        try {
            URL url = new URL(generateUrl(keyName));
            Resource resource = new UrlResource(url);
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                return null;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public abstract void delete(String keyName);

    public abstract String generateUrl(String keyName);
}