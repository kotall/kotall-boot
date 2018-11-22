package com.kotall.rms.common.integration.storage;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import lombok.Data;

import java.io.InputStream;
import java.nio.file.Path;
import java.util.stream.Stream;
@Data
public class QiniuStorage extends Storage {

    private  String endpoint;
    private String accessKey;
    private String secretKey;
    private String bucketName;
    private Auth auth;
    private UploadManager uploadManager;
    private BucketManager bucketManager;


    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    /**
     * 七牛云OSS对象存储简单上传实现
     */
    @Override
    public void store(InputStream inputStream, long contentLength, String contentType, String keyName) {
        if(uploadManager == null){
            if(auth == null) {
                auth = Auth.create(accessKey, secretKey);
            }
            uploadManager = new UploadManager(new Configuration());
        }

        try {
            String upToken = auth.uploadToken(bucketName);
            Response response = uploadManager.put(inputStream, keyName, upToken, null, contentType);
        } catch (QiniuException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Stream<Path> loadAll() {
        return null;
    }

    @Override
    public Path load(String keyName) {
        return null;
    }

    @Override
    public void delete(String keyName) {
        if(bucketManager == null){
            if(auth == null) {
                auth = Auth.create(accessKey, secretKey);
            }
            bucketManager = new BucketManager(auth, new Configuration() );
        }

        try {
            bucketManager.delete(bucketName, keyName);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public String generateUrl(String keyName) {
        return endpoint + "/" + keyName;
    }
}
