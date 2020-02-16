package com.wangrui.spring.aop.demo.service;



import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.wangrui.spring.aop.demo.bean.Flyable;
import com.wangrui.spring.aop.demo.bean.Human;

@SpringBootTest
class MyServiceTest {

	@Autowired
	MyService ms ;
	
	@Autowired
	Human human;

	@Test
	void testGetValue() {
//		System.out.println("@@@@@@@@@@@@@@@@@@@@@@:"+ms.getScore(3));
		human.work();
		((Flyable)human).fly();
		
	}

}
