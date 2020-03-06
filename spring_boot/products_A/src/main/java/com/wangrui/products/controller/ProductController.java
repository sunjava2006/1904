package com.wangrui.products.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wangrui.products.entity.Product;
import com.wangrui.products.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService ps;
	
	@GetMapping(path = "/{id}") //url:/product/1
	public Product findByID(@PathVariable("id") int id) {
		return this.ps.findByID(id);
	}
	
	@PostMapping()
	public String add(Product product) {
		String result =  "ok";
		try {
			this.ps.add(product);
		} catch (Exception e) {
			result = "fald";
		}

		return result;
	}
	
	
}




/**
 * http的请求方法 method，与这4种操作相对应
 * 查询：get => /product/1/10       /product/1   /product/page/1/size/10
 * 删除：delete = > /product/1 删除ID是1
 * 修改：put => /product/1/v1/v2/
 * 添加：post => /product
 */
