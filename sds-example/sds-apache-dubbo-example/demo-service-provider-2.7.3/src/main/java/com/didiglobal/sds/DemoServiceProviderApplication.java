package com.didiglobal.sds;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
public class DemoServiceProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoServiceProviderApplication.class, args);
    }

}
