package com.wangrui.location.entity;

import java.io.Serializable;

public class MyClass implements Serializable {

	private Integer ID;
	private String className;

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

	public MyClass(Integer iD, String className) {
		super();
		ID = iD;
		this.className = className;
	}

	public MyClass() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "MyClass [ID=" + ID + ", className=" + className + "]";
	}

}
