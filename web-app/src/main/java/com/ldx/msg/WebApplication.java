package com.ldx.msg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ImportResource;


@SpringBootApplication
@EnableDiscoveryClient
@EnableEurekaClient
//@EnableFeignClients
//@ConditionalOnClass({ VelocityEngine.class, VelocityEngineFactory.class })
//@EnableAsync
@ImportResource({"classpath*:spring-all.xml"})
public class WebApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }
}
