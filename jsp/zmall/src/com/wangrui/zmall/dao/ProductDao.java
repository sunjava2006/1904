package com.wangrui.zmall.dao;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.wangrui.zmall.entity.Product;
import com.wangrui.zmall.mapper.ProductMapper;

public class ProductDao {

	private MybatisTemplate<Product> temp = new MybatisTemplate<Product>();
	
	
	public  int add(Product p) {
		
		//return this.temp.insert ("com.wangrui.zmall.entity.ProductMapper.add", p);
		return this.temp.insert(ProductMapper.class, p);
		
	}
	
	
	public  Product  findByID(int  id) {
		
			return this.temp.selectOne("com.wangrui.zmall.entity.ProductMapper.findByID", id);
	
	}
	
	
	public  List<Product>  findByPage(int  page, int size) {
		
			Map map = new HashMap();
			map.put("start", (page-1)*size);
			map.put("end", page*size);
			return this.temp.selectList("com.wangrui.zmall.entity.ProductMapper.findAll", map);
		
	}
	
	
	public  int update(Product p) {
	
			return this.temp.update("com.wangrui.zmall.entity.ProductMapper.update", p);
	
	}
	
	public  int delete(int id) {
		
			return this.temp.delete("com.wangrui.zmall.entity.ProductMapper.del", id);
	
	}
	
	
	
	
	public static void main(String[] args) {
		Product p = new Product(null, "lenove g450", "lenovo g450", new BigDecimal("6000"), "̨");
		ProductDao dao = new ProductDao();
		int c = dao.add(p);
		System.out.println(c);
		
//		Product p = dao.findByID(3);
//		System.out.println(p);
////		
//		p.setPrice(new BigDecimal("13000"));
//		System.out.println(dao.update(p));
		
//		List<Product> l = dao.findByPage(1,3);
//		System.out.println(l);
		
//		dao.delete(3);
		
		
	}
	
}
