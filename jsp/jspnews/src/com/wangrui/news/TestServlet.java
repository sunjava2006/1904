package com.wangrui.news;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/test")
public class TestServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("--------------in servlet------------------");
		
		System.out.println(request);
		System.out.println(response);
		
		
		String name = request.getParameter("userName");
		String ok = "你好";
		if("admin".equals(name)) {
			ok = "您好";
		}
		
		request.setAttribute("msg", ok);// 往request中放数据。在这一次请求中，所有组件都可以从request中存取数据。
		
		// 请求转发给jsp
		request.getRequestDispatcher("/test.jsp").forward(request, response);
	}

}
