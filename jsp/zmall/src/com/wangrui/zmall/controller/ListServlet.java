package com.wangrui.zmall.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wangrui.zmall.entity.Product;
import com.wangrui.zmall.service.ProductService;


@WebServlet("/list")
public class ListServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ProductService ps = new ProductService();
		String page = request.getParameter("page");
		String size = request.getParameter("size");
		int pp = 1;
		int ss = 10;
		if(page==null || size == null) {
			
			pp = (int)request.getAttribute("page");
			ss = (int)request.getAttribute("size");
		}
		else {
			pp = Integer.parseInt(page);
			ss = Integer.parseInt(size);
		}
		
		List<Product> list = ps.listByPage(pp, ss);
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("/Add.jsp").forward(request, response);
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
