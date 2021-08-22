package org.soin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients("org.soin.feign")
public class CourseApplication1070 {
    public static void main(String[] args) {
        SpringApplication.run(CourseApplication1070.class);
    }
}
