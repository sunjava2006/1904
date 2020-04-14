package com.thzhima.fuxi.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;


@WebFilter("/*")
public class GeneralFilter implements Filter {

	public void init(FilterConfig fConfig) throws ServletException {
		
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		
		HttpServletRequest req = (HttpServletRequest) request;
		String uri = req.getRequestURI();
		StringBuffer url = req.getRequestURL();
		System.out.println(uri);
		if("/".equals(uri) || "/index.jsp".equals(uri) || "/login.jsp".equals(uri) || "/login".equals(uri) || "/regist".equals(uri)) {
			chain.doFilter(request, response);
		}else {
			Object o = req.getSession(true).getAttribute("userInfo");
			if(o==null) {
				response.setCharacterEncoding("utf-8");
				response.setContentType("text/html; charset=utf-8"); 
				response.getWriter().print("ƒ„œÎ∏… ≤√¥£ø∞°£ø£ø£ø£°");
			}else {
				chain.doFilter(request, response);
			}
			
		}
		
		
		
		
	}

	public void destroy() {
		
	}
	

}
