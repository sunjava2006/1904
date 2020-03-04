package com.wangrui.location.config;


import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.TextMessage;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
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

//	@Override
//	public void addInterceptors(InterceptorRegistry registry) {
//		InterceptorRegistration  ir = 	registry.addInterceptor(new LoginInterseptor());
//		ir.addPathPatterns("/*");
//	}
	
	@Bean(name = "1904")
	public Queue createQueue() {
		return new ActiveMQQueue("1904");
	}

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		// TODO Auto-generated method stub
		registry.addMapping("/**").allowedOrigins("*").allowedHeaders("*").allowedMethods("*").maxAge(1800);
	}

//	@JmsListener(destination = "1904")
//	public void getMsg(Message msg) throws JMSException {
//		TextMessage message = (TextMessage) msg;
//		String txt = message.getText();
//		System.out.println("---------------------收到的消息："+txt);
//		
//	}
//	

	
}
