package com.chaos.springbootredis.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;

/**
 * @projectName: pic_up_down
 * @package: com.chaos.springbootredis.config
 * @className: RedisConfig
 * @author: chaos
 * @description: TODO
 * @date: 2022/12/6 11:20
 * @version: 1.0
 */
@Configuration
@EnableCaching
@Slf4j
public class RedisConfig {

    @Value("${spring.redis.cluster.nodes}")
    private String redisNodes;

    @Bean
    public JedisCluster getJedisCluster() {

        String[] redisnodes = redisNodes.split(",");

        Set<HostAndPort> nodes = new HashSet<>();
        for(String node:redisnodes) {
            String[] arr=node.split(":");
            HostAndPort hostAndPort = new HostAndPort(arr[0], Integer.parseInt(arr[1]));

            nodes.add(hostAndPort);
        }
        JedisCluster cluster = new  JedisCluster(nodes);
        return cluster;
    }
}

