package com.wangrui.news.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.wangrui.news.service.UserService;

public class HelloServlet implements Servlet{

	public HelloServlet() {
		System.out.println("------------------ 构造 -----------------");
	}
	
	@Override
	public void init(ServletConfig arg0) throws ServletException {
		System.out.println("------------------ init -----------------");
	}
	
	@Override
	public void destroy() {
		System.out.println("-------------destory-----------------");
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	

	// 为用户的请求提供服务的方法
	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// request 对象是用户的请求对象。用户发送的所有数据和请求头中的所有数据，都在这里面。
		// 取参数
		request.setCharacterEncoding("utf-8");
		String userName = request.getParameter("userName"); // 取用户名
		String passwd  = request.getParameter("passwd"); // 取密码

		System.out.println("------------------调用业务方法，完成用户登录------------------------------");
		UserService us = new UserService();
		boolean ok = us.login(userName, passwd);
		
		//---------------- 根据结果返回视图 ------------------
		if(ok) {
			HttpServletRequest req = (HttpServletRequest) request;
			HttpSession session = req.getSession(true);
			session.setAttribute("userInfo", userName);
			
			// 请求转发
			RequestDispatcher rd = request.getRequestDispatcher("/manage_news.jsp");
			request.setAttribute("user", userName);
			rd.forward(request, response);
			
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
			request.setAttribute("msg", "登录失败");
			rd.forward(request, response);
		}
		
		// response 响应对象。可以进行输出。  不是最好的方法。
//		response.setCharacterEncoding("utf-8");
//		response.setContentType("text/html; charset=utf-8"); 
//		response.getWriter().print("<!DOCTYPE html>\r\n" + 
//				"<html>\r\n" + 
//				"<head>\r\n" + 
//				"<meta charset=\"UTF-8\">\r\n" + 
//				"<title>Insert title here</title>\r\n" + 
//				"</head>\r\n" + 
//				"<body>\r\n" + "你好："+userName+
//				"   <h1>新闻发布管理</h1>\r\n" + 
//				"</body>\r\n" + 
//				"</html>");
		
	}

}
