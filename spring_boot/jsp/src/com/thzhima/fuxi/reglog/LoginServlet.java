package com.thzhima.fuxi.reglog;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.thzhima.fuxi.bean.Student;
import com.thzhima.fuxi.service.UserService;



public class LoginServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String pwd = request.getParameter("pwd");
		
		UserService us = new UserService();
		Student s = us.login(userName, pwd);
		
		if(null != s) {
			HttpSession session = request.getSession(true);
			session.setAttribute("userInfo", s);
//			session.getServletContext();
		}
		
//		this.getServletContext();
//		request.getServletContext();
		
		
		response.sendRedirect("/"); // ÷ÿ∂®œÚ
	}

}
