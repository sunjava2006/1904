package com.wangrui.location.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.wangrui.location.entity.Student;

@SpringBootTest
class StudentServiceTest {
	
	@Autowired
	StudentService ss;

	@Test
	void testLogin() {
		Student stu = ss.login("150201", "123456");
		System.out.println(stu);
	}

}
