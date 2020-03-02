package com.wangrui.news;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet(urlPatterns="/login", loadOnStartup=1)
public class LoginServlet extends HttpServlet {
	
	//private String userName; 保存用户数据的变量，千万不能存储在成员变量了。
	
	
	private String charSet;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		this.charSet = config.getInitParameter("charSet");
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding(this.charSet);
		String userName = request.getParameter("userName");
		
		// request 表示一个用户请求的对象。这个对象是由服务器创建的。将与HTTP请求有关的数据，都存储在这个对象中。
		// 与HTTP协议有关的
		// 请求的方法是get/post/put/....
		String method = request.getMethod();
		System.out.println("method:" + method);
		
		// 请求的协议，服务器主机、端口是什么？
		String protocol = request.getProtocol();
		System.out.println("protocol: " + protocol);
		
		String serverName = request.getServerName();
		System.out.println("serverName: " + serverName);
		
		int serverPort = request.getServerPort();
		System.out.println("server Port : " + serverPort);
		
		
		// 客户机的地址、端口是什么？
		String remoteAddr = request.getRemoteAddr();
		System.out.println("remote addr : " + remoteAddr);
		
		int remotePort = request.getRemotePort();
		System.out.println("remote port : " + remotePort);
		
		
		// 请求的ContextPath是什么？/ /news 
		String appPath = request.getContextPath();
		System.out.println("context path:" + appPath);
		
		// URI?
		String uri = request.getRequestURI();
		System.out.println("uri :  " + uri );
		
		// URL?
		String url = request.getRequestURL().toString();
		System.out.println("url :  " + url);
		
		// 请求的参数是什么？    http://localhost:8888/login?userName=wang&pwd=123
		String queryString =  request.getQueryString();
		System.out.println("query string : " + queryString);
		
		String useName = request.getParameter("userName");
		String pwd = request.getParameter("pwd");
		System.out.println("userName : " + userName);
		System.out.println("pwd : " + pwd);
		
		Enumeration<String> names = request.getParameterNames();
		while(names.hasMoreElements()) {
			String name = names.nextElement();
			System.out.println(name + ":" + request.getParameter(name));
		}
		
		// Http请求头中的信息
		
		String cacheControl = request.getHeader("Cache-Control");
		System.out.println("cacheControl : " + cacheControl);
		
		String connection = request.getHeader("Connection");
		System.out.println("connection : " + connection);
		
		
		
		
		//userName = new String(userName.getBytes("iso-8859-1"),"utf-8");
		System.out.println(userName);
		
		response.setCharacterEncoding(this.charSet);
		response.setContentType("text/html;charset="+this.charSet);
		
		response.getWriter().write(userName);
	}

	

	

}
