package com.kotall.rms.common.integration.storage;


import com.kotall.rms.common.utils.DateUtils;
import lombok.Data;
import org.apache.commons.lang.StringUtils;
import org.springframework.core.io.Resource;

import java.io.InputStream;
import java.nio.file.Path;
import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

/**
 * 提供存储服务类，所有存储服务均由该类对外提供
 */
@Data
public class StorageService {

    private String active;

    private Storage storage;

    /**
     * 存储一个文件对象
     *
     * @param inputStream   文件输入流
     * @param contentLength 文件长度
     * @param contentType   文件类型
     * @param prefix        文件路径前缀
     * @param suffix        文件路径后缀
     */
    public String store(InputStream inputStream, long contentLength, String contentType, String prefix, String suffix) {
        String key = getPath(prefix, suffix);
        storage.store(inputStream, contentLength, contentType, key);
        String url = generateUrl(key);
        return url;
    }

    /**
     * 文件路径
     * @param prefix 前缀
     * @param suffix 后缀
     * @return 返回上传路径
     */
    public String getPath(String prefix, String suffix) {
        // 生成uuid
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        // 文件路径
        String path = DateUtils.format(new Date(), "yyyyMMdd") + "/" + uuid;

        if(StringUtils.isNotBlank(prefix)){
            path = prefix + "/" + path;
        }

        return path + suffix;
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
