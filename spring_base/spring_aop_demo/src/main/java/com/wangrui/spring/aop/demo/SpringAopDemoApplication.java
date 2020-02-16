package com.wangrui.spring.aop.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.wangrui.spring.aop.demo.service.MyService;

@SpringBootApplication
public class SpringAopDemoApplication {

	
	
	public static void main(String[] args) {
		ConfigurableApplicationContext app = SpringApplication.run(SpringAopDemoApplication.class, args);
		MyService ms = app.getBean(MyService.class);
		System.out.println(ms.getScore(2));
		
		
		
	}

}
