package com.wangrui.location.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wangrui.location.entity.MyClass;
import com.wangrui.location.service.ClassService;

@Controller
public class ClassController {

	@Autowired
	private ClassService classService;
	
//	@RequestMapping("/class_manage")
//	public String toClassManage() {
//		return "class_manage";
//	}
	
	
	// Controller
	@RequestMapping("/addclass")
	public ModelAndView add(MyClass c) {
		System.out.println("----------/addclass------");
		
		// Model
		int count = this.classService.add(c);
		
		// View
		ModelAndView mv = new ModelAndView("class_manage");// 视图名
		if(count ==1) {
		   mv.addObject("msg", "添加成功"); // 添加数据
		}else {
			 mv.addObject("msg", "添加失败"); // 添加数据
		}
		
		return mv;
	}
}
