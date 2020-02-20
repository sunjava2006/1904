package com.wangrui.news.service;

public class UserService {

	public boolean login(String userName, String pwd) {
		if("admin".equals(userName) && "admin".equals(pwd)) {
			return true;
		}
		else {
			return false;
		}
	}
}
