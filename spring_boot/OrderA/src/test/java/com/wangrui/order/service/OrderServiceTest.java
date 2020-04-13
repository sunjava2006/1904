package com.wangrui.order.service;

import java.util.Arrays;
import java.util.List;

//import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OrderServiceTest {

	@Autowired
	private OrderService os;
	
//	@Test
//	void testFindById() {
//		System.out.println(os.findById(1));
//	}
	
//	@Test
	void testFindMore() {
		List ids = Arrays.asList(1,4,5);
//		List li = this.os.findMore(ids);
//		System.out.println("==============================================###############################################");
//		System.out.println(li);
//		System.out.println("==============================================###############################################");
	}

}
