package com.wangrui.location.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.wangrui.location.interseptor.LoginInterseptor;

@Configuration
public class MyMvcConfigurer implements WebMvcConfigurer {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("class_manage").setViewName("class_manage");
		registry.addViewController("/").setViewName("loginpage");// 改变首页
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		InterceptorRegistration  ir = 	registry.addInterceptor(new LoginInterseptor());
		ir.addPathPatterns("/*");
	}
	
	

}
