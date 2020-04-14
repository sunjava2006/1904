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

	@Override // 在这个Servlet对象被创建以后调用
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init------------");
		
	}


	@Override // 当用户请求时，调用。
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		
		
		// 取出表单发送来的数据。
		String userName = req.getParameter("userName");
        System.out.println(userName);
		// 手动转码
//		userName = new String(userName.getBytes("iso-8859-1"),"utf-8");
		
		String pwd = req.getParameter("pwd");
		
		// 调用业务方法
		try {
			UserService us = new UserService();
			us.regist(userName, pwd);
			
			req.setAttribute("msg", "你好"+userName+",注册成功");
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("msg", "你好,注册失败，请重试。");
		}
		
		// 请求转发
		req.getRequestDispatcher("/RegistOk.jsp").forward(req, res);
		
	}
	
	@Override // 服务停止之前，销毁这个Servlet对象之前调用。
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
