package com.thzhima.fuxi.dao;

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
	
	public static void main(String[] args) {
		StudentDAO sd = new StudentDAO();
//		Student s = new Student(null, 20050102, "ажиа", "дп", "111", 200501);
//		sd.add(s);
		
		System.out.println(sd.select("ажиа", "111"));
	}
}
