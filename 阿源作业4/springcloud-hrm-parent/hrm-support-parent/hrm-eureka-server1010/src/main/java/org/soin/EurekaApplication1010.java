package org.soin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
//服务端
public class EurekaApplication1010 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication1010.class);
    }
}
