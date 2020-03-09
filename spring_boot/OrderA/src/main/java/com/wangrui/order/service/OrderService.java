package com.wangrui.order.service;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.wangrui.order.bean.Product;

@Service
public class OrderService {
	
	@Autowired
	private RestTemplate restTemp;
	
	@Autowired
	private DiscoveryClient discoveryClient;
	
	public Product findById(int id) {
		Product p = null;
		
		List<ServiceInstance> srvlist = this.discoveryClient.getInstances("PRODUCTS_SERVICE");
		URI uri = srvlist.get(0).getUri(); // 
		System.out.println(uri.toString());
		p = this.restTemp.getForObject(uri.toString()+"/product/"+id, Product.class);
		return p;
	}
}
