package com.wangrui.zmall.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wangrui.zmall.entity.Product;
import com.wangrui.zmall.service.ProductService;


@WebServlet("/add")
public class AddServlet extends HttpServlet {
	
//	ProductService ps = new ProductService();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String desc = request.getParameter("desc");
		String price = request.getParameter("price");
		String unit = request.getParameter("unit");
		
		ProductService ps = new ProductService();
		
		Product p = new Product(null, name, desc, new BigDecimal(price), unit, new Date());
		
		if(ps.add(p)) {// 添加商品，并判断是否成功
			request.setAttribute("page", 1);
			request.setAttribute("size", 10);
			request.getRequestDispatcher("/list").forward(request, response);
		}else {//失败
			request.setAttribute("msg", "添加商品失败，请重试或联系管理员。");
			request.getRequestDispatcher("/Add.jsp").forward(request, response);
		}
	}

}
