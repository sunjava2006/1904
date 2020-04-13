package com.wangrui.io;

import java.io.Serializable;

public class People implements Serializable{

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "People [name=" + name + "]";
	}
	
}
