package com.wangrui.spring.aop.demo.bean;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Flyman {
	@DeclareParents(value="com.wangrui.spring.aop.demo.bean.Human", 
			defaultImpl = com.wangrui.spring.aop.demo.bean.Bird.class)
	Flyable flyman;

}
