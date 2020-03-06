package com.wangrui.products.service;

import java.math.BigDecimal;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.wangrui.products.entity.Product;

@SpringBootTest
@TestMethodOrder(value = OrderAnnotation.class)
class ProductServiceTest {

	@Autowired
	private ProductService ps;
	
	@Test
	@Order(1)
	void testAdd() {
		ps.add(new Product(null, "铅笔", true, new BigDecimal("0.5"), "中华铅笔"));
	}

	@Test
	@Order(10)
	void testFindByID() {
		Product p = ps.findByID(1);
		System.out.println(p);
	}

}
