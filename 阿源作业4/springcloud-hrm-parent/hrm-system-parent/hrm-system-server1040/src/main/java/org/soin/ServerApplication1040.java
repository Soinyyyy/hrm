package org.soin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
//注册到Eureka
@EnableFeignClients("org.soin.feign")
public class ServerApplication1040 {
    public static void main(String[] args) {
        SpringApplication.run(ServerApplication1040.class);
    }
}
