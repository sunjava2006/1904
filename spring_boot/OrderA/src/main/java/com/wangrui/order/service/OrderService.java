package com.wangrui.order.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.HystrixCollapser.Scope;
import com.netflix.hystrix.HystrixCollapserProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.wangrui.order.bean.Product;

@Service
public class OrderService {
	
	@Autowired
	private RestTemplate restTemp;
	
//	@Autowired
//	private DiscoveryClient discoveryClient;
	

	@HystrixCommand(fallbackMethod = "ifError",// 指明降级处理方法
			          commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000"),
			                             @HystrixProperty(name = "circuitBreaker.enabled", value = "true")})
	public Product findById(Integer id) {
         return restTemp.getForObject("http://PRODUCTS-SERVICE/product/{id}", Product.class, id);
	}
	

	public Product ifError(Integer id) {
		return new Product(id,"未和", false,null,null);
	}
	
	//----------------------------------------请求合并--------------------------------------------------
	
	@HystrixCollapser(batchMethod = "findMore",collapserKey = "id",
			          scope = Scope.GLOBAL,
			          collapserProperties = {@HystrixProperty(name="timerDelayInMilliseconds", value="3000"),
			        		                 @HystrixProperty(name="maxRequestsInBatch",value="20"),
			        		                 @HystrixProperty(name="requestCache.enabled",value="true")}) // 可以被合并的方法
	public Future<Product> findOne(Integer id) {
		System.out.println("========================单个请求======================");
		return null;
	}

	@HystrixCommand()
	public List<Product> findMore(List<Integer> ids){
		
		System.out.println("========================请求合并======================"+ids.size()+"->"+ids);

		Product[] array = this.restTemp.getForObject("http://PRODUCTS-SERVICE/product/list/{id}", Product[].class, StringUtils.join(ids, ","));
		List<Product> li = Arrays.asList(array);
		
		for(Product i : array) {
			System.out.println("product[i]:"+i);
		}
		System.out.println("List<Product> :"+li);
		
		return li;
	}
}
