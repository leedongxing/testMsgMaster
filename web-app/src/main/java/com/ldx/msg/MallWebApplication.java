package com.ldx.msg;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.ui.velocity.VelocityEngineFactory;


@SpringBootApplication
//@EnableDiscoveryClient
//@EnableEurekaClient
//@EnableFeignClients
//@ConditionalOnClass({ VelocityEngine.class, VelocityEngineFactory.class })
//@EnableAsync
@ImportResource({"classpath*:spring-all.xml"})
public class MallWebApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(MallWebApplication.class, args);
    }
}
