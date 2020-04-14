package com.thzhima.fuxi.service;

import java.util.List;

import com.thzhima.fuxi.bean.Student;
import com.thzhima.fuxi.dao.StudentDAO;

public class UserService {

	private StudentDAO sdao = new StudentDAO();
	
	public void regist(String userName, String pwd) {
		System.out.println("����û�ע�ᣬ����DAO������д�����ݿ��С�");
		this.sdao.add(new Student(null,null,userName, null, pwd, null));
	}
	
	
	public Student login(String userName, String pwd) {
		System.out.println("����DAO�������ݿ��в�ѯ�û���Ϣ");
		return this.sdao.select(userName, pwd);
	}
	
	public List<Student> list(int page, int len){
		return this.sdao.list(page, len);
	}
	
	public long totalCount() {
		return this.sdao.count();
	}
	
	public long totalPage(double len) {
		return (long) Math.ceil(this.totalCount()/len);
	}
}
