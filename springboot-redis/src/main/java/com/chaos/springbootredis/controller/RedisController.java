package com.chaos.springbootredis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.JedisCluster;

/**
 * @projectName: pic_up_down
 * @package: com.chaos.springbootredis.controller
 * @className: RedisController
 * @author: chaos
 * @description: TODO
 * @date: 2022/12/6 14:39
 * @version: 1.0
 */

@RestController
public class RedisController {
    @Autowired
    JedisCluster jedisCluster;
    @RequestMapping("/getValue")
    public String getValue(){
        jedisCluster.setnx("k3","v3");
        return jedisCluster.get("k3");
    }
}
