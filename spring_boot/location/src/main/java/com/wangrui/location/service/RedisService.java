package com.wangrui.location.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisService {

//	@Autowired
//	private StringRedisTemplate stringTemp;
//	
//	public void save(String key, String value) {
//		this.stringTemp.opsForValue().set(key, value);
//	}
//	
//	public String getString(String key) {
//		String v = null;
//		v = this.stringTemp.opsForValue().get(key);
//		return v;
//	}
//	
//	public void save() {
////		this.stringTemp.opsForHash().put("user2", "name", "Xie");
//		HashMap m = new HashMap();
//		m.put("name", "Huang");
//		m.put("gender", "male");
//		m.put("age", "20");
//		this.stringTemp.opsForHash().putAll("user3", m);
//	}
//	
//	public void get() {
//		List list =  Arrays.asList("name","age","gender");
//		List values = this.stringTemp.opsForHash().multiGet("user3",list);
//		values.forEach((i)->System.out.println(i));
//	}
}
