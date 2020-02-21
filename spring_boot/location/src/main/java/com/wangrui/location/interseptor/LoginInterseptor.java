package com.wangrui.location.interseptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.mvc.ParameterizableViewController;

public class LoginInterseptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("--------LoginInterseptor -preHandle()---");
		String viewName = "";
		if (handler instanceof ParameterizableViewController) {
			viewName = ((ParameterizableViewController)handler).getViewName();
		}
		String url = request.getRequestURI();
		System.out.println("url:" + url);
		
		// 从Session中取出数据。
		Object o = request.getSession(true).getAttribute("userInfo");
		if("/autoLogin".equals(url)|| "/login".equals(url) || "/".equals(url) || "/adminLogin".equals(url)|| (o!=null) ){
			return true;
		}
		if(null == o) {// 在没有登录的情况下，查看是否有可自动登录的Cookie
			Cookie[] cookies = request.getCookies();
			boolean loginName = false;
			boolean pwd = false;
			for(Cookie  c : cookies) {
				String name = c.getName();
				String val = c.getValue();
				if("loginName".equals(name) && val!=null) {
					loginName = true;
				}
				if("pwd".equals(name) && val!=null) {
					pwd = true;
				}
			}
			if(loginName && pwd) {
				response.sendRedirect("/autoLogin");//响应对象向浏览器发送一个重定向指令。
			}
		}
		
		
		
		
		return false;
	}

	
}
