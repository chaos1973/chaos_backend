package com.chaos.minio.config;

import io.minio.MinioClient;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * @projectName: pic_up_down
 * @package: com.chaos.minio.config
 * @className: MinioConfig
 * @author: chaos
 * @description: TODO
 * @date: 2022/11/21 15:29
 * @version: 1.0
 */
@Configuration
@EnableConfigurationProperties(MinioPropertiesConfig.class)
public class MinioConfig {

    @Resource
    private MinioPropertiesConfig minioPropertiesConfig;


    /**
     * 初始化 MinIO 客户端
     */
    @Bean
    public MinioClient minioClient() {
        MinioClient minioClient = MinioClient.builder()
                .endpoint(minioPropertiesConfig.getEndpoint())
                .credentials(minioPropertiesConfig.getAccessKey(), minioPropertiesConfig.getSecretKey())
                .build();
        return minioClient;
    }
}
