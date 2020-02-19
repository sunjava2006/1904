package com.wangrui.location.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.wangrui.location.entity.Student;
import com.wangrui.location.service.StudentService;

@Controller
public class UserController {

	@Autowired
	private StudentService StudentService;
	
	// 接受用户的登录请求
	@RequestMapping(path = "/login") // 将指定的URL映射到这个方法上。	
	@ResponseBody // 表示http响应返回该方法返回的内容。
	public String login(@RequestParam(name="studentID", required=true)String studentid, 
			            @RequestParam(name="passwd")String password, 
			            HttpSession session) {
		Student s = this.StudentService.login(studentid, password);
		if(null != s) {
			session.setAttribute("userInfo", s);
			return "登录成功";
		}else {
			return "登录失败";
		}
	}
	
	@PostMapping("/adminLogin")// PostMapping == RequestMapping(method=RequestMethod.POST)
	public ModelAndView admainLogin(String loginName, String pwd, boolean auto, 
			                        ModelAndView mv,HttpSession session, HttpServletResponse response) {
		
		if("admin".equals(loginName) && "admin".equals(pwd)) {
			session.setAttribute("userInfo", loginName);
			
			mv.setViewName("redirect:/index.html");
			if(auto) {
				// 创建Cookie
				Cookie c1 = new Cookie("loginName", loginName);
				c1.setMaxAge(10*24*60*60); // 设置最大有效时间，单位是秒。
				Cookie c2 = new Cookie("pwd", pwd);
				c2.setMaxAge(10*24*60*60);
				
				// cookie放入response。
				response.addCookie(c1);
				response.addCookie(c2);
			}
		}
		else {
			mv.setViewName("loginpage");
			mv.addObject("msg", "用户名和密码都是admin。");
		}
		return mv;
	}
	
}
