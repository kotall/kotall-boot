package com.kotall.rms.api.controller;

import com.kotall.rms.api.annotation.AppConfig;
import com.kotall.rms.common.entity.litemall.LiteMallAppEntity;
import com.kotall.rms.common.entity.litemall.LiteMallStorageEntity;
import com.kotall.rms.common.integration.storage.StorageService;
import com.kotall.rms.common.utils.FileKit;
import com.kotall.rms.core.service.litemall.LiteMallStorageService;
import com.kotall.rms.web.util.ResultKit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/wx/storage")
@Validated
@Slf4j
public class WxStorageController {

    @Autowired
    private StorageService storageService;

    @Autowired
    private LiteMallStorageService liteMallStorageService;

    @PostMapping("/upload")
    public Object upload(@AppConfig LiteMallAppEntity appConfig, @RequestParam("file") MultipartFile file) throws IOException {
        String originalFilename = file.getOriginalFilename();
        String url = storageService.store(file.getInputStream(), file.getSize(), file.getContentType(), storageService.getActive(), FileKit.getFileSufix(originalFilename));

        LiteMallStorageEntity storageInfo = new LiteMallStorageEntity();
        storageInfo.setName(originalFilename);
        storageInfo.setSize((int) file.getSize());
        storageInfo.setType(file.getContentType());
        storageInfo.setKey(null);
        storageInfo.setUrl(url);
        storageInfo.setStoreId(appConfig.getStoreId());
        this.liteMallStorageService.save(storageInfo);

        Map<String, Object> data = new HashMap<>();
        data.put("url", url);
        return ResultKit.msg(data);
    }

    @GetMapping("/fetch/{key:.+}")
    public ResponseEntity<Resource> fetch(@PathVariable String key, @AppConfig LiteMallAppEntity appConfig) {
        LiteMallStorageEntity litemallStorage = liteMallStorageService.findByKey(key);
        if (key == null) {
            return ResponseEntity.notFound().build();
        }
        if(key.contains("../")){
            return ResponseEntity.badRequest().build();
        }
        String type = litemallStorage.getType();
        MediaType mediaType = MediaType.parseMediaType(type);

        Resource file = storageService.loadAsResource(key);
        if (file == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().contentType(mediaType).body(file);
    }

    @GetMapping("/download/{key:.+}")
    public ResponseEntity<Resource> download(@PathVariable String key, @AppConfig LiteMallAppEntity appConfig) {
        LiteMallStorageEntity litemallStorage = liteMallStorageService.findByKey(key);
        if (key == null) {
            return ResponseEntity.notFound().build();
        }
        if(key.contains("../")){
            return ResponseEntity.badRequest().build();
        }

        String type = litemallStorage.getType();
        MediaType mediaType = MediaType.parseMediaType(type);

        Resource file = storageService.loadAsResource(key);
        if (file == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().contentType(mediaType).header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

}
