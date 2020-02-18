package com.wangrui.location.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wangrui.location.entity.Student;
import com.wangrui.location.service.StudentService;

@Controller
public class UserController {

	@Autowired
	private StudentService StudentService;
	
	// 接受用户的登录请求
	@RequestMapping(path = "/login") // 将指定的URL映射到这个方法上。	
	@ResponseBody // 表示http响应返回该方法返回的内容。
	public String login(String studentID, String passwd, HttpSession session) {
		Student s = this.StudentService.login(studentID, passwd);
		if(null != s) {
			session.setAttribute("studentInfo", s);
			return "登录成功";
		}else {
			return "登录失败";
		}
	}
	
	
}
