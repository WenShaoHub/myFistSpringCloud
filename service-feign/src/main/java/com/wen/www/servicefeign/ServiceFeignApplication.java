package com.wen.www.servicefeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients           //开启Feign功能
@EnableDiscoveryClient   // 通过@EnableDiscoveryClient向服务中心注册
@EnableEurekaClient   //表明使用服务发现，就是如果选用的注册中心是eureka，那么就推荐@EnableEurekaClient 如果是其他的注册中心，那么推荐使用@EnableDiscoveryClient
public class ServiceFeignApplication {

	public static void main(String[] args) {
		System.out.println("=============走feign这边============");
		SpringApplication.run(ServiceFeignApplication.class, args);
	}
}
