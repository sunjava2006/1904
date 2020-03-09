package com.wangrui.products;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ProductsAApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductsAApplication.class, args);
	}

}
