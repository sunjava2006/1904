package com.wangrui.zmall.service;

import java.util.List;

import com.wangrui.zmall.dao.ProductDao;
import com.wangrui.zmall.entity.Product;

/**
 * 商品服务类，提供对商业的添加、查询、修改、删除的功能。
 * @author wangrui
 * @since 2020-3-5
 * @version 1.0
 * @see ProductDAO 本类中使用了相应的DAO类。
 */
public class ProductService {

	private ProductDao pdao = new ProductDao();
	
	/**
	 * 添加一个商品
	 * @param p Product对象
	 * @return 添加成功返回true，否则返回false。
	 */
	public boolean add(Product p) {
		return this.pdao.add(p)==1 ? true : false;
	}
	
	/**
	 * 分布查询，返回商品列表
	 * @param page 第几页
	 * @param size 每页最多记录数
	 * @return List<Product>
	 */
	public List<Product> listByPage(int page, int size){
		return this.pdao.findByPage(page, size);
	}
	
	
}
