package com.wangrui.location.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.wangrui.location.entity.Plan;

@SpringBootTest
class PlanServiceTest {

	@Autowired
	private PlanService ps;
	
	@Test
	void testFindByName() {
		List<Plan> list = ps.findByName("1505");
		System.out.println(list);
	}

}
