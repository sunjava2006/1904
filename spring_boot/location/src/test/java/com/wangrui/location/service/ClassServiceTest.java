package com.wangrui.location.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.wangrui.location.entity.MyClass;
import com.wangrui.location.entity.Student;

@SpringBootTest
@EnableTransactionManagement
class ClassServiceTest {

	@Autowired
	private ClassService classService;
	
//	@Test
//	void testFindByID() {
//		MyClass myclass = this.classService.findByID(1);
//		System.out.println(myclass.getClassName());
//		for(Student s: myclass.getStudents()) {
//			System.out.println(s.getName());
//		}
//	}

//	@Test
//	void testFindByName() {
//		MyClass myclass = this.classService.findByName("1502");
//		System.out.println(myclass.getClassName());
//		for(Student s: myclass.getStudents()) {
//			System.out.println(s.getName());
//		}
//	}
	
	@Test
	void testDeleteByName() {
		this.classService.deleteByName("1502");
	}
}
