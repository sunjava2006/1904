package com.wangrui.location.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	@GetMapping("/autoLogin")// @RequestMapping(path="/autoLogin",method = RequestMethod.GET)
	public String autoLogin(@CookieValue("loginName")  String loginName,
			                @CookieValue("pwd") String passwd,
			                Model m,
			                HttpSession session) {
		String viewName = "redirect:/index.html";
		
		if("admin".equals(loginName) && "admin".equals(passwd)) {
			session.setAttribute("userInfo", loginName);
			
		}else {
			viewName = "redirect:/loginpage";
			
		}
		
		return viewName;
	}
	
	@RequestMapping("logout")
	public String logout(HttpSession session, HttpServletResponse response) {
		session.removeAttribute("userInfo"); // 删除Session中的用户信息
		session.invalidate(); // 直接让Session失效。删除了Session所有的数据。
		
		//覆盖自动登录的Cookie数据
		Cookie c1 = new Cookie("loginName", null);
		c1.setMaxAge(0); // 让loginName这个Cookie失效
		Cookie c2 = new Cookie("pwd", null);
		c2.setMaxAge(0); // 让pwd这个Cookie失效
		
		response.addCookie(c1);
		response.addCookie(c2);
		
		return "redirect:/";
	}
	
}
