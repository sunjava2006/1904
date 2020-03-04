package com.wangrui.small.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


@WebFilter("/*")
public class CharsetFilter implements Filter {

	private String charSet;
	
	public void init(FilterConfig config) throws ServletException {
		this.charSet = config.getServletContext().getInitParameter("charSet");
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("--------------进入过滤器 /*  CharsetFilter--------------");
		request.setCharacterEncoding(this.charSet);

		// pass the request along the filter chain
		chain.doFilter(request, response);
		System.out.println("--------------过滤器 /*  CharsetFilter   返回--------------");
	}


	public void destroy() {
		
	}

}
