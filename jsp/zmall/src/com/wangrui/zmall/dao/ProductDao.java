package com.wangrui.zmall.dao;

import java.math.BigDecimal;

import org.apache.ibatis.session.SqlSession;

import com.wangrui.zmall.entity.Product;

public class ProductDao {

	public static int add(Product p) {
		int count = -1;
		SqlSession session = null;
		try {
			session = SessionUtil.getSession();
			count = session.insert("com.wangrui.zmall.entity.ProductMapper.add", p);
			session.commit();
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		} finally {
			if(null != session) {
				session.close();
			}
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		Product p = new Product(null, "ROG-Z390-strix", "ASUS Mainboard", new BigDecimal("1500"), "Ƭ");
		int c = add(p);
		System.out.println(c);
	}
	
}
