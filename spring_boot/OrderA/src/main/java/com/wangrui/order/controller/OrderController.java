package com.wangrui.order.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import com.wangrui.order.bean.Product;
import com.wangrui.order.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	
	
	
	@Autowired
	private OrderService os;

	
	@GetMapping("/{id}")
	public Product getbyid(@PathVariable Integer id) throws InterruptedException, ExecutionException {
	   return this.os.findById(id);
	   
	}
	
	
	@GetMapping("/id/{id}")
	public Product getbyID(@PathVariable Integer id) throws InterruptedException, ExecutionException {

		HystrixRequestContext ctx = HystrixRequestContext.initializeContext();
	    
		Future<Product> f = this.os.findOne(id);
		
		Product p = f.get();
		return p;
	   
	}
}
