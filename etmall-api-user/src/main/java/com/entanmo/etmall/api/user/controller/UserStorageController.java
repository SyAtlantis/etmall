package com.entanmo.etmall.api.user.controller;

import com.entanmo.etmall.core.service.StorageService;
import com.entanmo.etmall.core.util.CharUtil;
import com.entanmo.etmall.core.util.ResponseUtil;
import com.entanmo.etmall.db.domain.EtmallStorage;
import com.entanmo.etmall.db.service.EtmallStorageService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * 对象存储服务
 */
@RestController
@RequestMapping("/user/storage")
@Validated
public class UserStorageController {

    @Autowired
    private StorageService storageService;

    @Autowired
    private EtmallStorageService EtmallStorageService;

    private String generateKey(String originalFilename) {
        int index = originalFilename.lastIndexOf('.');
        String suffix = originalFilename.substring(index);

        String key = null;
        EtmallStorage storageInfo = null;

        do {
            key = CharUtil.getRandomString(20) + suffix;
            storageInfo = EtmallStorageService.findByKey(key);
        }
        while (storageInfo != null);

        return key;
    }

    @PostMapping("/upload")
    public Object upload(@RequestParam("file") MultipartFile file) throws IOException {
        String originalFilename = file.getOriginalFilename();
        EtmallStorage EtmallStorage = storageService.store(file.getInputStream(), file.getSize(), file.getContentType(), originalFilename);
        return ResponseUtil.ok(EtmallStorage);
    }

    /**
     * 访问存储对象
     */
    @GetMapping("/fetch/{key:.+}")
    public ResponseEntity<Resource> fetch(@PathVariable String key) {
        EtmallStorage EtmallStorage = EtmallStorageService.findByKey(key);
        if (key == null) {
            return ResponseEntity.notFound().build();
        }
        if (key.contains("../")) {
            return ResponseEntity.badRequest().build();
        }
        String type = EtmallStorage.getType();
        MediaType mediaType = MediaType.parseMediaType(type);

        Resource file = storageService.loadAsResource(key);
        if (file == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().contentType(mediaType).body(file);
    }

    /**
     * 访问存储对象
     */
    @GetMapping("/download/{key:.+}")
    public ResponseEntity<Resource> download(@PathVariable String key) {
        EtmallStorage EtmallStorage = EtmallStorageService.findByKey(key);
        if (key == null) {
            return ResponseEntity.notFound().build();
        }
        if (key.contains("../")) {
            return ResponseEntity.badRequest().build();
        }

        String type = EtmallStorage.getType();
        MediaType mediaType = MediaType.parseMediaType(type);

        Resource file = storageService.loadAsResource(key);
        if (file == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().contentType(mediaType).header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

}
