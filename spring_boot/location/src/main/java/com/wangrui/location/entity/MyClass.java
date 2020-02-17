package com.wangrui.location.entity;

import java.io.Serializable;
import java.util.List;

public class MyClass implements Serializable {

	private Integer ID;
	private String className;
	private List<Student> students; // 一个班级中多个学生（数据库中1对多的关联关系）。包含（组合）关系。
	
	public MyClass(Integer iD, String className, List<Student> students) {
		super();
		ID = iD;
		this.className = className;
		this.students = students;
	}
	
	
	public MyClass() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}


	@Override
	public String toString() {
		return "MyClass [ID=" + ID + ", className=" + className + ", students=" + students + "]";
	}

	

}
