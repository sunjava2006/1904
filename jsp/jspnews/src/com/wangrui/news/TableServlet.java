package com.wangrui.news;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/table")
public class TableServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.addHeader("Content-Type", "application/vnd.ms-excel");
		
		String data  = "<table><tr><td>hello</td></tr></table>";
		response.getWriter().write(data);
	}

}
