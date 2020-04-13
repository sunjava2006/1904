package com.wangrui.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableCircuitBreaker
@SpringBootApplication
@ServletComponentScan
@EnableEurekaClient
public class OrderAApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderAApplication.class, args);
	}

}
