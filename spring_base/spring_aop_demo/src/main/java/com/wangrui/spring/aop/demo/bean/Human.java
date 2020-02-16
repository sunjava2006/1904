package com.wangrui.spring.aop.demo.bean;

import org.springframework.stereotype.Component;

@Component
public class Human {

	public void work() {
		System.out.println("工作中...............");
	}
}
