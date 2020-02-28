package com.wangrui.location;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;

// SpringBoot启动器
@SpringBootApplication
@EnableTransactionManagement // 启用声明式事务管理
@EnableCaching  // 启用缓存
public class LocationApplication {

	public static void main(String[] args) {
		SpringApplication.run(LocationApplication.class, args);
	}
}
