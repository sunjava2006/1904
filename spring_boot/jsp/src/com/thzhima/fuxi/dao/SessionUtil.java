package com.thzhima.fuxi.dao;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SessionUtil {

	private static SqlSessionFactory factory = null;
	static {
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		Reader reader;
		try {
			reader = Resources.getResourceAsReader("config.xml");
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
