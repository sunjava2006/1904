package com.wangrui.location.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.wangrui.location.entity.MyClass;
@SpringBootTest()
class ClassMapperTest {

	@Autowired
	private ClassMapper cm;
	
	@Test
	void testFindByID() {
		MyClass cls = this.cm.findByID(1);
		System.out.println(cls.getClassName());
		cls = this.cm.findByID(1);
		System.out.println(cls.getClassName());
	}

}
