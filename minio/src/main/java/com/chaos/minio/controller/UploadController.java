package com.chaos.minio.controller;

import com.chaos.minio.util.MinioUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @projectName: pic_up_down
 * @package: com.chaos.minio.controller
 * @className: UploadController
 * @author: chaos
 * @description: TODO
 * @date: 2022/11/21 15:02
 * @version: 1.0
 */
@Controller
public class UploadController {
    @Autowired
    MinioUtil minioUtil;
    @PostMapping("/upload")
    @ResponseBody
    public List<String> upload(@RequestParam("file") MultipartFile[] multipartFile) {
        return minioUtil.upload(multipartFile);
    }
}
