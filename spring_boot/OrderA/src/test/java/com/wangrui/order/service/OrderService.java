package com.wangrui.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.wangrui.order.bean.Product;

@Service
public class OrderService {
	
	@Autowired
	private RestTemplate restTemp;
	
	public Product findById(int id) {
		Product p = null;
		p = this.restTemp.getForObject("http://127.0.0.1:9991/product/"+id, Product.class);
		return p;
	}
}
