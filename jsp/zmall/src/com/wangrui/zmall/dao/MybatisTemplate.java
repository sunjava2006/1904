package com.wangrui.zmall.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.wangrui.zmall.mapper.Mapper;


public class MybatisTemplate<T> {
	
	public  int insert(String method, T p) {
		int count = -1;
		SqlSession session = null;
		try {
			session = SessionUtil.getSession();
			count = session.insert(method, p);
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
	
	
	public  T  selectOne(String mehtod, Object arg) {
		Object o = null;
		SqlSession session = null;
		try {
			session = SessionUtil.getSession();
			o = session.selectOne("com.wangrui.zmall.entity.ProductMapper.findByID", arg);
			session.commit();
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		} finally {
			if(null != session) {
				session.close();
			}
		}
		
		return (T)o;
	}
	
	
	public  List<T>  selectList(String method,Map m) {
		Object o = null;
		SqlSession session = null;
		try {
			session = SessionUtil.getSession();
			
			o = session.selectList(method, m);
			session.commit();
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		} finally {
			if(null != session) {
				session.close();
			}
		}
		
		return (List<T>)o;
	}
	
	
	public  int update(String method,T arg) {
		int count = -1;
		SqlSession session = null;
		try {
			session = SessionUtil.getSession();
			count = session.update(method, arg);
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
	
	public  int delete(String method, Object arg) {
		int count = -1;
		SqlSession session = null;
		try {
			session = SessionUtil.getSession();
			count = session.delete(method, arg);
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
	 
	// 用注解实现的。
	public int insert(Class<? extends Mapper> mapper, Object arg) {
		int count = -1;
		SqlSession session = null;
		try {
			session = SessionUtil.getSession();
			count = session.getMapper(mapper).insert(arg);
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

}
