package com.wangrui.spring.aop.talk.service;

import org.springframework.stereotype.Service;

import com.wangrui.spring.aop.talk.addon.Monitor;

@Service
public class StudentService {

	// 学生注册的方法
	public String regist(String userName, String pwd) {
		System.out.println("学生"+userName +"注册到系统中............");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "注册成功";
	}
	
	// 学生登录
	@Monitor
	public String login(String userName, String pwd) {
		System.out.println("学生" + userName + "登录系统中.......");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "登录成功";
	}
	
	// 学生查询成绩
	@Monitor
	public Integer findScore(String studentID) {
		System.out.println("学生查询成绩中 .................................");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if("201901".equals(studentID)) {
			return 90;
		}else if("201902".equals(studentID)) {
			return 85;
		}else {
			return 80;
		}
		
	}
	
	
}
