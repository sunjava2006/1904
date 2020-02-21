package com.wangrui.location.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.wangrui.location.entity.MyClass;
import com.wangrui.location.service.ClassService;

@Controller
//@RequestMapping("/class")
public class ClassController {

	@Autowired
	private ClassService classService;
	
//	@RequestMapping("/class_manage")
//	public String toClassManage() {
//		return "class_manage";
//	}
	
	
	// Controller
	@RequestMapping(value="/addclass", method=RequestMethod.POST  ) // http://localhost:9999/class/addclass
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
	
	@RequestMapping("/searchClass")
	public String searchClass(@RequestParam(required = false)String className,
			                  @RequestParam(defaultValue = "1") int page,
			                  @RequestParam(defaultValue = "2")int size, 
			                  Model m) {
		List<MyClass> list = null;
		if(className==null || "".equals(className.trim())) {
			list = this.classService.list(page, size);
		}else {
			MyClass c = this.classService.findByName(className);
			if(c!=null) {
				list = new ArrayList<>();
				list.add(c);
			}
			
		}
		
		m.addAttribute("list", list);
		m.addAttribute("page", page);
		m.addAttribute("totalPage", this.classService.totalPage(size));
		
		return "class_manage";
	}
	
	@RequestMapping(path = "/delClass")
	public String delClass(String name, @RequestHeader("Referer") String url ) {
		
		String viewName = "redirect:"+url;
		
		this.classService.deleteByName(name);
		
		System.out.println("----------------------------------------"+viewName);
		return viewName;
	}
}
