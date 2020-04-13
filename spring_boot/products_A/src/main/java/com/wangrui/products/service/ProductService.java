package com.wangrui.products.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wangrui.products.dao.ProductDao;
import com.wangrui.products.entity.Product;

/**
 * @author wangrui
 *
 */
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
	
	
	/**
	 * 根据多个Id，查询商品
	 * @param ids
	 * @return
	 */
	public List<Product> findByIds(Iterable<Integer> ids){
		return this.pdao.findAllById(ids);
	}
}
