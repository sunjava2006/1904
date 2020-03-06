package com.wangrui.order.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OrderServiceTest {

	@Autowired
	private OrderService os;
	
	@Test
	void testFindById() {
		System.out.println(os.findById(1));
	}

}
