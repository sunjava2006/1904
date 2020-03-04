package com.wangrui.zmall.dao;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SessionUtil {
	
	private static SqlSessionFactory factory;
	
	static {
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		Reader reader = null;
		try {
			reader = Resources.getResourceAsReader("mybatis-config.xml");
			factory = builder.build(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	

	public static SqlSession getSession() {
		SqlSession session = null;
		
		session = factory.openSession();
		
		return session;
	}
}
