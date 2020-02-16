package com.wangrui.spring.aop.talk.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StudentServiceTest {
    
	@Autowired
	StudentService ss;
	
	@Test
	void testRegist() {
		System.out.println("类型："+ss.getClass().getName());
		
		ss.regist("wang", "123456");
	}

	@Test
	void testLogin() {
		ss.login("wang", "123456");
	}

	@Test
	void testFindScore() {
		System.out.println(ss.findScore("201902"));
	}

}
