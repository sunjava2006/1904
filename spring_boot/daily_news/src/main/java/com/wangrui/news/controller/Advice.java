package com.wangrui.news.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class Advice {
	
	@ExceptionHandler()
	public ModelAndView execHandler(Exception ex, 
			                        HttpServletRequest request,
			                        HttpServletResponse response
			                        ) {
		
		System.out.println("exception Name: "+ex.getClass().getName());
		ModelAndView mv = new ModelAndView();
		mv.setViewName("exception");
		mv.addObject("msg", "出错啦。。。。。。。。。");
		
		return mv;
		
	}
	
	
	@ModelAttribute("info")
	public String publicInfo() {
//		Map map = new HashMap();
//		map.put("hi", "Hello world.");
		return "hello world.";
	}

}
