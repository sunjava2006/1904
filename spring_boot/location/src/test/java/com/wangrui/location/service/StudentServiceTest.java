package com.wangrui.location.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.wangrui.location.entity.Student;

@SpringBootTest
class StudentServiceTest {
	
	@Autowired
	StudentService ss;

//	@Test
//	void testLogin() {
//		Student stu = ss.login("150201", "123456");
//		System.out.println(stu);
//	}
//	
//	@Test
//	void testAdd(){
//		Student stu = new Student(null, "150202", "赵明", "123456", "男", 1);
//		int count = ss.add(stu);
//		System.out.println(count);
//	}
	
//	@Test
//	void testUpdate() {
//		Student stu = new Student(2, "150202", "江小红", "654321", "女", 1);
//		System.out.println(ss.update(stu));
//	}
	
	@Test
	void testDelete() {
		this.ss.delete("150202");
	}

}
