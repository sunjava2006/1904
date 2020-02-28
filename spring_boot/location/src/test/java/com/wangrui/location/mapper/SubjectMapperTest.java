package com.wangrui.location.mapper;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.wangrui.location.entity.Subject;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class SubjectMapperTest {
	
	@Autowired
	private SubjectMapper sm;
	

//	@Test
//	@Order(1)
//	void testList() {
//		List<Subject> list = this.sm.list();
//		System.out.println(list);
//		list = this.sm.list();
//		System.out.println(list);
//	}

//	@Test
//	@Order(2)
//	void testFindByID() {
//		Subject s = this.sm.findByID(1);
//		System.out.println(s);
//		s = this.sm.findByID(1);
//		System.out.println(s);
//		System.out.println("--------------update -----------");
//		s.setSubjectName("C--语言程序设计");
//		this.sm.update(s);
//		
//		s = this.sm.findByID(1);
//		System.out.println(s);
//		s = this.sm.findByID(1);
//		System.out.println(s);
//		
//		
//		
//	}
	
	@Test
	@Order(2)
	void testDelete() {
		Subject s = this.sm.findByID(1);
		System.out.println(s);
		s = this.sm.findByID(1);
		System.out.println(s);
		System.out.println("--------------delete -----------");
		
		this.sm.delete(1);
		
		s = this.sm.findByID(1);
		System.out.println(s);
		s = this.sm.findByID(1);
		System.out.println(s);
		
		
		
	}
	

}
