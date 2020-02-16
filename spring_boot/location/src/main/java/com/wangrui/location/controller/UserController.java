package com.wangrui.location.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

	// 接受用户的登录请求
	@RequestMapping(path = "/login") // 将指定的URL映射到这个方法上。	
	@ResponseBody // 表示http响应返回该方法返回的内容。
	public String login() {
		return "登录成功";
	}
}
