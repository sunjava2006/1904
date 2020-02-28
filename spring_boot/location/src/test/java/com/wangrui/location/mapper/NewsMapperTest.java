package com.wangrui.location.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.wangrui.location.entity.News;

@SpringBootTest
class NewsMapperTest {
	
	@Autowired
	private NewsMapper nm;

	@Test
	void testInsert() {
		News news = new News(null, "Wang");
		int count = this.nm.insert(news);
		assertEquals(1, count);	
	}

}
