package com.wangrui.location.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.wangrui.location.entity.MyClass;
import com.wangrui.location.entity.Student;

@SpringBootTest
@EnableTransactionManagement
class StudentServiceTest {
	
	@Autowired
	StudentService ss;

	@Test
	void testLogin() {
		Student stu = ss.login("150201", "123456");
		System.out.println(stu.getName());
//		stu = ss.login("150201", "123456");
//		System.out.println(stu.getName());
	}
//	
//	@Test
//	void testAdd(){
//		Student stu = new Student(2,"150202","XiXi","123","男",new MyClass(1,"1502", null));
//		int count = ss.add(stu);
//		System.out.println(count);
//	}
	
//	@Test
//	void testUpdate() {
//		Student stu = new Student(2, "150202", "江小红", "654321", "女", 1);
//		System.out.println(ss.updateAllProperties(stu));
//	}
	
//	@Test
//	void testDelete() {
//		this.ss.delete("150202");
//	}
//	@Test
//	void testUpdateByExample() {
//		Student stu = new Student(null,"150202", null,"abc", "女", null);
//		this.ss.updateByExample(stu);
//	}

}
