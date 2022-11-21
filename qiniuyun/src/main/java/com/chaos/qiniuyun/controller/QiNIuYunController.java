package com.chaos.qiniuyun.controller;

import com.chaos.qiniuyun.entity.ResultInfo;
import com.chaos.qiniuyun.utils.QiniuCloudUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.UUID;

/**
 * @projectName: pic_up_down
 * @package: com.chaos.qiniuyun.controller
 * @className: QiNIuYunController
 * @author: chaos
 * @description: TODO
 * @date: 2022/11/18 11:28
 * @version: 1.0
 */
@Slf4j
@Controller
public class QiNIuYunController {
    @RequestMapping("/test/")
    @ResponseBody
    public String test(){
        System.out.println(123);
        return "hello world";
    }
    @ResponseBody
    @RequestMapping(value="/uploadImg", method= RequestMethod.GET)
    public ResultInfo uploadImg(String image, HttpServletRequest request) {
        String path = "D:\\All_Pro\\GitHub_backend\\chaos_backend\\qiniuyun\\src\\main\\java\\com\\chaos\\qiniuyun\\controller\\logo1.jpg";
        byte[] bytes = null;
        try {
            bytes =   FileCopyUtils.copyToByteArray(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        ResultInfo result = new ResultInfo();
       /* if (image.isEmpty()) {
            result.setCode(400);
            result.setMsg("文件为空，请重新上传");
            return result;
        }*/

        String imageName = UUID.randomUUID().toString();

        QiniuCloudUtil qiniuUtil = new QiniuCloudUtil();
        try {
            //使用base64方式上传到七牛云
            qiniuUtil.uploadAgain();
            //String url = qiniuUtil.put64image(bytes, imageName);
            result.setCode(200);
            result.setMsg("文件上传成功");
            result.setInfo("123");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
