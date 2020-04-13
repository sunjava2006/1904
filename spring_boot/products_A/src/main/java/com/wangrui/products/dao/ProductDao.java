package com.wangrui.products.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wangrui.products.entity.Product;

@Repository  // 仓库，数据存储类型的注解。
public interface ProductDao extends JpaRepository<Product, Integer>{
	

}
