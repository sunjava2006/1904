package com.wangrui.location.mapper;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.wangrui.location.entity.Plan;
@SpringBootTest
class PlanMapperTest {

	@Autowired
	private PlanMapper pm;
	
	@Test
	void testDelete() {
		List<Plan> list = pm.findByClassID(4);
		System.out.println(list.size());
		
		System.out.println("---------------del-------------");
		pm.delete(1);
		
		
		list = pm.findByClassID(4);
		System.out.println(list.size());
		
	}

}
