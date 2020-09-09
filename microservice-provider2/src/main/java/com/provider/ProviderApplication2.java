package com.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient //本服务会自动注册到eureka服务中
public class ProviderApplication2 {

    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication2.class, args);
    }
}
