package com.wangrui.news.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/regist")
public class RegistServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		Object o = session.getAttribute("code");
		
		if(o!=null) {
			String sessionCode = (String)o;
			// 请求发送来的验证码
			String code = request.getParameter("code");
			
			if(sessionCode.equals(code)) { // 验证码相同
				// 注册
				String userName = request.getParameter("userName");
				String password = request.getParameter("password");
				
				// 请求转发到成功页面
				request.getRequestDispatcher("/regOk.jsp").forward(request, response);
				
			}else {
				// 请求转发到注册页面
				request.setAttribute("msg", "验证码不正确");
				request.getRequestDispatcher("/regist.jsp").forward(request, response);
			}
			
		}
		
		
		
	}

}
