package com.thzhima.fuxi.service;

import com.thzhima.fuxi.bean.Student;
import com.thzhima.fuxi.dao.StudentDAO;

public class UserService {

	private StudentDAO sdao = new StudentDAO();
	
	public void regist(String userName, String pwd) {
		System.out.println("完成用户注册，调用DAO将数据写入数据库中。");
		this.sdao.add(new Student(null,null,userName, null, pwd, null));
	}
	
	
	public Student login(String userName, String pwd) {
		System.out.println("调用DAO，从数据库中查询用户信息");
		return this.sdao.select(userName, pwd);
	}
}
