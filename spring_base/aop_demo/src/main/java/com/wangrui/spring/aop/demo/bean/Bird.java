package com.wangrui.spring.aop.demo.bean;

import org.springframework.stereotype.Component;

//@Component
public class Bird implements Flyable {

	@Override
	public void fly() {
		System.out.println("fly---------------------");
	}

}
