package com.wangrui.location.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RedisServiceTest {

	@Autowired
	private RedisService rs;
	
//	@Test
//	void testSave() {
//		rs.save("className", "1904");
//	}
	
//	@Test
//	void testGetString() {
//		String v = rs.getString("className");
//		System.out.println(v);
//		
//	}
	
//	@Test
//	void testSave() {
//		rs.save();
//	}
	
	@Test
	void testGet() {
		rs.get();
	}

}
