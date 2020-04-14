package com.thzhima.fuxi.reglog;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import com.thzhima.fuxi.service.UserService;


@WebServlet(value="/regist", loadOnStartup = 1)
public class RegistServlet implements Servlet{

	@Override // �����Servlet���󱻴����Ժ����
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init------------");
		
	}


	@Override // ���û�����ʱ�����á�
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		
		
		// ȡ���������������ݡ�
		String userName = req.getParameter("userName");
        System.out.println(userName);
		// �ֶ�ת��
//		userName = new String(userName.getBytes("iso-8859-1"),"utf-8");
		
		String pwd = req.getParameter("pwd");
		
		// ����ҵ�񷽷�
		try {
			UserService us = new UserService();
			us.regist(userName, pwd);
			
			req.setAttribute("msg", "���"+userName+",ע��ɹ�");
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("msg", "���,ע��ʧ�ܣ������ԡ�");
		}
		
		// ����ת��
		req.getRequestDispatcher("/RegistOk.jsp").forward(req, res);
		
	}
	
	@Override // ����ֹ֮ͣǰ���������Servlet����֮ǰ���á�
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	
	//-=================================================
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

}
