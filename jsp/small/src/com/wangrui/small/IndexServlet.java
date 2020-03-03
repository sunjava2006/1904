package com.wangrui.small;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/index")
public class IndexServlet extends HttpServlet {
	
//	public static final String TOTAL_ACCESS = "totalAccess";
	
	private ServletContext application;
	private String charSet;
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		application = config.getServletContext();//  获取全局对象
		
		// 为全局对象设置初始值
//		Object  o = application.getAttribute(TOTAL_ACCESS);
//		if(null == o) {
//			application.setAttribute(TOTAL_ACCESS, 0);
//		}
		
		// 取全局对象配置参数
		this.charSet = application.getInitParameter("charSet");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		ServletContext application = this.getServletContext();// 获取Application对象
//		application = request.getServletContext();
//		application = request.getSession(true).getServletContext();
		
//		int count = (int)this.application.getAttribute(TOTAL_ACCESS);
//		this.application.setAttribute(TOTAL_ACCESS, count+1);
		
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

}
