package com.wangrui.small;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/regist")
public class RegistServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("-------------/regist------");
		//request.setCharacterEncoding("utf-8");// ��������ı���
		
		String userName = request.getParameter("userName");
		String pwd = request.getParameter("password");
		
		System.out.println("ע�ᵽϵͳ �С�����������������������������");
		
		request.getSession(true).setAttribute("userInfo", userName);
		
		request.getRequestDispatcher("/regOk.jsp").forward(request, response);
		
	}

}
