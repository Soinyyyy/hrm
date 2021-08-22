package org.soin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
//主启动类
@SpringBootApplication
//注册到Eureka客户端
@EnableEurekaClient
public class AuthApplication1050 {
    public static void main(String[] args) {
        SpringApplication.run(AuthApplication1050.class);
    }
}
