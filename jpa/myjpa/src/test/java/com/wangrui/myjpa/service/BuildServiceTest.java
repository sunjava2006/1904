package com.wangrui.myjpa.service;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.wangrui.myjpa.entity.Build;

@SpringBootTest
class BuildServiceTest {

	@Autowired
	private BuildService bs;
	
//	@Test
	void testSave() {
		Build build = new Build(null, "勤学楼", 123.45678, 23.12345);
		this.bs.save(build);
	}

//	@Test
	void testSaveAll() {
		Build build = new Build(null, "电信楼", 123.45678, 23.12345);
		Build build2 = new Build(null, "行政楼", 123.45678, 23.12345);
		Build build3 = new Build(null, "雷丁楼", 123.45678, 23.12345);
		Build build4 = new Build(null, "1号楼", 123.45678, 23.12345);
		Build build5 = new Build(null, "2号楼", 123.45678, 23.12345);
		Build build6 = new Build(null, "3号楼", 123.45678, 23.12345);
		Build build7 = new Build(null, "4号楼", 123.45678, 23.12345);
		Build build8 = new Build(null, "5号楼", 123.45678, 23.12345);
		this.bs.saveAll(Arrays.asList(build, build2, build3, build4, build5, build6, build7, build8));
	}

//	@Test
	void testFindByID() {
		Build b = this.bs.findByID(1);
		System.out.println(b);
	}
	
//	@Test
	void testFindByName() {
		Build b = this.bs.findByName("明德楼");
		System.out.println(b);
		
	}
	

	@Test
	void testListByPage() {
		Page<Build> list = this.bs.listByPage(1, 3);
		System.out.println(list.getContent());
		System.out.println("=========================================");
		list = this.bs.listByPage(0, 3, false, "ID");
		System.out.println(list.getContent());
		list = this.bs.listByPage(1, 3, false, "ID");
		System.out.println(list.getContent());
		list = this.bs.listByPage(2, 3, false, "ID");
		System.out.println(list.getContent());
	}
	
	
}
