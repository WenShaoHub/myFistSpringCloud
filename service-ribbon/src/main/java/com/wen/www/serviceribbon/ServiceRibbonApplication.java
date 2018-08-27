package com.wen.www.serviceribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient  // 通过@EnableDiscoveryClient向服务中心注册
@EnableEurekaClient
@SpringBootApplication
@EnableHystrix   //开启断路器
public class ServiceRibbonApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceRibbonApplication.class, args);
	}

	@Bean // @Bean注解用于告诉方法，产生一个Bean对象 注入到spring容器之中，默认bean的名称就是其方法名。但是也可以指定名称：@Bean(name="BeanTest")
	@LoadBalanced // @LoadBalanced注解表明这个restRemplate开启负载均衡的功能
	RestTemplate restTemplate(){
		System.out.println("走ribbon这边");
		return new RestTemplate();
	}

}
