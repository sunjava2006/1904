package com.wangrui.myjpa.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.wangrui.myjpa.entity.Classroom;

@SpringBootTest
class ClassroomServiceTest {

	@Autowired
	private ClassroomService cs;
	
	@Test
	void testFindByBuildName() {
		List<Classroom> list = this.cs.findByBuildName("明德楼");
		System.out.println(list);
	}

	@Test
	void testFindByClassroomName() {
		Classroom room = this.cs.findByClassroomName("明德楼302");
		System.out.println(room);
	}

}
