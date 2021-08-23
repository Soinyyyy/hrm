package org.soin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
//排除数据库
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableEurekaClient
//注册到Eureka中心
public class ElasticSearchApplication1080 {
    public static void main(String[] args) {
        SpringApplication.run(ElasticSearchApplication1080.class);
    }
}
