package com.wangrui.zmall.mapper;

import org.apache.ibatis.annotations.Insert;

import com.wangrui.zmall.entity.Product;

public interface ProductMapper extends Mapper{

	
	@Insert("insert into products(id, name, description, price, unit) values (seq_products.nextval, #{name},#{desc},#{price},#{unit})")
	public int insert(Product p);
}
