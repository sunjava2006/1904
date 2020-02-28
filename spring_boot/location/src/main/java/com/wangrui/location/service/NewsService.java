package com.wangrui.location.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.wangrui.location.entity.News;
import com.wangrui.location.mapper.NewsMapper;

@Service
@CacheConfig(cacheNames = "c4")
public class NewsService {

	@Autowired
	private NewsMapper nm;
	
//	@Cacheable(key = "#news.name")
	public News insert(News news) {
		this.nm.insert(news);
		return news;
	}
	
	@Cacheable(key="#id")
	public News findByID(int id) {
		return this.nm.findByID(id);
	}
	
	@Cacheable(key="#name")
	public List<News> findByName(String name) {
		return this.nm.findByName(name);
	}
	
	@CachePut(key = "#news.ID") // 更新缓存
	public News update(News news) {
		this.nm.update(news);
		return news;
	}
	
	@CacheEvict(key = "#id")
	public void delete(int id) {
		this.nm.delete(id);
	}
}
