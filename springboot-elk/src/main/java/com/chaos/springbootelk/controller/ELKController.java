package com.chaos.springbootelk.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @projectName: pic_up_down
 * @package: com.chaos.springbootelk.controller
 * @className: ELKController
 * @author: chaos
 * @description: TODO
 * @date: 2022/12/7 13:54
 * @version: 1.0
 */
@Slf4j
@RestController
public class ELKController {
    @GetMapping("/elk")
    public String index() {
        String message = "logback ELK成功接入了，时间：" + new Date();
        log.info(message);
        return "it is wonderful";
    }
}
