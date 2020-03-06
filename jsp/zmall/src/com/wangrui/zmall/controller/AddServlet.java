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
		
		if(ps.add(p)) {// �����Ʒ�����ж��Ƿ�ɹ�
			request.setAttribute("page", 1);
			request.setAttribute("size", 10);
			request.getRequestDispatcher("/list").forward(request, response);
		}else {//ʧ��
			request.setAttribute("msg", "�����Ʒʧ�ܣ������Ի���ϵ����Ա��");
			request.getRequestDispatcher("/Add.jsp").forward(request, response);
		}
	}

}
