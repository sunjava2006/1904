package com.wangrui.products.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wangrui.products.dao.ProductDao;
import com.wangrui.products.entity.Product;

@Service
public class ProductService {

	@Autowired
	private ProductDao pdao;
	
	
	/**
	 * 添加一个商品
	 * @param p
	 * @return
	 */
	public Product add(Product p) {
		this.pdao.save(p);
		return p;
	}
	
	/**
	 * 根据ID,查询商品
	 * @param id
	 * @return
	 */
	public Product findByID(Integer id) {
		return this.pdao.findById(id).get();
	}
	
}
