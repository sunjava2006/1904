package com.wangrui.regist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class RegistCenterAApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegistCenterAApplication.class, args);
	}

}
