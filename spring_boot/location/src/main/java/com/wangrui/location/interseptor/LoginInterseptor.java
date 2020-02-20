package com.wangrui.location.interseptor;

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
		Object o = request.getSession(true).getAttribute("userInfo");
		if("/".equals(url) || "/adminLogin".equals(url)|| (o!=null) ){
			return true;
		}
		
		
		return false;
	}

	
}
