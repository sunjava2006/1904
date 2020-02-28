package com.wangrui.location.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.wangrui.location.entity.News;

@SpringBootTest
class NewsServiceTest {
	
	@Autowired
	private NewsService ns;

//	@Test
//	void testInsert() {
//		News news = new News(null, "Xie");
//		this.ns.insert(news);
//	}

//	@Test
//	void testFindByName() {
//		List<News> n = this.ns.findByName("Wang");
//		System.out.println(n);
//	}
	
//	@Test
//	void testFindByID() {
//		News n = this.ns.findByID(1);
//		System.out.println(n);
//	}
	
//	@Test
//	void testUpdate() {
//		News news = this.ns.findByID(1);
//		news.setName("LiBai");
//		this.ns.update(news);
//	}
	
	@Test
	void testDelete() {
		this.ns.delete(1);
	}
}
