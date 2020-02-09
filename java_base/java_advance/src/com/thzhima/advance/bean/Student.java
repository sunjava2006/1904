package com.thzhima.advance.bean;

public class Student {

	private int ID;
	private String name;
	private String loginName;
	private String passwd;
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public Student() {
		
	}
	public Student(int id, String name, String loginName, String passwd) {
		super();
		ID = id;
		this.name = name;
		this.loginName = loginName;
		this.passwd = passwd;
	}
	@Override
	public String toString() {
		return "Student [ID=" + ID + ", name=" + name + ", loginName=" + loginName + ", passwd=" + passwd + "]";
	}
	
	
}
