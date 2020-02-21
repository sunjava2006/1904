package com.wangrui.location.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.wangrui.location.entity.MyClass;

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
	
//	@Test
//	void testDeleteByName() {
//		this.classService.deleteByName("1502");
//	}
	@Test
	void testList() {
		List<MyClass> list = this.classService.list(2, 2);
		
		list.forEach((i)->System.out.println(i.getClassName()));
	}
}
