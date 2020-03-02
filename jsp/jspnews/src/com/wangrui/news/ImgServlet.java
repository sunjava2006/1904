package com.wangrui.news;

import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/img")
public class ImgServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 设置响应头
		response.addHeader("content-disposition", "attachment;filename=a.jpg");
		
		// 输出内容
		ServletContext application = this.getServletContext();
		String path = application.getRealPath("/th.jpg"); // 获取URL路径，对应的磁盘目录文件位置。
		System.out.println(path);
		
		FileInputStream fin = new FileInputStream(path);
		byte[] buffer  = new byte[1024];
		ServletOutputStream out = response.getOutputStream();
		int count = -1;
		while(-1 != (count = fin.read(buffer))) {
			out.write(buffer, 0, count);
		}
		fin.close();
		out.flush();

	}

}
