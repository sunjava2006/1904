package com.wangrui.spring.aop.talk;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.wangrui.spring.aop.talk.service.StudentService;

@SpringBootTest
class TalkSpringAopApplicationTests {

	@Autowired
	StudentService ss;
	
	@Test
	void contextLoads() {
		
		Integer score = ss.findScore("201901");
		System.out.println(score);
	}

}
