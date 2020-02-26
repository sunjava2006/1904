package com.wangrui.news;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfigurer implements WebMvcConfigurer {

//	@Override
//	public void addCorsMappings(CorsRegistry registry) {
//		registry.addMapping("/news/**").allowedHeaders("*").allowedMethods("*").allowedOrigins("*").maxAge(18);
//	}

}
