package com.chaos.qiniuyun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @projectName: pic_up_down
 * @package: com.chaos.qiniuyun.controller
 * @className: QiNIuYunController
 * @author: chaos
 * @description: TODO
 * @date: 2022/11/18 11:28
 * @version: 1.0
 */
@Controller
public class QiNIuYunController {
    @RequestMapping("/test/")
    @ResponseBody
    public String test(){
        System.out.println(123);
        return "hello world";
    }
}
