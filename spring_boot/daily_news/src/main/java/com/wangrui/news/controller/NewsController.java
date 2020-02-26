package com.wangrui.news.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.wangrui.news.entity.News;

@Controller
public class NewsController {

	@Value("${uploadPath}")
	private String dir;
	
	
	@RequestMapping("/publish")
	@ResponseBody
	public String publish(News news, @RequestParam(name= "picture") MultipartFile[] pictures) throws IllegalStateException, IOException {
		
		File dirFile = new File(dir);
		System.out.println(dirFile.exists());
		System.out.println(dirFile.isDirectory());
		dirFile.setWritable(true);
		
		for(MultipartFile mf : pictures) {
			String name = mf.getOriginalFilename();
			
			if(name!=null && (!"".equals(name))) {
				int dotAt = name.lastIndexOf(".");
				String surfix = name.substring(dotAt);
				String newName = System.currentTimeMillis()+surfix;
			    mf.transferTo(new File(dirFile, newName));
			}
		}
		
		return "ok";
	}
	

	@RequestMapping("/calculate")
	@ResponseBody
	public int calculate(int a, int b) {
		return a/b;
	}
	
	@RequestMapping("/ok")
	public ModelAndView test(ModelAndView mv) {
		
		mv.setViewName("ok");
		mv.addObject("msg", "good morning");
		return mv;
		
	}
	
	@GetMapping("/news/{id}")
	@ResponseBody
	//@CrossOrigin(allowedHeaders = "*", maxAge = 18, origins = {"http://localhost:5500","http://127.0.0.1:5500"})
	public String get(@PathVariable(name = "id") int id,
			          String callback, 
			          HttpServletResponse response) {
		//response.addHeader("Access-Control-Allow-Origin", "*");
//		News n = new News();
//		n.setTitle("Intel 10 代 U 笔记本电脑");
//		n.setContent("10代U有14nm和10nm两种不同的类型。。。。。");
		String s = callback+"( "
				   +"{title:'intel', content:'10代U。。。。。'}"
				+ ")";
		return s;
	}
	
}
