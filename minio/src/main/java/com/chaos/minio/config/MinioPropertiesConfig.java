package com.chaos.minio.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @projectName: pic_up_down
 * @package: com.chaos.minio.config
 * @className: MinioPropertiesConfig
 * @author: chaos
 * @description: TODO
 * @date: 2022/11/21 15:28
 * @version: 1.0
 */
@Data
@Component
@ConfigurationProperties(prefix = "minio")
public class MinioPropertiesConfig {

    /**
     * 端点
     */
    private String endpoint;
    /**
     * 用户名
     */
    private String accessKey;
    /**
     * 密码
     */
    private String secretKey;

    /**
     * 桶名称
     */
    private String bucketName;
}