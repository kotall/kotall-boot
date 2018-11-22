package com.kotall.rms.api.controller;

import com.kotall.rms.api.StorageService;
import com.kotall.rms.common.entity.litemall.LiteMallStoreEntity;
import com.kotall.rms.common.utils.CharUtil;
import com.kotall.rms.common.utils.Result;
import com.kotall.rms.core.service.litemall.LiteMallStoreService;
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
    private LiteMallStoreService liteMallStorageService;

    private String generateKey(String originalFilename) {
        int index = originalFilename.lastIndexOf('.');
        String suffix = originalFilename.substring(index);

        String key;
        LiteMallStoreEntity storageInfo;

        do {
            key = CharUtil.getRandomString(20) + suffix;
            storageInfo = liteMallStorageService.getLiteMallStoreById(new Long(key));
        }
        while (storageInfo != null);

        return key;
    }

    @PostMapping("/upload")
    public Object upload(@RequestParam("file") MultipartFile file) throws IOException {
        String originalFilename = file.getOriginalFilename();
        String url = storageService.store(file.getInputStream(), file.getSize(), file.getContentType(), originalFilename);

        Map<String, Object> data = new HashMap<>();
        data.put("url", url);
        return Result.ok().put("data", data);
    }

    @GetMapping("/fetch/{key:.+}")
    public ResponseEntity<Resource> fetch(@PathVariable String key) {
        LiteMallStoreEntity liteMallStorage = liteMallStorageService.getLiteMallStoreById(new Long(key));
        if (key == null) {
            return ResponseEntity.notFound().build();
        }
        if(key.contains("../")){
            return ResponseEntity.badRequest().build();
        }
        Integer type = liteMallStorage.getType();
        MediaType mediaType = MediaType.parseMediaType("" +type);

        Resource file = storageService.loadAsResource(key);
        if (file == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().contentType(mediaType).body(file);
    }

    @GetMapping("/download/{key:.+}")
    public ResponseEntity<Resource> download(@PathVariable String key) {
        LiteMallStoreEntity litemallStorage = liteMallStorageService.getLiteMallStoreById(new Long(key));
        if (key == null) {
            return ResponseEntity.notFound().build();
        }
        if(key.contains("../")){
            return ResponseEntity.badRequest().build();
        }

        Integer type = litemallStorage.getType();
        MediaType mediaType = MediaType.parseMediaType("" + type);

        Resource file = storageService.loadAsResource(key);
        if (file == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().contentType(mediaType).header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

}
