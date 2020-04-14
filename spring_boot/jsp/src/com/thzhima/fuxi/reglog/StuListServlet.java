package com.thzhima.fuxi.reglog;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thzhima.fuxi.bean.Student;
import com.thzhima.fuxi.service.UserService;

@WebServlet("/stuList")
public class StuListServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String page = req.getParameter("page");
		String len = req.getParameter("len");
		
		UserService us = new UserService();
		
		int intPage = Integer.valueOf(page);
		int intLen = Integer.valueOf(len);
		
		List<Student> li = us.list(intPage, intLen);
		long totalCount = us.totalCount();
		long totalPage = us.totalPage(intLen);
		
		req.setAttribute("list", li); // 传递数据
		req.setAttribute("totalCount", totalCount);
		req.setAttribute("totalPage", totalPage);
		req.setAttribute("currPage", (long)intPage);
		
		req.getRequestDispatcher("/StuList.jsp").forward(req, resp);//请求转发
		
	}

	
}
