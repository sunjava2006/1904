package com.wangrui.news;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/test2")
public class Test2Servlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// response 表示响应的对象
		
		// http响应头
		response.setCharacterEncoding("utf-8");
		response.setHeader("Content-Type", "application/json;charSet=utf-8");
		
		
		// 1、返回给浏览器内容
		String data = "{\"name\":\"王瑞\"}";
		response.getWriter().write(data);
		
	}

}
