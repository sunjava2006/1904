package com.thzhima.fuxi.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.thzhima.fuxi.bean.Student;
import com.thzhima.fuxi.mapper.StudentMapper;

public class StudentDAO {

	public void add(Student s) {
		
		SqlSession session = null;
		try {
			session = SessionUtil.getSession();
			StudentMapper mp = session.getMapper(StudentMapper.class);
			mp.add(s);
			session.commit();
		} catch (Exception e) {
			session.rollback();
			throw e;
		} finally {
			if(null != session) {
				session.close();
			}
		}
	}
	
	public Student select(String studentName, String pwd) {
		Student s = null;
		SqlSession session = null;
		try {
			session = SessionUtil.getSession();
			StudentMapper mp = session.getMapper(StudentMapper.class);
			s = mp.find(studentName, pwd);
			
			session.commit();
		} catch (Exception e) {
			session.rollback();
			throw e;
		} finally {
			if(null != session) {
				session.close();
			}
		}
		return s;
	}
	
	public List<Student> list(int page, int len){
		List<Student> list = null;
		
		SqlSession session = null;
		try {
			session = SessionUtil.getSession();
			StudentMapper sm = session.getMapper(StudentMapper.class);
			list = sm.list((page-1)*len, len);
			session.commit();
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		} finally {
			if(null != session) {
				session.close();
			}
		}
		
		return list;
	}
	
	
	public long count(){
		long c = 0;
		
		SqlSession session = null;
		try {
			session = SessionUtil.getSession();
			StudentMapper sm = session.getMapper(StudentMapper.class);
			c = sm.totalCount();
			session.commit();
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		} finally {
			if(null != session) {
				session.close();
			}
		}
		
		return c;
	}
	
	
	public static void main(String[] args) {
		StudentDAO sd = new StudentDAO();
//		Student s = new Student(null, 20050102, "ажиа", "дп", "111", 200501);
//		sd.add(s);
		
//		System.out.println(sd.select("ажиа", "111"));
		
		System.out.println(sd.list(2, 2));
		System.out.println(sd.count());
	}
}
