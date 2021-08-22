package org.soin.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties("file.alicloud")
public class AlicloudOSSProperties {
    //这是封装的连接OSS的4个属性
    private String bucketName;
    private String accessKey;
    private String secretKey;
    private String endpoint;
}
